import java.util.*;
import java.io.*;

public class FlexibleSpaces_260762268 {
    /*
        Background: Wide rectangular room, optional parallel partitions
        Goal: Determine all feasible widths for a meeting
        Input:
        2<=W<=100 (where W is width), and 1<=P<W (where P is the number of partitions) on the first line
        P integers, designating the location L of an optional such that 0<L<W on the second line (listed in increasing order)
        Output: sorted list of each distinct width of meeting space
     */
    public static void main(String[]args){
        //first, read in the inputs
        Scanner sc = new Scanner();
        int w = sc.nextInt();
        int p = sc.nextInt();
        int[] locations = new int[p];
        for(int i = 0; i<locations.length; i++){
            locations[i] = sc.nextInt();
        }
        sc.close();
        //next, determine possible widths and add them to an ArrayList
        for(int i = 0; i<=p; i++){//for each number of partitions

        }
        //finally, sort the list, and print each element
    }
}
