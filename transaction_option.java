 import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class transaction_option extends JFrame implements ActionListener
{
    JPanel panel;

    JRadioButton  t1,t2;
    JLabel l1;
    JButton b1,b2;
    transparent obj1;
    void createframe()
    {
        obj1=new transparent();
        setSize(200,200);
        setLocation(600,250);
        setUndecorated(true);
        visible(true);

    }


    void label()
    {
        l1=new JLabel("TRANSACTION");
        l1.setFont(new Font(null,Font.BOLD,20));

    }


    void textfield()
    {
        t1=new JRadioButton("Debit ");
        t1.setBackground(Color.white);
        t2=new JRadioButton("Credit ");
        t2.setBackground(Color.white);
        ButtonGroup b = new ButtonGroup();
        t1.addActionListener(this);
        t2.addActionListener(this);
        b.add(t1);
        b.add(t2);

    }


    void button()
    {
        b1=new JButton("NEXT");
        b2=new JButton("CANCEL");
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        JPanel p1=new JPanel();
        b1.addActionListener(this);
        b2.addActionListener(this);
        p1.setBackground(Color.white);
        p1.add(b1);
        p1.add(b2);
        panel.add(p1);

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
        p1.setLayout(new GridLayout(2,1,10,20));
        p1.setLocation(20,20);
        p1.add(t1);

        p1.add(t2);
        p1.setBackground(Color.white);

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
        transaction_option obj=new transaction_option();
        obj.label();
        obj.textfield();
        obj.panel();

        obj.button();
        obj.createframe();
    }
    String a="";
    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand()!="NEXT")
        {
            a=e.getActionCommand();
        }
        else if(a.length()>0)
        {
            setVisible(false);
            obj1.setVisible(false);
            transaction.main(a);

        }
        if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);
        }

    }
    }
    