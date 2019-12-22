import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class FroshWeek2_260762268 {
    public static void main(String[] args) {
        //get inputs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] t = new int[n];   //tasks
        int[] l = new int[m];   //quiet lengths
        for(int i = 0; i<n; i++)
            t[i] = sc.nextInt();
        for(int i = 0; i<m; i++)
            l[i] = sc.nextInt();

        //sort arrays
        Arrays.sort(t);
        Arrays.sort(l);
        
        //greedy algorithm
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<n && j<m){
            if(t[i]>l[j])
                j++;
            else{
                i++;
                j++;
                count++;
            }
        }
        System.out.println(count);
    }
}