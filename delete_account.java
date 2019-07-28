import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class delete_account extends JFrame implements ActionListener
{
    JPanel panel;
    JTextArea t3;
    JPasswordField t2;
    JTextField t1;
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    transparent obj1;
    boolean as=false;
    void label()
    {
        obj1=new transparent();
        l1=new JLabel("DELETING ACCOUNT");
        l1.setFont(new Font(null,Font.BOLD,20));
        l2=new JLabel("ID:");
        l3=new JLabel("Password :") ;
        l4=new JLabel("Feed Back:");

    }

    void textfield()
    {
        t1=new JTextField(10);
        t2=new JPasswordField(10);
        t2.setEchoChar('*');
        t3=new JTextArea(5,25);

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
        setTitle("RECHARGE YOUR PHONE");
        setSize(350,300);
        setLocation(550,250);
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

        p2.add(l1);
        panel.add(p2);
        panel.add( p1);
        panel.add(new JScrollPane(t3));
        c.add (panel);
    }

    void visible(boolean a)
    {
        setVisible(true);

    }

    static void main()
    {
        delete_account obj=new delete_account();
        obj.label();
        obj.textfield();
        obj.panel();

        obj.button();
        obj.createframe();

    }

    public void actionPerformed(ActionEvent e)
    {
        String b[] = new String[11];int i =0;
        if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);
        }
        else if(t1.getText().length()>0&& t2.getText().length()>0)
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
                    try{
                        FileReader fr1 = new FileReader(t1.getText()+"transact.txt");
                        Scanner sc1=new Scanner(fr1);
                        String   b1=sc1.nextLine();
                        fr1.close();
                        String z[] = b1.split(":");
                        JOptionPane.showMessageDialog(null,"Debited Amount : "+z[1],"TRANSACTION",
                            JOptionPane.PLAIN_MESSAGE);

                        File f = new File(t1.getText()+".txt");
                        f.createNewFile();
                        as = f.delete();

                        f= null;
                        f = new File( t1.getText()+"msg.txt");
                        f.createNewFile();
                        as = f.delete();

                        f= null;
                        f = new File(t1.getText()+"transact.txt");
                        f.createNewFile();
                        as = f.delete();

                        setVisible(false);
                        obj1.setVisible(false);

                    }
                    catch(Exception y)
                    {
                        System.err.println(y);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  Password wrong ","PASSWORD ",
                        JOptionPane.PLAIN_MESSAGE);

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND YOU "," ACCOUNT NO. ",
                    JOptionPane.PLAIN_MESSAGE);

            }
        }
    }
}