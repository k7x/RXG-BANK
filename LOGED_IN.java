import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class LOGED_IN extends JFrame implements ActionListener
{
    JPanel  panel,panl1,panl2,panl3, panl4,panl5;
    String name, acnt_no, phn_no,adrs
    ,f_name,filnam,Balnc,hav ;
    public static Timer timer;
    LOGED_IN (String f)
    {
        if(f.length()>11)
        {
            hav =f;
            f = f.substring(0,f.length()-1);
        }
        filnam = f;
        acnt_no=filnam;
        String a="";
        try
        {
            FileReader fr = new FileReader(filnam+".txt");
            Scanner sc=new Scanner(fr);
            int i=0;
            while(sc.hasNext()==true&&i<11)
            {
                a= sc.nextLine();
                i++;
                if(i==4||i==5||i==7||i==8||i==11) {continue;}
                else if(i==2)name =a;
                else if(i==3)f_name =a;
                else if(i==6) phn_no=a;
                else if(i==9)adrs= a;
            }
            Balnc =a.substring(a.indexOf(" ")+1);
            fr.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }

    private void make_frame()
    {
        new JFrame();
        setSize(700,715);
        setLocation(350,10);
        setUndecorated(!false);
    }

    void make_panel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);
        panl1 = new JPanel();
        panl1.setLayout(null);
        panl1.setLocation(10,150);
        panl1.setSize(500,400);
        panl1.setBackground(Color.white);
        panel.add(panl1);
        panl2 = new JPanel();
        panl2.setLocation(520,150);
        panl2.setSize(165,400);
        panl2.setLayout(null);
        panl2.setBackground(Color.white);
        panel.add(panl2);
        panl3 = new JPanel();
        panl3.setLocation(10,560);
        panl3.setSize(680,150);
        panl3.setLayout(null);
        panl3.setBackground(Color.white);
        panl4 = new JPanel();
        panl4.setLayout(null);
        panl4.setLocation(10,10);
        panl4.setSize(670,130);
        panl4.setBackground(Color.white);
        panel.add(panl4);
        panl5 = new JPanel();
        panl5.setLayout(null);
        panl5.setLocation(10,230);
        panl5.setSize(480,160);
        panl5.setBackground(Color.yellow);
        panl6();
        panl1.add(panl5);
        panel.add(panl3);
        panel.setBackground(Color.RED);
    }

    void panl6()
    {
        final String b[] =  new String[10];
        int  i=0;
        JLabel h = new JLabel("USER ID        NAME        MESSAGES  ") ;
        h.setFont(new Font("",Font.BOLD,18));
        final JLabel l[] = new JLabel[5];
        int k =0;
        try{
            FileReader fr = new FileReader(acnt_no+"msg.txt");
            Scanner sc=new Scanner(fr);
            while(sc.hasNext()==true)
            {
                b[i++]=(i)+".    "+sc.nextLine().replace("__","  ");
            }
            fr.close();
            h.setSize(400,20);
            h.setLocation(20,20);
            panl5.add(h);
            int a[] ={40,65,90,115,135};
            for(;k<5&&k<i;k++)
            {
                l[k]=new JLabel(b[k]) ;
                l[k].setLocation(20,a[k]);
                l[k].setFont( new Font("Segoe Print",Font.BOLD,15));
                l[k].setSize(500,20);
                panl5.add(l[k]);
            }
            FileWriter fw1 = new FileWriter(acnt_no+"msg.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter of1 = new PrintWriter(bw1);
            of1.close();
        }
        catch(Exception y)
        {
            System.err.println(y);
        }
        if(i==0)
        {
            JLabel lao = new JLabel();
            lao.setSize(500,20);
            lao.setLocation(20,140);
            lao.setFont(new Font("",Font.BOLD,20));
            lao.setText("NO MESSAGES FOR YOU ");
            panl5.add(lao);
        }
        final int k1 =k,i1 =i;
        final JLabel label2 = new JLabel("<html> <a href=\"\">MORE...</a></html>");
        label2.setSize(500,20);
        label2.setLocation(20,140);
        if(i>5){ panl5.add(label2);
            label2.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent me) {
                        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    public void mouseExited(MouseEvent me) {
                        label2.setCursor(Cursor.getDefaultCursor());
                    }

                    public void mouseClicked(MouseEvent me)
                    {
                        int k=5;
                        for(;k<l.length&&k<i1;k++)
                        {
                            l[k-5].setText(b[k]);
                        }
                    }
                });
        }
        try {
            String path = "hlp1.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(500,300);
            panl5.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
    }

    void visi(boolean b)
    {
        setVisible(b);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand()==" TRANSACTION ")
        {
            transaction_option.main();
        }
        else  if (e.getActionCommand()==" LOG OUT  ")
        {
            setVisible(false);
            HOMEPAGE.main();
        }
        else  if (e.getActionCommand()==" MONEY TRANSFER ")
        {
            money_transfer.main();
        } 
        else  if (e.getActionCommand()==" MESSAGE ")
        {
            message_send.main(name,acnt_no);
        }
        else  if (e.getActionCommand()==" RECHARGE ")
        {
            recharge.main();
        } 
        else  if (e.getActionCommand()==" PRIVACY SETUP ")
        {
            privacy_option.main();
        }
        else  if (e.getActionCommand()==" DELETE ACCOUNT ")
        {
            setVisible(false);
            HOMEPAGE.main();
            delete_account.main();
        }
    }

    void upload_symbol()
    {
        JLabel label1 = new JLabel("   RXG BANK ");
        label1.setLocation(160,0);
        label1.setSize(500,70);
        label1.setFont( new Font("Calibri",Font.BOLD,30));
        try {
            String path = "d.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(20,0);
            label.setSize(100,90);
            panl4.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        panl4.add(label1);
        JLabel acctp=new JLabel("Savings Account");
        if(filnam.endsWith("2"))acctp.setText("Current Account");
        acctp.setFont( new Font("",Font.BOLD,20));
        acctp.setLocation(50,70);
        acctp.setSize(200,90);
        panl4.add(acctp);
        JLabel nm=new JLabel(name);nm.setFont( new Font("",Font.BOLD,15));
        nm.setLocation(500,70);
        nm.setSize(200,90);
        panl4.add(nm);
        try {
            String path = "MF_IMG5.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(700,200);
            panl4.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
    }

    void panel1()
    {
        JLabel l1= new JLabel(" NAME                  : "+name);l1.setFont(new Font("",Font.BOLD,20));
        JLabel l2= new JLabel(" ACCOUNT NO.    : "+acnt_no);l2.setFont(new Font("",Font.BOLD,20));
        JLabel l3= new JLabel(" PHONE NO.         : "+phn_no);l3.setFont(new Font("",Font.BOLD,20));
        JLabel l4= new JLabel(" ADDRESS            : "+adrs);l4.setFont(new Font("",Font.BOLD,20));
        JLabel l5= new JLabel(" FATHER'S NAME : "+f_name);l5.setFont(new Font("",Font.BOLD,20));
        JLabel labl32= new JLabel(" PERSONEL DATA ");labl32.setFont(new Font("",Font.BOLD,24));
        l1.setSize(500,25);
        labl32.setSize(500,25);
        l5.setSize(500,25);
        l2.setSize(500,25);
        l3.setSize(500,25);
        l4.setSize(500,25);
        l1.setLocation(10,40);
        labl32.setLocation(70,5);
        l5.setLocation(10,80);
        l2.setLocation(10,120);
        l3.setLocation(10,160);
        l4.setLocation(10,200);
        panl1.add(l1);
        panl1.add(labl32);
        panl1.add(l5);
        panl1.add(l2);
        panl1.add(l3);
        panl1.add(l4);
        try {
            String path = "BCK.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(500,450);
            panl1.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
    }

    void panel2()
    {
        JLabel l  = new JLabel(" FEATURE ");
        l.setFont(new Font("Segoe Print",Font.BOLD,20));
        l.setSize(125,25);
        l.setLocation(20,5);
        panl2.add(l);
        JButton b1= new JButton(" TRANSACTION ");
        b1.setBackground(Color.white);
        JButton b2= new JButton(" MONEY TRANSFER ");b2.setBackground(Color.white);
        JButton b3= new JButton(" RECHARGE ");b3.setBackground(Color.white);
        JButton b4= new JButton(" PRIVACY SETUP ");b4.setBackground(Color.white);
        JButton b5= new JButton(" DELETE ACCOUNT ");b5.setBackground(Color.white);
        JButton b6= new JButton(" LOG OUT  ");b6.setBackground(Color.white);
        JButton b7= new JButton(" MESSAGE ");b7.setBackground(Color.white);
        b1.setSize(145,25);
        b2.setSize(145,25);
        b3.setSize(145,25);
        b4.setSize(145,25);
        b5.setSize(145,25);
        b6.setSize(145,25);
        b7.setSize(145,25);
        b1.setLocation(10,40);
        b2.setLocation(10,70);
        b3.setLocation(10,100);
        b4.setLocation(10,130);
        b5.setLocation(10,160);
        b6.setLocation(10,220);
        b7.setLocation(10,190);
        panl2.add(b1);
        panl2.add(b2);
        panl2.add(b3);
        panl2.add(b4);
        panl2.add(b5);
        panl2.add(b6);
        panl2.add(b7);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        try {
            String path = "BCK.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(300,270);
            panl2.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        try {
            String path = "feat.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(10,280);
            label.setSize(140,110);
            panl2.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
    }

    void panel3()
    {
        final String a[][] = new String[1][100];
        a[0][0]= "  ";
        a[0][1]="-      -          -       -      -      - ";
        a[0][2]="-      -          -       -      -      - ";
        a[0][3]="-      -          -       -      -      - ";
        int i =0;
        try{
            Scanner sc = new Scanner(new  FileReader(acnt_no+"transact.txt"));
            while(sc.hasNext()==true)
            {
                a[0][i++]=sc.nextLine();
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        final int len =i;
        JLabel l1= new JLabel(a[0][1]);l1.setFont(new Font("",Font.BOLD,18));
        JLabel l2= new JLabel(a[0][i-1]);l2.setFont(new Font("",Font.BOLD,18));
        JLabel l3= new JLabel();
        JLabel l4= new JLabel();
        if(i>3){
            l3.setText(a[0][i-2]);l3.setFont(new Font("",Font.BOLD,18));
        }
        if   (i>4)
        {
            l4.setText(a[0][i-3]);
            l4.setFont(new Font("",Font.BOLD,18));}
        if(i==3){l4.setText("");  l3.setText("");}
        if(i==4)l4.setText("");
        l1.setSize(600,25);
        l2.setSize(600,25);
        l3.setSize(600,25);
        l4.setSize(600,25);
        l1.setLocation(5,40);
        l2.setLocation(5,65);
        l3.setLocation(5,90);
        l4.setLocation(5,115);
        final JLabel label2 = new JLabel("<html> <a href=\"\">FEW TRANSACTION</a></html>");        
        label2.setSize(200,20);
        label2.setLocation(10,5);
        label2.setFont( new Font("",Font.BOLD,17));
        panl3.add(label2);
        if(i>5){
            label2.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent me) {
                        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    public void mouseExited(MouseEvent me) {
                        label2.setCursor(Cursor.getDefaultCursor());

                    }

                    public void mouseClicked(MouseEvent me)
                    {
                        reset obj = new reset(a,len);

                    }
                });
        }
        panl3.add(l1);
        panl3.add(l2);
        panl3.add(l3);
        panl3.add(l4);
        JLabel curbal = new JLabel(" CURRENT BALANCE :");
        curbal.setSize(250,50);
        curbal.setLocation(515,20);
        curbal.setFont(new Font("",Font.BOLD,15));
        JLabel curbal1 = new JLabel("Rs."+a[0][0].substring(a[0][0].indexOf(":")+1)+"/-");
        curbal1.setSize(150,50);
        curbal1.setLocation(550,60);
        curbal1.setFont(new Font("",Font.BOLD,14));
        panl3.add(curbal); 
        panl3.add(curbal1); 
        try {
            String path = "TRAN.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(700,300);
            panl3.add(label);}
        catch ( Exception e){
            System.err.println(e);

        }
    }

    static void main(String fnam)
    {

        LOGED_IN  obj = new LOGED_IN (fnam);
        obj.make_frame();
        obj.make_panel();
        obj.panel1();
        obj.panel2();
        obj.panel3();
        obj.upload_symbol();

        obj.visi(true);

    }
}
