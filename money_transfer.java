 
import java.text.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class money_transfer extends JFrame  implements ActionListener
{
    JPanel panel;
    JPasswordField t2;
    JTextField t1,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    transparent obj1;

    void label()
    {
        obj1 = new transparent();

        l1=new JLabel("I.D");
        l5=new JLabel("MONEY TRANSFER");
        l5.setSize(20,20);
        l5.setLocation(200,200);
        l5.setFont(new Font(null,Font.BOLD,25));
        l2=new JLabel("PASSWORD");
        l3=new JLabel("ACCOUNT TO  TRANSFER");
        l4=new JLabel("AMOUNT TO BE TRANSFER");
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
        t2=new JPasswordField(10);
        t2.setEchoChar('*');
        t3=new JTextField(16);
        t4=new JTextField(16);
        t5=new JTextField(16);
    }


    void frame()
    {

        setSize(380,250);
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
        p1.setLayout(new GridLayout(4,2,10,20));
        p1.setSize(20,50);
        p1.setLocation(200,200);
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);

        p2.add(l5);
        panel.add(p2);
        panel.add(p1);

        c.add(
            panel);


    }
    static void main()
    {
        money_transfer obj=new money_transfer();

        obj.label();
        obj.textfield();

        obj.panel();
        obj.button();
        obj
        .frame();


    }
    public void actionPerformed(ActionEvent e)
    {
        boolean b2= true;
            try{
                double db = Double.parseDouble(t4.getText());

            }
            catch(Exception y)
            {
                b2=false;  
            }
        if(e.getActionCommand()=="CANCEL")
        {
            obj1.setVisible(false);
            visible(false);
        }
        else if(e.getActionCommand()=="NEXT")
        {
            if(b2==false)
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! AMOUNT IS NOT APROPRIATE ","AMOUNT ",
                        JOptionPane.PLAIN_MESSAGE);
            }
            else if(t1.getText().length()>0&&t2.getText().length()>0&&t3.getText().length()>0
            &&t4.getText().length()>0)
            {
                if((new File(t3.getText()+".txt")).exists()!=true){
                    JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND THE ACCOUNT YOU WANT TO SEND MONEY "," ACCOUNT NO. ",
                        JOptionPane.PLAIN_MESSAGE);
                }
                else if((new File(t1.getText()+".txt")).exists()==true)
                {
                    String b[] = new String[12];
                    int i =0;

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

                                FileWriter fw11 = new FileWriter(t1.getText()+"transact.txt");

                                BufferedWriter bw11 = new BufferedWriter(fw11);
                                PrintWriter of11 = new PrintWriter(bw11);

                                of11.println("BALANCE :"+b1[0]);
                                int k= 1;
                                while(k<j)
                                {

                                    of11.println(b1[k++]);

                                }
                                of11.println(h.format(o)+" by TRANSFER "+"  -  "+t4.getText()+"  "+b1[0]);

                                of11.close();
                                j =0;
                                FileReader fr123 = new FileReader(t3.getText()+"transact.txt");
                                Scanner sc123=new Scanner(fr123);
                                while(sc123.hasNext()==true)
                                {

                                    b1[j++]=sc123.nextLine();

                                }
                                fr123.close();
                                FileWriter fw12 = new FileWriter(t3.getText()+"transact.txt");

                                BufferedWriter bw12 = new BufferedWriter(fw12);
                                PrintWriter of12= new PrintWriter(bw12);
                                String z1[] = b1[0].split(":");
                                b1[0] =Double.toString(Double.parseDouble(z1[1])+Double.parseDouble(t4.getText()));
                                of12.println("BALANCE :"+b1[0]);
                                k= 1;
                                while(k<j)
                                {

                                    of12.println(b1[k++]);
                                }
                                of12.println(h.format(o)+" by TRANSFER "+t4.getText()+"  -  "+"  "+b1[0]);

                                of12.close();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null,"  BALANCE IS NOT SUFFICIENT  "," BALANCE ",
                                    JOptionPane.ERROR_MESSAGE);

                            }

                            setVisible(false);
                            obj1.setVisible(false);

                        }
                        else
                        {

                            JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWORD ",
                                JOptionPane.ERROR_MESSAGE);    
                        }

                    }
                    catch (Exception ae)
                    {

                        System.err.println(ae);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND  YOU "," ACCOUNT NO. ",
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
}
