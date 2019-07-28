 import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
class change_Address extends JFrame implements ActionListener
{
    JTextField t1,t3,t4,t5,t6;
    JPasswordField t2;
    JLabel L1,l2,l3,L4,l5,l6,l7,l8;
    JButton b1,b2;
    transparent obj1;
    void label()
    {
        obj1=new transparent();
        L1=new JLabel(" CHANGE ADDRESS");    
        L1.setFont(new Font(null,Font.BOLD,25));
        l2=new JLabel("Enter ID");
        l3=new JLabel("Password");
        L4=new JLabel("   ADDRESS DETAILS");
        L4.setFont(new Font(null,Font.BOLD,20));
        l5=new JLabel("House Number");
        l6=new JLabel("City");
        l7=new JLabel("Pin");  
        l8=new JLabel("State"); 
    }


    void button()
    {
        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b2=new JButton("CANCEL");
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        b1.addActionListener(this);


    }
    void textfield()
    {
        t1=new JTextField(16);
        t2=new JPasswordField(10);

        t3=new JTextField(16);
        t4=new JTextField(16);
        t5=new JTextField(16);
        t6=new JTextField(16)

        ;
    }
    void frame()
    {

        setLayout(new FlowLayout());
        setSize(450,400);
        setLocation(475,250);
        setUndecorated(true);
        visible(true); 


    }
    void visible(boolean a)
    {
        setVisible(a);
    }
    void panel()
    {
        Container c=getContentPane();
        c.setBackground(Color.white);
        JPanel p1,p2;
        p1=new JPanel();
        p1.setBackground(Color.white);
        p2=new JPanel();
        p2.setBackground(Color.white);
        JPanel p3=new JPanel();  
        p1.setLayout(new GridLayout(2,2,5,25));
        add(L1);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p3.setBackground(Color.white);
        p3.setLayout(new GridLayout(5,2,5,25));
        p3.add(l5);
        p3.add(t3);
        p3.add(l6);
        p3.add(t4);
        p3.add(l7);
        p3.add(t5);
        p3.add(l8);
        p3.add(t6);       
        add(p1);
        add(L4);
        add(p3);
        add(p2);
        p2.add(b1);
        p2.add(b2);
        add(p2);
    }
    static void main()
    {
        change_Address obj=new change_Address();
        obj.label();
        obj.textfield();    

        obj.button();
        obj.panel();
        obj.

        frame();
    }
    public void actionPerformed(ActionEvent e)
    {
        String b[] = new String[12];
        int i= 0;
        if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);
        }
        else if(t1.getText().length()>0&& t2.getText().length()>0&& t3.getText().length()>0
        && t4.getText().length()>0&& t5.getText().length()>0&& t6.getText().length()>0)
        {
            
            if((new File(t1.getText()+".txt")).exists()==true){

                try{
                    FileReader fr = new FileReader(t1.getText()+".txt");
                    Scanner sc=new Scanner(fr);
                    while(sc.hasNext()==true)
                    {
                        b[i++]=sc.nextLine();
                    }
                    fr.close();

                }
                catch(Exception y)
                {
                    System.err.println(y);
                }
                if(t2.getText().equals(b[6])==true)
                {
                    b[8]= t3.getText();
                    b[9]= t4.getText();
                    b[10]= t5.getText();

                    i=0;

                    try {
                        FileWriter fw1 = new FileWriter(t1.getText()+".txt");

                        BufferedWriter bw1 = new BufferedWriter(fw1);
                        PrintWriter of1 = new PrintWriter(bw1);
                        while(i<10)
                        {

                            of1.println(b[i++]);

                        }
                        of1.println(b[10]);
                        of1.close();
                        setVisible(false);
                        obj1.setVisible(false);
                    }
                    catch(Exception e9)
                    {

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  SORRY ! Wrong  PASSWORD. "," PASSWORD. ",
                        JOptionPane.PLAIN_MESSAGE);

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND YOU "," ACCOUNT NO. ",
                    JOptionPane.PLAIN_MESSAGE);

            }

        } 
        else
        {

            JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NAUT FILLED PROPERLY" ," READ CAREFULLY ",
                JOptionPane.PLAIN_MESSAGE);
    }
}
}
