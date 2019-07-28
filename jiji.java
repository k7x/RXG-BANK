import java.util.*;
class jiji
{
    int sum(int n,int p)
    {
        int s=1;
        String st=Integer.toString(n);

        int d=Integer.parseInt(st.charAt(p-1)+"");
        for(int i=1;i<=p;i++)
        {
            s*=d;
        }
        if(p>1)
        {s+= sum(n,p-1);}
        return s;
    }
}