import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class reset extends JFrame implements ActionListener
{
    JLabel L1;
    JLabel lab[]=new JLabel [10];
    JButton b1,b2;
    JPanel panel;
    int i=0,rv=i-3,len;
    String array[];
    transparent  obj1;

    reset(String a[][],int i1)
    {
        obj1 = new transparent();
        array=a[0];
        len =i1-3;
        panel=new JPanel();
        panel.setLayout(null);
        JLabel ll = new JLabel(" TRANSACTION DETAIL'S ");
        ll.setFont(new Font("",Font.BOLD,20));
        ll.setSize(400,30);
        ll.setLocation(40,10);
        panel.add(ll);

        label();

        button();
        panel();

    }


    void label()
    {
        
        for(i=0;i<10&&len-->1;i++)
        {
            lab[i]=new JLabel(array[len]);

        }
        
        L1=new JLabel(array[1]);
        L1.setFont(new Font("",Font.BOLD,14));

    }


    void button()
    {
        JPanel p = new   JPanel();
        p.setLayout(new GridLayout(11,1));
        p.setLocation(30,40);
        p.setSize(400,350);
        p.add(L1);

        b1=new JButton("NEXT");
        b1.setBackground(Color.white);
        b1.setLocation(30,378);
        b1.setSize(100,20);
        if(len>1)
            b1.addActionListener(this);

        b2=new JButton("CANCEL");
        b2.setBackground(Color.white);
        b2.setLocation(180,378);
        b2.setSize(100,20);

        b2.addActionListener(this);
        panel.add(b2);
        panel.add(b1);
        p.add(lab[0]);
        for(int j =1;j<i;j++)
        {
            if(lab[j].getText().startsWith("DATE  TIME  PARICULATES CREDIT DEBIT BALANCE ")==false)
                p.add(lab[j]);
        }
        if(i!=10)
        {
            lab[i]= new JLabel("NO  MORE  TRANSACTION ");
         p.add(lab[i]);}
        p.setBackground(Color.white);
        panel.add(p);

    }


    void panel()
    {
        setSize(420,400);
        setLocation(450,150);

        Container c=getContentPane();

        panel.setBackground(Color.white);

        c.add(panel);
        setUndecorated(true);
        setVisible(true);


    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()=="NEXT"&&len>1)
        {
            int k=0;
            for(i=0;i<10&&len-->1;i++)
            {
                k=i+1;
                lab[i].setText(array[len]);
            }
            if(k!=10)
            {
                for(i=k-1;i<10;i++)
                {
                    if(i==k-1)
                        lab[i].setText("NO  MORE  TRANSACTION ");
                    else
                        lab[i].setText("");
                }  
            }
               
        }
        else if(e.getActionCommand()=="CANCEL")
        {
            setVisible(false);
            obj1.setVisible(false);

        }
    }

}