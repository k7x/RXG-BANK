 import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import java.io.BufferedImage ;
import java.awt.image.*;
class opening_load extends JFrame 
{

    JLabel l1,l2;

    opening_load()
    {

        image();createframe();
    }


    void createframe()
    {

        setSize(100,100);
        setLocation(600,300);
        setUndecorated(true);
        setVisible(true);

    }

    void image()
    {
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        ImageIcon i = new ImageIcon("7.gif");
        l1=new JLabel(i);
        l2= new JLabel("LOADING...");
        l2.setFont( new Font("Segoe Print",Font.BOLD,15));
        p.add(l1,JLabel.CENTER);
        p.add(l2);
        getContentPane().add(p);

    }

    }
