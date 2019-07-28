import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class changepassword extends JFrame implements ActionListener
{
    JPanel panel;
    JPasswordField t2,t4,t3;
    JLabel L1,l2,l3,l4,l5;
    JButton b1,b2;
    transparent obj1;
    JTextField t1;
    void label()
    {
        obj1= new transparent();
        L1=new JLabel("CHANGE PASSWORD:");
        L1.setFont(new Font(null,Font.BOLD,25));
        l2=new JLabel("Account ID:");
        l3=new JLabel("Current Password:");

        l4=new JLabel("New Password:");
        l5=new JLabel("Retype Password:");
    }


    void button()
    {
        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b2=new JButton("CANCEL");
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        b1.addActionListener(this);
        panel.add(b1);
        panel.add(b2);
    }


    void textfield()
    {
        t1=new JTextField(10);
        t2=new JPasswordField(10);
        t2.setEchoChar('*');
        t3=new JPasswordField(10);
        t3.setEchoChar('*');        
        t4=new JPasswordField(10);
        t4.setEchoChar('*');        
    }


    void createframe()
    {

        setSize(300,280);
        setLocation(500,250);
        setUndecorated(true);
        setVisible(true); 

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
        p1.setLayout(new GridLayout(4,2,10,30));
        p1.setLocation(20,20);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p2.add(L1);
        panel.add(p2);
        panel.add( p1);
        c.add (panel);

    }


    void visible(boolean a)
    {
        setVisible(true);


    }
    static void main()
    {
        changepassword obj=new changepassword();
        obj.label();
        obj.textfield();        
        obj.panel();
        obj.button();
        obj.createframe();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);
        }
        else if (t1.getText().length()>0&&
        t2.getText().length()>0&&t3.getText().length()>0)
        {

            String a[]= new String[11];
            if((new File(t1.getText()+".txt")).exists()==true){
                try
                {  int i=0;
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

                    if(t3.getText().equals(t4.getText())){
                        a[6] =t3.getText();
                        a[7] =t3.getText();

                        int k =0;
                        try{
                            FileWriter fw1 = new FileWriter(t1.getText()+".txt");

                            BufferedWriter bw1 = new BufferedWriter(fw1);
                            PrintWriter of1 = new PrintWriter(bw1);
                            while(k<a.length)
                            {

                                of1.println(a[k++]);

                            }

                            of1.close();
                            setVisible(false);
                            obj1.setVisible(false);}
                        catch (Exception eo){

                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null," NEW  PASSWORD DOES NOT MATCH EACH OTHER "," PASSOARD ",
                            JOptionPane.ERROR_MESSAGE);
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWORD ",
                        JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        else
            JOptionPane.showMessageDialog(null,"  DATAS NOT FILLED "," READ CAREFULY  ",
                JOptionPane.ERROR_MESSAGE);
    }
}