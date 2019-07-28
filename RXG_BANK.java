
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


class RXG_BANK
{
Timer timer;
opening_load ob;
RXG_BANK()throws Exception
{
   
timer=new Timer();
timer.schedule(new RemindTask(),0,(1*1000));
}
class RemindTask extends TimerTask
{
int n=8;
public void run()
{

 if (n==8)
{
BLACK  o= new BLACK ();

}
 if(n==7)
{
 ob = new opening_load();
}
if(n==1)
{
HOMEPAGE.main();
}
 if(n>=1)
{
n--;
}

else
{
    ob.setVisible(false);
    
    timer.cancel();
}
}
}
}