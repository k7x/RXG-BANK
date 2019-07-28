 import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class change_image  {

  public static Timer timer;
 String a[]= {"MF_IMG1","MF_IMG1","MF_IMG2","MF_IMG3","MF_IMG4"};
    public change_image() {
        try{
        timer = new Timer();
        timer.schedule(new RemindTask(),0,1*5000);  
                      
                    }
                    catch (Exception e)
                    {
                        System.err.println(e);
                    }
                       
    }

    class RemindTask extends TimerTask {
        int numWarningBeeps =5;
        public void run() {
            if (numWarningBeeps > 1) {
                ImageIcon loading = new ImageIcon(a[numWarningBeeps-1]+".jpg");
              HOMEPAGE.my_label.setIcon(loading);
                numWarningBeeps--;
            } 
            else if(numWarningBeeps == 1){
                ImageIcon loading = new ImageIcon("MF_IMG5.jpg");
               HOMEPAGE.my_label.setIcon(loading);
               numWarningBeeps=5;
            }
            else {
                
                
                //System.out.println("Time's up!");
                timer.cancel(); 
            }
        }
    }
}