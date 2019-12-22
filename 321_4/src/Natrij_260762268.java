import java.util.*;
public class Natrij_260762268 {
    public static void main(String[] args) {
        //get inputs
        Scanner sc = new Scanner(System.in);
        String[] nowString = (sc.nextLine()).split(":");
        String[] bombString = (sc.nextLine()).split(":");
        sc.close();
        
        //adjust so that bombString is in the future no matter what
        if(Integer.valueOf(bombString[0])<=Integer.valueOf(nowString[0]))
            bombString[0] = Integer.valueOf(bombString[0])+24+"";
        
        //find difference in time
        int difTime = Integer.valueOf(bombString[0])*3600 + Integer.valueOf(bombString[1]) * 60 + Integer.valueOf(bombString[2]);
        difTime -= (Integer.valueOf(nowString[0])*3600 + Integer.valueOf(nowString[1]) * 60 + Integer.valueOf(nowString[2]));
        
        //time --> h:m:s
        String hrs = "" + difTime/3600 + ":";
        String min = "" + (difTime%3600)/60 + ":";
        String sec = "" + (difTime%3600)%60;
        
        //format string
        if((difTime/3600)<10)
            hrs = "0" + hrs;
        if(((difTime%3600)/60)<10)
            min = "0" + min;
        if(((difTime%3600)%60)<10)
            sec = "0" + sec;
        
        System.out.println(hrs + min + sec);
    }
    

}