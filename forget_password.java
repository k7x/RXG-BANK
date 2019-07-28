import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

class forget_password extends JFrame implements ActionListener
{
    JTextField t1,t2;
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel panel;
    transparent obj1;
    void label()
    {
        obj1= new transparent();
        l1=new JLabel("ENTER YOUR ACCOUTNT ID");
        l3=new JLabel("FORGET PASSWORD");
        l3.setFont(new Font(null,Font.BOLD,25));
        l2=new JLabel("ENTER PAN NUMBER");

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
        t1=new JTextField(16);
        t2=new JTextField(16);
        t1.setText("");
        t1.setText("")

        ;
    }

    void frame()
    {

        setSize(400,200);
        setLocation(500,250);
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
        panel=new JPanel(); 
        panel.setBackground(Color.white);
        JPanel p1,p2;
        p1=new JPanel();
        p1.setBackground(Color.white);
        p2=new JPanel();
        p2.setBackground(Color.white);
        p1.setLayout(new GridLayout(2,2,15,15));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p2.add(l3);
        panel.add(p2);
        panel.add(p1);
        c.add(panel);
    }

    static void main()
    {
        forget_password obj=new forget_password();
        obj.label();
        obj.textfield();    
        obj.panel();
        obj.button();
        obj.frame();
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
                if(t2.getText().equals(b[4])==true)
                {
                    obj1.setVisible(false);
                    setVisible(false);
                    change_password1.main(b);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  SORRY ! Wrong Input "," ACCOUNT NO. ",
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

            JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NOT FILED PROPERLY" ," READ CAREFULLY ",
                JOptionPane.PLAIN_MESSAGE);
        }
    }
}
