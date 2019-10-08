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
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int p = sc.nextInt();
        int[] locations = new int[p+2];
        locations[0] = 0;
        locations[locations.length - 1] = w;
        for(int i = 1; i<locations.length-1; i++){
            locations[i] = sc.nextInt();
        }
        sc.close();

        //next, use a boolean array of widths to track whether they're feasible
        boolean[] feas = new boolean[w+1];
        for(int i = 0; i<feas.length; i++)
            feas[i] = false;
        feas[w] = true;

        //update array values
        for(int i = 0; i<locations.length; i++){
            for(int j = 1; j<locations.length; j++){
                int curWidth = Math.abs(locations[j] - locations[i]);
                if(!feas[curWidth])
                    feas[curWidth]=true;
            }
        }

        //finally, iterate over the boolean array to print each feasible width
        for(int i = 1; i<feas.length; i++)
            if(feas[i])
                System.out.print(i + " ");
    }
}
