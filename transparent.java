import javax.swing.*;
import java.awt.*;
import javax.swing.*;
class transparent  extends JFrame
{
    public transparent()
    {
        setSize(700,715);
        setLocation(350,10);
        JPanel p =new JPanel();
        p.setBackground(Color.BLACK);
        setEnabled(false);
        getContentPane().add(p);
        setUndecorated(true);
        visible(true);
        

        com.sun.awt.AWTUtilities.setWindowOpacity(this,0.8f);

    }

    void visible(boolean b )
    {
        setVisible(b);
    }
}