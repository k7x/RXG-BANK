import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class change_password1 extends JFrame implements ActionListener
{
    JPanel panel;
    JPasswordField t1,t2;
    JLabel l1,l2,l3;
    JButton b1,b2;
    transparent obj1;
    static String f ;
    String dat[];
    void label(String a,String a1[])
    {
        dat=a1;
        obj1 = new transparent();
        l1=new JLabel(a);
        l1.setFont(new Font(null,Font.BOLD,20));
        l2=new JLabel("New Password:");
        l3=new JLabel("Confirm Password :") ;

    }

    void textfield()
    {
        t1=new JPasswordField(10);
        t1.setEchoChar('*');
        t2=new JPasswordField(10);
        t2.setEchoChar('*');

    }

    void button()
    {
        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b2=new JButton("CANCEL");
        b1.addActionListener(this);
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        panel.add(b1);
        panel.add(b2);
    }

    void createframe()
    {

        setSize(250,180);
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
        p1.setLayout(new GridLayout(2,2,10,30));
        p1.setLocation(20,20);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);

        p2.add(l1);
        panel.add(p2);
        panel.add( p1);
        c.add (panel);
    }

    void visible(boolean a)
    {
        setVisible(true);

    }


    static void main(String a[])
    {
        change_password1 obj=new change_password1();
        obj.label("CHANGE PASSWORD",a);
        obj.textfield();
        obj.panel();

        obj.button();
        obj.createframe();
    }


    static void main(String a,String b)
    {
        f=b;
        change_password1 obj=new change_password1();
        obj.label(a,null);
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
        if(t1.getText().length()>0&&t1.getText().length()>0){
            if(t1.getText().equals(t1.getText())){
                if(l1.getText().equals("CHANGE PASSWORD")==false)
                {

                    if(t1.getText().equals(t2.getText())){
                        try
                        {
                            String b1[] = new String[100];
                            int j =0;
                            String be=t1.getText();

                            FileReader fr1 = new FileReader(f+".txt");
                            Scanner sc1=new Scanner(fr1);
                            while(sc1.hasNext()==true)
                            {

                                b1[j++]=sc1.nextLine();

                            }
                            fr1.close();

                            int k =0;

                            FileWriter fw1 = new FileWriter(f+".txt");

                            BufferedWriter bw1 = new BufferedWriter(fw1);
                            PrintWriter of1 = new PrintWriter(bw1);
                            while(k<j-1)
                            {

                                of1.println(b1[k++]);

                            }

                            of1.println(b1[k]+"__"+be);
                            of1.close();

                            setVisible(false);
                            obj1.setVisible(false);

                        }
                        catch(IOException y)
                        {
                            System.err.println(y);
                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"  SOORRY ! DATAS ARE NOT MATCHING" ," READ CAREFULLY ",
                            JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else
                {
                    int i= 0;
                    dat[6]=t1.getText();
                    dat[7]=t1.getText();
                    try {
                        FileWriter fw1 = new FileWriter(dat[0]+".txt");

                        BufferedWriter bw1 = new BufferedWriter(fw1);
                        PrintWriter of1 = new PrintWriter(bw1);
                        while(i<dat.length)
                        {

                            of1.println(dat[i++]);

                        }
                        of1.close();
                    }
                    catch(Exception e9)
                    {

                    }

                    setVisible(false);
                    obj1.setVisible(false);

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NOT MATCHING" ," READ CAREFULLY ",
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
