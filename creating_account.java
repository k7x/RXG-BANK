  import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
class creating_account extends JFrame implements ActionListener
{
    JPanel panel;
    JPasswordField t2;
    JTextField t1,t3;
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    String fl_name , pass  ;
    creating_account(String fl_nam , String pas  )
    {
        fl_name =fl_nam;
        pass=pas;

    }

    void label()
    {
        l1=new JLabel("CREATING ACCOUNT");
        l1.setFont(new Font(null,Font.BOLD,20));
        l2=new JLabel("User ID:");
        l3=new JLabel("Password :") ;
        l4=new JLabel("Amount:");

    }

    void textfield()
    {
        t1=new JTextField(11);
        t1.setText(fl_name);
        t1.setEditable(false);
        t2=new JPasswordField();
        t2.setEchoChar('*');
        t3=new JTextField(10);

    }

    void button()
    {
        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b2=new JButton("CANCEL");
        b2.setBackground(Color.white);
        
        b1.addActionListener(this);
        panel.add(b1);
        panel.add(b2);

    }


    void createframe()
    {

        setSize(300,250);
        setLocation(300,250);
        setUndecorated(true);
        visible(true);

    }


    void panel()
    {
        Container c=getContentPane();
        panel=new JPanel();
        panel.setBackground(Color.white);
        JPanel p1,p2;
        p1=new JPanel();
        p1.setBackground(Color.white);
        p2=new JPanel();
        p2.setBackground(Color.white);
        p1.setLayout(new GridLayout(3,2,10,20));
        p1.setLocation(20,20);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);

        panel.add(p2);
        panel.add( p1);
        p2.add(l1);
        c.add (panel);
    }   


    void visible(boolean a)
    {
        setVisible(true);
    }


    static void main(String f , String p )
    {
        creating_account obj=new creating_account(f,p);
        obj.label();
        obj.textfield();
        obj.panel();

        obj.button();
        obj.createframe();


    }


    public void actionPerformed(ActionEvent e)
    {
        String a[] = new String[12];
        boolean b2 = true;
        if(e.getActionCommand()=="CANCEL")
        {

            setVisible(false);
        }
        if(e.getActionCommand()=="NEXT"&&t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0)
        {
            try{
                double db = Double.parseDouble(t3.getText());

            }
            catch(Exception y)
            {
                b2=false;  
            }

            if(b2==false){
                JOptionPane.showMessageDialog(null,"DATAS ARE NOT FILLED AS PER INSTRUCTED","ERROR",
                    JOptionPane.ERROR_MESSAGE);

            }
            else{
                try
                {int i=0;
                    FileReader fr = new FileReader(t1.getText()+".txt");
                    Scanner sc=new Scanner(fr);
                    while(sc.hasNext()==true)
                    {
                        a[i++]=sc.nextLine();
                    }
                }
                catch(Exception ep)
                {
                    System.err.println(ep);
                }
                if(a[6].equals(t2.getText())){
                    DateFormat h= new SimpleDateFormat("yyyy/MM/dd     hh:mm:ss aaa ");
                    Date o = new Date();

                    try
                    {
                        FileWriter fw1 = new FileWriter(fl_name+"transact.txt");

                        BufferedWriter bw1 = new BufferedWriter(fw1);
                        PrintWriter of1 = new PrintWriter(bw1);

                        of1.println("BALANCE :"+t3.getText());
                        of1.println("DATE  TIME  PARICULATES CREDIT DEBIT BALANCE ");
                        of1.println(h.format(o)+" by Cash "+"  -  "+t3.getText()+"  "+t3.getText());

                        of1.close();

                        fw1 = new FileWriter(fl_name+"msg.txt");

                        bw1 = new BufferedWriter(fw1);
                        of1 = new PrintWriter(bw1);
                        of1.close();

                    }
                    catch(IOException y)
                    {
                        System.err.println(y);
                    }

                    setVisible(false);
                    LOGED_IN .main(fl_name);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  Wrong Password ,Not  "+a[1]," PASSWARD ",
                        JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }
}
