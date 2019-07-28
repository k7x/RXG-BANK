import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.text.*;
import java.awt.event.*;
class transaction  extends JFrame implements ActionListener
{
    JPanel panel;
    JPasswordField t2;
    JLabel L1,l2,l3,l4;
    JButton b1,b2;
    JTextField t1,t3;
    String lop;transparent obj1;
    transaction (String a){
        obj1=new transparent();
        lop=a;}

    void label()
    {
        L1=new JLabel(lop);
        L1.setFont(new Font(null,Font.BOLD,25));
        l2=new JLabel("ACOUNT ID");
        l3=new JLabel("PASSWORD");
        l4=new JLabel("AMOUNT");
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

    }


    void createframe()
    {

        setSize(400,250);
        setLocation(500,250);
        setUndecorated(true);
        setVisible(true); 

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

        p1.setLayout(new GridLayout(3,2,10,30));
        p1.setLocation(20,20);
        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p1.add(l4);
        p1.add(t3);
        p2.add(L1);
        panel.add(p2);
        panel.add( p1);
        c.add (panel);

    }   


    void visible(boolean a)
    {
        setVisible(true);

    }


    static void main(String a)
    {
        transaction obj=new transaction(a);
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
        )
        {

            try{
                double db = Double.parseDouble(t3.getText());

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

                String b[] = new String[12];
                int i =0;   
                if((new File(t1.getText()+".txt")).exists()==true){

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
                            if(Double.parseDouble((z[1]+1))>Double.parseDouble(t3.getText())&&Double.parseDouble(t3.getText())>0&&lop.equals("Debit ")==true)
                            {

                                b1[0] =Double.toString(Double.parseDouble(z[1])-Double.parseDouble(t3.getText()));

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
                                    of11.println(h.format(o)+" by CASH "+"  -  "+t3.getText()+"  "+b1[0]);

                                    of11.close();

                                    setVisible(false);
                                    obj1.setVisible(false);

                                }
                                catch(IOException y)
                                {
                                    System.err.println(y);
                                }
                            }
                            else if(Double.parseDouble(t3.getText())>0&&lop.equals("Credit ")==true){
                                b1[0] =Double.toString(Double.parseDouble(z[1])+Double.parseDouble(t3.getText()));

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
                                    of11.println(h.format(o)+"  -  "+" by CASH "+t3.getText()+"  "+b1[0]);

                                    of11.close();
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
                                JOptionPane.showMessageDialog(null,"  BALANCE IS NOT SUFFICIENT  "," BALANCE ",
                                    JOptionPane.ERROR_MESSAGE);

                            }

                        }
                        else
                        {

                            JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWORD ",
                                JOptionPane.ERROR_MESSAGE);    
                        }

                    }catch(Exception e1)
                    {
                        System.err.println(e1);

                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND YOU "," ACCOUNT NO. ",
                        JOptionPane.PLAIN_MESSAGE);

                }
                if(bl==true){
                }
            }
        }
        else
        {

            JOptionPane.showMessageDialog(null,"  SORRY ! DATAS ARE NOT FILLED PROPERLY" ," READ CAREFULLY ",
                JOptionPane.PLAIN_MESSAGE);
        }
    }
}
