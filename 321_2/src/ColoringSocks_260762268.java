import java.util.*;
import java.io.*;

public class ColoringSocks_260762268 {
    /*
        Brief description:
            socks have color Di (0<=i<=10E9)
            can only be matched with socks of max. color difference K = Di-Dj
            Max number of washing machines to wash S socks, given capacity of C?
        Input:
            1<=S C<=10^5 0<=K<=10^9
            color values Di of each of the S socks
        Output:
            number of machines
     */
    public static void main(String[]args){
        //read the values for s, c, k
        int s, c, k;
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        //read the D values into an array
        int[] dvals = new int[s];
        for(int i = 0; i<s; i++) {
            dvals[i] = sc.nextInt();
        }
        sc.close();

        //determine current washing machines used, number of socks
        int wm = 1;
        int curNum = 1;

        //sort dvals
        Arrays.sort(dvals);

        //assuming dvals is sorted (inc. order), we can create different "bins" of socks greedily using only one iteration
        int curMax = dvals[0]+c;
        for(int i = 1; i< dvals.length; i++){
            if(curMax<dvals[i] || curNum>=c) {
                wm++;
                curMax = dvals[i]+k;
                curNum=1;
            }else {
                curNum++;
            }
        }
        System.out.println(wm);
    }
}
