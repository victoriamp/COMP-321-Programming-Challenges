import java.util.*;
public class RadioCommercials_260762268 {
    /*
    Input:
        N<=100000 (number of commercial breaks/day) P<=1000 (price/commercial break)
        N integers, representing how many students listen to each commercial break (each int <=2000)
    Output: biggest expected extra profit Onid can get by selecting a continuous sequence of commercial breaks
    Other Constraints:
        - sequence must be continuous
        - for each student that listens, 1 crown increase in earnings
    Plan: the Kladane algorithm dynamically searches for the maximum sum of a subarray, finding the maximum
        sum for the subarray ending with each element of the total array
     */
    public static void main(String[] args){
        //first, read in input
        Scanner sc = new Scanner(System.in);
        int[] prof = new int[sc.nextInt()];
        int p = sc.nextInt();
        for(int i = 0; i<prof.length; i++)
            prof[i] = sc.nextInt()-p;
        /*
            loop through "prof", which subtracts the price from the revenue for each slot.
            as you loop through, track the current profit (effectively, the max profit including
            element i in the subarray), not letting it drop below zero.
            if it ever exceeds the maximum profit, update accordingly
         */
        int cur=0;
        int max = 0;
        for(int i = 0; i<prof.length; i++){
            cur+=prof[i];
            if(cur<0)
                cur=0;
            if(max<cur)
                max=cur;
        }
        System.out.println(max);
    }
}
