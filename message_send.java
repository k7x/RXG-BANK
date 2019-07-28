import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.*;
class message_send extends JFrame implements ActionListener
{ 
    JPanel panel;
    JTextArea t;
    JTextField t1;
    JButton b1,b2;
    transparent obj1;
    String fl ,nm;
    void create_f()
    {
        obj1 = new transparent();
        panel = new JPanel();
        panel.setLayout(null);
        setSize(300,200);
        setLocation(500,200);
        getContentPane().add(panel);
        setUndecorated(true);

    }

    void label()
    {
        JLabel l = new JLabel(" I.D. ");
        l.setSize(100,20);
        l.setLocation(20,20);
        l.setFont( new Font("",Font.BOLD,15));
        JLabel l1 = new JLabel("TYPE YOUR MESSAGE");
        l1.setSize(250,20);
        l1.setLocation(35,60);
        l1.setFont( new Font("",Font.BOLD,20));

        t = new JTextArea();
        t.setLocation(10,80);
        t.setSize(250,60);

        t1 = new JTextField();
        t1.setLocation(60,20);
        t1.setSize(150,20);

        panel.add(l);
        panel.add(l1);
        panel.add(t);
        panel.add(t1);
    }

    void button()
    {
        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b2=new JButton("CANCEL");
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b1.setLocation(30,150);
        b1.setSize(80,25);
        b2.setLocation(130,150);
        b2.setSize(80,25);
        panel.add(b1);
        panel.add(b2);

    }

    public static void main(String a ,String b )
    {
        message_send  o = new message_send ();

        o.nm =b;
        o.fl =a;
        o.create_f();
        o.button();
        o.label();
        o.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        String b[] = new String[11];
        int i= 0;
        if(e.getActionCommand()=="CANCEL")
        {
            obj1.setVisible(false);
            setVisible(false);
        }
        else if(t.getText().length()>0&&t1.getText().length()>0)
        {
            if(t.getText().length()>160&&((new File(t1.getText()+"msg.txt")).exists()==true)){
                JOptionPane.showMessageDialog(null," OOPS! ONLY 160 CHARACTERS." ," MESSAGES ",
                    JOptionPane.PLAIN_MESSAGE);
            }
            else if((new File(t1.getText()+"msg.txt")).exists()==true){

                int k =0;

                try{
                    FileReader fr = new FileReader(t1.getText()+"msg.txt");
                    Scanner sc=new Scanner(fr);
                    while(sc.hasNext()==true)
                    {
                        k=k+1;
                        String a= sc.nextLine();
                    }
                    sc.close();
                    fr.close();
                    if(k>=4)
                    {
                        JOptionPane.showMessageDialog(null,"  SORRY ! THE USER ACCOUNT IS TEMPRARIOLY UNAVIALBLE." ," READ CAREFULLY ",
                            JOptionPane.PLAIN_MESSAGE);
                        obj1.setVisible(false);
                        setVisible(false);  
                        return;
                    }

                    FileWriter fw1 = new FileWriter(t1.getText()+"msg.txt",true);

                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    PrintWriter of1 = new PrintWriter(bw1);

                    of1.println(nm+"__"+fl+": __"+t.getText());
                    of1.close();
                    fw1.close();
                    obj1.setVisible(false);
                    setVisible(false);
                }
                catch(Exception y)
                {
                    System.err.println(y);
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

            JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NOT FILLED PROPERLY" ," READ CAREFULLY ",
                JOptionPane.PLAIN_MESSAGE);
        }
    }
}