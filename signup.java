import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class signup extends JFrame implements ActionListener
{
    String a[]=new String[12];
    JPanel panel;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
    JButton b1,b2,b3,b4,b5;
    JPasswordField t6,t7;
    JTextField t1,t2,t3,t4,t5,t8,t9,t10,t11;
    String acntt;
    signup(String a)
    {
        acntt=a;
    }

    void label()
    {
        l1=new JLabel("OPENING A NEW ACCOUNT");
        l1.setFont(new Font(null,Font.BOLD,25));
        l1.setLocation(70,10);
        l1.setSize(500,20);
        l2=new JLabel("-----PERSONAL DATA-----");
        l2.setFont(new Font(null,Font.BOLD,15));
        l2.setLocation(130,60);
        l2.setSize(300,20);
        l3=new JLabel(" Name:");
        l3.setLocation(40,100);
        l3.setSize(100,20);

        l4=new JLabel(" Father name:");
        l4.setLocation(40,130);
        l4.setSize(100,20);

        l5=new JLabel(" Date of Birth:");
        l5.setLocation(40,160);
        l5.setSize(100,20);

        l6=new JLabel(" Adhar number:");
        l6.setLocation(40,190);
        l6.setSize(100,20);

        l7=new JLabel("Phone number:");
        l7.setLocation(40,220);
        l7.setSize(100,20);

        l8=new JLabel("Password:");
        l8.setLocation(40,250);
        l8.setSize(100,20);

        l9=new JLabel("Retype Password:"); 
        l9.setLocation(40,280);
        l9.setSize(100,20);

        l10=new JLabel("-----ADDRESS-----");
        l10.setLocation(150,310);
        l10.setSize(300,20);
        l10.setFont(new Font(null,Font.BOLD,15));

        l11=new JLabel("HOUSE number"); 
        l11.setLocation(40,340);
        l11.setSize(100,20);

        l12=new JLabel("City");
        l12.setLocation(40,370);
        l12.setSize(100,20);

        l13=new JLabel("PIN code");
        l13.setLocation(40,400);
        l13.setSize(100,20);

        l14=new JLabel("State");
        l14.setLocation(40,430);
        l14.setSize(100,20);

    }

    void textfield()
    {
        t1=new JTextField(16);
        t1.setLocation(170,100);
        t1.setSize(200,20);

        t2=new JTextField(16);
        t2.setLocation(170,130);
        t2.setSize(200,20);  

        t3=new JTextField(16);
        t3.setLocation(170,160);
        t3.setSize(200,20);

        t4=new JTextField(16);
        t4.setLocation(170,190);
        t4.setSize(200,20);

        t5=new JTextField(16);
        t5.setLocation(170,220);
        t5.setSize(200,20);

        t6=new JPasswordField(10);
        t6.setEchoChar('*');
        t6.setLocation(170,250);
        t6.setSize(200,20);

        t7=new JPasswordField(10);
        t7.setEchoChar('*');
        t7.setLocation(170,280);
        t7.setSize(200,20);

        t8=new JTextField(16);
        t8.setLocation(170,340);
        t8.setSize(200,20);

        t9=new JTextField(16);
        t9.setLocation(170,370);
        t9.setSize(200,20);

        t10=new JTextField(16);
        t10.setLocation(170,400);
        t10.setSize(200,20);

        t11=new JTextField(16);
        t11.setLocation(170,430);
        t11.setSize(200,20);

    }

    void button()
    {
        b1=new JButton("  NEXT  ");
        b1.setLocation(50,470);
        b1.setSize(100,25);
        b1.setBackground(Color.white);
        b2=new JButton("HOME");
        b2.setLocation(260,470);
        b2.setSize(100,25);
        b2.setBackground(Color.white);
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    void frame()
    {        
        setSize(450,550);
        setLocation(450,100);

        add(panel);
        setUndecorated(true);
        visible(true);    
    }

    void panel()
    {
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(t1);
        panel.add(l4);
        panel.add(t2);
        panel.add(l5);
        panel.add(t3);
        panel.add(l6);
        panel.add(t4);
        panel.add(l7);
        panel.add(t5);
        panel.add(l8);
        panel.add(t6);
        panel.add(l9);
        panel.add(t7);
        panel.add(l10);
        panel.add(l11);
        panel.add(t8);
        panel.add(l12);
        panel.add(t9);
        panel.add(l13);
        panel.add(t10);
        panel.add(l14);
        panel.add(t11);

        Container c=getContentPane();

        panel.add(b1);    
        panel.add(b2);
        c.add(panel);

    }


    void visible(boolean a)
    {
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand()=="HOME")
        {
            setVisible(false);
            HOMEPAGE.main();
        }
        else if(e.getActionCommand()=="  NEXT  "&&t1.getText().length()>0
        &&t2.getText().length()>0&&t3.getText().length()>0&&t4.getText().length()>0
        &&t5.getText().length()>0&&t6.getText().length()>0&&t7.getText().length()>0
        &&t8.getText().length()>0&&t9.getText().length()>0&&t10.getText().length()>0
        &&t11.getText().length()>0)
        {
            boolean b2= true;
            try{
                double db = Double.parseDouble(t5.getText());

            }
            catch(Exception y)
            {
                b2=false;  
            }
            a[0]=t1.getText();
            a[1]=t2.getText();
            a[2]=t3.getText();
            a[3]=t4.getText();
            a[4]=t5.getText();
            a[5]=t6.getText();
            a[6]=t7.getText();
            a[7]=t8.getText();
            a[8]=t9.getText();
            a[9]=t10.getText();
            a[10]=t11.getText();
            
            if(acntt == "SAVING")
                a[11]=t5.getText()+"1";
            else if(acntt == "CURRENT")
                a[11]=t5.getText()+"2";
            

            File o = new File(a[11]+".txt");
            
            if(a[6].equals( a[5])==false)
            {

                JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWORD ",
                    JOptionPane.ERROR_MESSAGE);
            }
            else if(a[4].length()!=10)
                JOptionPane.showMessageDialog(null,"  PHONE NO ONLY 10 DIGITS  "," PHONE NO DIGITS ",
                    JOptionPane.ERROR_MESSAGE);
            else if(b2==false)
            {
                JOptionPane.showMessageDialog(null,"  PHONE NO. ONLY DIGITS  "," PHONE NO  ",
                    JOptionPane.ERROR_MESSAGE);
            }
            else if(a[3].length()!=12)
                JOptionPane.showMessageDialog(null,"  AADHAR NO ONLY 12 DIGITS  "," AADHAR NO DIGITS ",
                    JOptionPane.ERROR_MESSAGE);
            else if(a[6].length()<4)
                JOptionPane.showMessageDialog(null,"  Password Maximum Length 4 Characters "," PASSWORD LENGTH ",
                    JOptionPane.ERROR_MESSAGE);
            else if(o.exists()==true)
            {
                
                JOptionPane.showMessageDialog(null,"  PLEASE TRY WITH OTHER PHONE No. "," Phone no ",
                    JOptionPane.ERROR_MESSAGE);

            }
            else{
                try
                {
                   
                    FileWriter fw1 = new FileWriter(a[11]+".txt");

                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    PrintWriter of1 = new PrintWriter(bw1);
                    of1.println(a[11]);
                    for(int i= 0;i<10;i++){
                        of1.println(a[i]);}
                    of1.close();

                    setVisible(false);
                    creating_account.main(a[11],a[6]);
                }
                catch(IOException y)
                {
                    System.err.println(y);
                }
            }}

    }

    static void main(String acnt)
    {
        signup obj=new signup(acnt);

        obj.label();
        obj.textfield();
        obj.button();
        obj.panel();
        obj.frame();
    }
}
