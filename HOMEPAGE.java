import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.*;
class HOMEPAGE  extends JFrame implements ActionListener
{

    JPanel panel, panl1, panl2,panl3;
    Container containr;
    String  menu_list[][];
    JMenuBar menubar;
    JMenuItem menuitem[][];
    JMenu menu[];
    public static JLabel my_label;
    JLabel l1,l2,l3,l4;
 private void initlize()
    {
        String s[][] = {  {" ACCOUNTS  ","SAVING ","CURRENT"     },
        {"   FEATURE  "," MONEY TRANSFER ", " RECHARGE "   },
        {"   PRIVACY SETUP  ","CHANGE PASSWORD","CHANGE ADDRESS","DELETE ACCOUNT"},
        {"  HELP  ","HOW TO OPEN ACCOUNT","MANAGE ACCOUNT "}
         };
         menu_list=s;
        s=null;
    }
    private void make_frame()
    {
        new JFrame();
        setSize(700,715);
        setLocation(350,10);
        setUndecorated(true);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        containr= getContentPane();
        containr.add(panel);
    }
    private void visible(boolean a)
    {
        setVisible(a);       
    }
    void make_panel()
    {
        panl1 = new JPanel();
        panl1.setLayout(new BorderLayout());
        panl1.setLocation(10,80);
        panl1.setSize(650,300);
        panl1.setBackground(Color.white);
        panel.add(panl1);
               panl2 = new JPanel();
        panl2.setLocation(40,400);
        panl2.setSize(650,250);
        panl2.setLayout(null);
        panl2.setBackground(Color.WHITE);
        panel.add(panl2);
        panl3 = new JPanel();
        panl3.setLocation(20,650);
        panl3.setSize(650,100);
        panl3.setLayout(null);
        panl3.setBackground(Color.blue);
        panel.add(panl3);
    }
    void make_menubar()
    {
        menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);
        menu = new JMenu[4];
        menuitem = new JMenuItem[4][];
        for(int i=0;i<4;i++)
        {
            menu[i] = new JMenu(menu_list[i][0]);
            menu[i].setFont( new Font("",Font.BOLD,16));            
            menu[i].setBackground(Color.white);
            menu[i].addMouseListener(new CustomMouseListener());
            menuitem[i] = new JMenuItem[menu_list[i].length];
            for(int j=0;j<menu_list[i].length-1;j++)
            {
                menuitem[i][j] = new JMenuItem(menu_list[i][j+1]);                
                menuitem[i][j].setFont( new Font("",Font.BOLD | Font.ITALIC,14));
                menuitem[i][j].setBackground(Color.WHITE);
                menuitem[i][j].addActionListener(this);
                menu[i].add( menuitem[i][j]);
            }
            menubar.add(menu[i]);
        }
        panl1.add(menubar,BorderLayout.NORTH);
    }
    void upload_symbol()
    {
        JLabel label1 = new JLabel(" RXG BANK ");
        label1.setLocation(160,0);
        label1.setSize(500,70);
        label1.setFont( new Font("Calibri",Font.BOLD,30));
               try {
            String path = "MF_IMG1.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            my_label = new JLabel(new ImageIcon(image));
            my_label.setLocation(0,0);

            panl1.add(my_label);}
        catch ( Exception e){
            System.err.println(e);
        }
        try {
            String path = "d.jpg"; 
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(20,0);
            label.setSize(100,90);
            panel.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        panel.add(label1);
    }
    void label1()
    {
        JPanel p = new JPanel();
        l1=new JLabel(" ACCOUNT ");
        l1.setFont( new Font("",Font.BOLD,20));
        l1.setSize(200,20);
        l1.setLocation(10,10);
        p.add(l1);
        p.setBackground(Color.WHITE);
        p.setLocation(2,0);
        p.setSize(250,130);
        p.setLayout(null);
        final JLabel label = new JLabel("<html> <a href=\"\">LOG IN</a></html>");
        label.setSize(100,20);
        label.setLocation(50,60);
        label.setFont( new Font("",Font.BOLD,17));
        p.add(label);
        getContentPane().add(BorderLayout.NORTH, p);
        label.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                public void mouseExited(MouseEvent me) {
                    label.setCursor(Cursor.getDefaultCursor());
                }
                public void mouseClicked(MouseEvent me)
                {
                    change_image.timer.cancel();
                    setVisible(false);
                    log_in.main();
                }
            });
        final JLabel label2 = new JLabel("<html> <a href=\"\">SIGN UP</a></html>");
        label2.setSize(100,20);
        label2.setLocation(50,100);
        label2.setFont( new Font("",Font.BOLD,17));
        p.add(label2);
        getContentPane().add(BorderLayout.NORTH, p);
        label2.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                public void mouseExited(MouseEvent me) {
                    label2.setCursor(Cursor.getDefaultCursor());                   
                }
                public void mouseClicked(MouseEvent me)
                {
                    change_image.timer.cancel();
                    setVisible(false);
                    accounttype.main();
                }
            });
        panl2.add(p);
    }
    void add_image()
    {
        try {
            String path = "abcZ.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(255,0);
            label.setSize(400,260);
            panl2.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
         try {
            String path = "img1.jpg";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setLocation(0,0);
            label.setSize(650,90);
            panl3.add(label);}
        catch ( Exception e){
            System.err.println(e);
        }
        try {
            String path = "close.gif";
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent me) { }
                    public void mouseExited(MouseEvent me) {  }
                    public void mouseClicked(MouseEvent me)
                    {
                        System.exit(100);
                    }
                     });
            label.setLocation(610,0);
            label.setSize(100,50);
            panel.add(label);}
            catch ( Exception e){
            System.err.println(e);
        }
    }
    void label3()
    {
        JPanel p = new JPanel();
        l3=new JLabel(" BANK ");
        l3.setFont( new Font("",Font.BOLD,18));
        l3.setSize(200,20);
        l3.setLocation(10,10);
        p.add(l3);
        p.setBackground(Color.WHITE);
        p.setSize(250,128);
        p.setLocation(2,135);
        p.setLayout(null);
        final JLabel label = new JLabel("<html> <a href=\"\">KNOW ABOUT BANK</a></html>");
        label.setSize(300,20);
        label.setLocation(50,60);
        label.setFont( new Font("",Font.BOLD,17));
        p.add(label);
        getContentPane().add(BorderLayout.NORTH, p);
        label.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent me) {
                    label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
                public void mouseExited(MouseEvent me) {
                    label.setCursor(Cursor.getDefaultCursor());
                }
                public void mouseClicked(MouseEvent me)
                {
                    change_image.timer.cancel();
                    JOptionPane.showMessageDialog(null,"  THERE IS NOTHING TO KNOW :) "," :( ",
                    JOptionPane.ERROR_MESSAGE);
                    
                }
            });
        panl2.add(p);
    }
    public void actionPerformed(ActionEvent e)
    { 
        if(e.getActionCommand()==" RECHARGE ")
        {   
            recharge.main();
        }
        else if(e.getActionCommand()==" MONEY TRANSFER ")
        {       
            money_transfer.main();
        }
        else if (e.getActionCommand()=="CHANGE PASSWORD")
        {
            changepassword.main();
        }
        else if(e.getActionCommand()=="CHANGE ADDRESS")
        {
            change_Address.main();
        }
        else if(e.getActionCommand()=="DELETE ACCOUNT")
        {
            delete_account.main();
        }
        else if(e.getActionCommand()=="SAVING ")
        {
            change_image.timer.cancel();
            setVisible(false);
            read_me.main("SAVING","111");
        }
        else  if(e.getActionCommand()=="CURRENT")
        {
            change_image.timer.cancel();
            setVisible(false);
            read_me.main("CURRENT","222");
        }
        else if(e.getActionCommand()==" FIXED")
        {
            change_image.timer.cancel();
            setVisible(false);
            read_me.main("FIXED","333");
        }       
        else if(e.getActionCommand()=="HOW TO OPEN ACCOUNT")
        {
            change_image.timer.cancel();
            setVisible(false);
            read_me.main("HOW TO OPEN ACCOUNT","444");
        }
        else if(e.getActionCommand()=="MANAGE ACCOUNT ")
        {
            change_image.timer.cancel();
            setVisible(false);
            change_image.timer.cancel();
            read_me.main("MANAGE ACCOUNT ","555");
        }
    }
    public static void main()
    {
        HOMEPAGE p= new HOMEPAGE();
        p.make_frame();
        p.make_panel();
        p.initlize();
        p.make_menubar();
        p.upload_symbol();
        p.label1();
        p.label3();
        p.add_image();
        change_image oio = new change_image();
        p.visible(true);
    }
}
class CustomMouseListener implements MouseListener{
    public void mouseClicked(MouseEvent e) {   }
    public void mousePressed(MouseEvent e) {   }
    public void mouseReleased(MouseEvent e){  }
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() !=null ){
            ((JMenu)e.getSource()).doClick(1);
        }
    }
    public void mouseExited(MouseEvent e) {
    }
}