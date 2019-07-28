import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class log_in extends JFrame implements ActionListener 
{
    JPanel  panel,panl1,panl2,panl3;
    JPasswordField l2;
    JTextField l1;
    JButton b1;
    private void make_frame()
    {
        new JFrame();
        setSize(800,715);
        setLocation(350,10);
        setUndecorated(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand()=="SUBMIT")
        { 
            String a[]= new String[11];
            if((new File(l1.getText()+".txt")).exists()==true){
                try
                {  int i=0;
                    FileReader fr = new FileReader(l1.getText()+".txt");
                    Scanner sc=new Scanner(fr);
                    while(sc.hasNext()==true)
                    {
                        a[i++]=sc.nextLine();
                    }
                }
                catch(Exception ep)
                {
                    System.err.println(ep);
                }

                if(a[6].equals(l2.getText())){
                    setVisible(false);
                    LOGED_IN .main(l1.getText());
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"  PASSWORD DOES NOT MATCH "," PASSWORD ",
                        JOptionPane.ERROR_MESSAGE);
                }
            }

            else
            {
                JOptionPane.showMessageDialog(null,"  SORRY ! WE CANNOT FIND YOU "," ACCOUNT NO. ",
                    JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    void make_panel()
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);

        panl1 = new JPanel();

        panl1.setLayout(null);
        panl1.setLocation(0,120);
        panl1.setSize(300,350);
        panl1.setBackground(Color.white);
        panl2 = new JPanel();
        panl2.setLocation(320,120);
        panl2.setSize(470,350);
        panl2.setLayout(null);
        panl2.setBackground(Color.white);

        panel.add(panl2);
        panl3 = new JPanel();
        panl3.setLocation(10,470);
        panl3.setSize(780,230);
        panl3.setLayout(null);
        panl3.setBackground(Color.white);

        panel.add(panl3);
    }

    void visi(boolean b)
    {

        setVisible(b);
    }

    void upload_symbol()
    {
        JLabel label1 = new JLabel("    RXG BANK ");
        label1.setLocation(300,0);
        label1.setSize(500,70);
        label1.setFont( new Font("Calibri",Font.BOLD,30));
        try {
            String path = "d.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(20,0);
            label.setSize(100,80);
            panel.add(label);
        }
        catch ( Exception e){
            System.err.println(e);
        }

        try {
            String path = "h1.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(5,40);
            label.setSize(790,100);
            panel.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        panel.add(label1);
    }

    void panel1()
    {

        l1= new JTextField(11);
        l1.setLocation(80,110);
        l1.setSize(180,25);
        panl1.add(l1);

        l2= new JPasswordField(11);
        l2.setLocation(80,170);
        l2.setSize(180,25);
        panl1.add(l2);

        b1 = new JButton("SUBMIT");
        b1.setSize(100,25);
        b1.setLocation(120,230);
        b1.setBackground(Color.white);
        b1.addKeyListener(new  KeyListener(){

                public void keyTyped(KeyEvent e) {    

                }

                public void keyPressed(KeyEvent e) {

                }

                public void keyReleased(KeyEvent e) {          
                    if( e.getKeyCode() == KeyEvent.VK_ENTER){

                        b1.doClick(1);
                    }
                }  

            });
        b1.addActionListener(this);
        panl1.add(b1);

        try {
            String path = "log.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(350,350);
            panl1.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        panel.add(panl1);
    }

    void panel2()
    {

        try {
            String path = "h2.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(500,300);
            panl2.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }

        final JLabel label2 = new JLabel("<html> <a href=\"\">HOME</a></html>");
        label2.setSize(200,20);
        label2.setLocation(500,130);
        label2.setFont( new Font("",Font.BOLD,16));
        panl3.add(label2);

        label2.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                public void mouseExited(MouseEvent me) {
                    label2.setCursor(Cursor.getDefaultCursor());
                }

                public void mouseClicked(MouseEvent me)
                {
                    setVisible(false);

                    HOMEPAGE.main();

                }
            });
    }

    void panel3()
    {

        final JLabel label2 = new JLabel("<html> <a href=\"\">FORGOT PASSWORD</a></html>");
        label2.setSize(200,20);
        label2.setLocation(100,135);
        label2.setFont( new Font("",Font.BOLD,10));
        panl3.add(label2);

        label2.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    label2.setCursor(new Cursor(Cursor.HAND_CURSOR));

                }
                public void mouseExited(MouseEvent me) {
                    label2.setCursor(Cursor.getDefaultCursor());

                }
                public void mouseClicked(MouseEvent me)
                {

                    forget_password.main();

                }
            });

        try {
            String path = "h3.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(400,200);
            panl3.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        try {
            String path = "h4.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(350,0);
            label.setSize(400,200);
            panl3.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
    }

    static void main()
    {

        log_in obj = new log_in();

        obj.make_panel();
        obj.panel1();
        obj.panel2();
        obj.panel3();
        obj.upload_symbol();
        obj.make_frame();

        obj.setVisible(true);
    }
}


