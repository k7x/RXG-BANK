import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
class recharge extends JFrame implements ActionListener
{
    JPanel panel;
    JPasswordField t2;
    JTextField t1,t3,t4;
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    transparent obj1;
    String acnt , pass;
    void label()
    {
        obj1=new  transparent();

        l1=new JLabel("REACHARGE YOUR PHONE");
        l1.setFont(new Font(null,Font.BOLD,20));
        l2=new JLabel("Account:");
        l3=new JLabel("Password :") ;
        l4=new JLabel("Phone no:");
        l5=new JLabel("Amt:");
    }


    void textfield()
    {
        t1=new JTextField(11);
        t2=new JPasswordField();
        t2.setEchoChar('*');
        t3=new JTextField(10);
        t4=new JTextField(10);
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


    void createframe()
    {

        setSize(300,250);
        setLocation(530,250);
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
        p1.setLayout(new GridLayout(4,2,10,20));
        p1.setLocation(20,20);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p1.add(l5);
        p1.add(t4);
        p2.add(l1);
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
        recharge obj=new recharge();
        obj.label();
        obj.textfield();
        obj.panel();

        obj.button();
        obj.createframe();


    }
    public void actionPerformed(ActionEvent e)
    {
        String a[]= new String[7];
        boolean bl = false,b2=true;
       
        if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);
        }
        else if(t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0
        &&t4.getText().length()>0)
        {
             try{
            double db = Double.parseDouble(t3.getText());
            db = Double.parseDouble(t4.getText());
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
            
            
            String b[] = new String[11];
            int i =0;   
            if((new File(t1.getText()+".txt")).exists()==true){
                if(t3.getText().length()!=10)
                    JOptionPane.showMessageDialog(null,"  PHONE NO ONLY 10 DIGITS  "," PHONE NO DIGITS ",
                        JOptionPane.ERROR_MESSAGE);
                else {
                    try{
                        FileReader fr = new FileReader(t1.getText()+".txt");
                        Scanner sc=new Scanner(fr);
                        while(sc.hasNext()==true)
                        {
                            b[i++]=sc.nextLine();
                        }
                        fr.close();

                        if(t2.getText().equals(b[6]))
                        {

                            String b1[] = new String[100];
                            int j =0;
                            FileReader fr1 = new FileReader(t1.getText()+"transact.txt");
                            Scanner sc1=new Scanner(fr1);
                            while(sc1.hasNext()==true)
                            {

                                b1[j++]=sc1.nextLine();

                            }
                            fr1.close();
                            String z[] = b1[0].split(":");
                            if(Double.parseDouble((z[1]+1))>Double.parseDouble(t4.getText())&&Double.parseDouble(t4.getText())>0)
                            {

                                b1[0] =Double.toString(Double.parseDouble(z[1])-Double.parseDouble(t4.getText()));

                                DateFormat h= new SimpleDateFormat("yyyy/MM/dd     hh:mm:ss aaa ");
                                Date o = new Date();

                                try
                                {
                                    

                                    FileWriter fw11 = new FileWriter(t1.getText()+"transact.txt");

                                    BufferedWriter bw11 = new BufferedWriter(fw11);
                                    PrintWriter of11 = new PrintWriter(bw11);

                                    of11.println("BALANCE :"+b1[0]);
                                    int k= 1;
                                    while(k<j)
                                    {
                                        of11.println(b1[k++]);
                                    }
                                    of11.println(h.format(o)+" by RECHARGE "+"  -  "+t4.getText()+"  "+b1[0]);

                                    of11.close();
                                    bl= true;

                                }
                                catch(Exception y)
                                {
                                    System.err.println(y);
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"  BALANCE IS NOT SUFFICIENT  "," BALANCE ",
                                    JOptionPane.ERROR_MESSAGE);

                            }

                        }
                        else
                        {

                            JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWARD ",
                                JOptionPane.ERROR_MESSAGE);    
                        }

                    }catch(Exception e1)
                    {
                        System.err.println(e1);

                    }

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND YOU "," ACCOUNT NO. ",
                    JOptionPane.PLAIN_MESSAGE);

            }
            if(bl==true){
                setVisible(false);
                obj1.setVisible(false);}
        }
    }
        else
        {

            JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NOT FILLED PROPERLY" ," READ CAREFULLY ",
                JOptionPane.PLAIN_MESSAGE);
    }
   }
    }
