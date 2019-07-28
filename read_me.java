import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
class read_me extends JFrame implements ActionListener
{
    JPanel pan;
    transparent obj1;
    String acnt;

    static void main(String a,String b)
    {

        read_me  obj=new read_me();

        obj.acnt=a;
        obj.makeframe();

        obj.textpane(b);
        obj.button(b);
        obj.visible(true);
    }

    void makeframe()
    {
        obj1= new transparent();
        setSize(600,600);
        setLocation(400,50);
        setUndecorated(true);
        pan=new JPanel();
        pan.setBackground(Color.white);
        pan.setLayout(null);
        add(pan);
    }


    void visible( boolean a)
    {
        setVisible(a);
    }

    void textpane(String a)
    {
        String b="";
        
        try {
            String path = a+".jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel my_label = new JLabel(new ImageIcon(image));
            my_label.setLocation(50,0);
            my_label.setSize(500,550);
            pan.add(my_label);}
        catch ( Exception e){
            System.err.println(e);
        }


    }
    void button(String b)
    {
        JButton b1=new JButton("Next");
        JButton b2=new JButton("HOME");
        b1.setSize(100,30);
        b2.setSize(100,30);
        b1.setLocation(120,560);

        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        try {
            String path = "hm11.gif";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel my_label = new JLabel(new ImageIcon(image));
            my_label.setLocation(0,0);
            my_label.setSize(200,100);
            b2.add(my_label);}
        catch ( Exception e){
            System.err.println(e);
        }
        try {
            String path = "nxt22.gif";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel my_label = new JLabel(new ImageIcon(image));
            my_label.setLocation(0,0);
            my_label.setSize(200,200);
            b1.add(my_label);}
        catch ( Exception e){
            System.err.println(e);
        }
        b1.addActionListener(this);
        b2.addActionListener(this);
        pan.add(b2);
        if(b!="555"&&b!="444"&&b!="666"){
            b2.setLocation(280,560);
            pan.add(b1);}
        else
            b2.setLocation(200,560)

        ;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()=="Next")
        {   setVisible(false);
            obj1.setVisible(false);

            signup.main(acnt);

        }

        else if(e.getActionCommand()=="HOME")
        {
            setVisible(false);
            obj1.setVisible(false);
            HOMEPAGE.main();
        }

    }
}

