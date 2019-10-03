import java.util.Scanner;
public class TheEasiestProblemIsThisOne_260762268 {
    public static void main(String[]args){
        //uses scanner s to read the next int in the input
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //while there are still numbers left to read from the input
        while(n!=0){
            int p=11;
            //for each value of p (11+), until a solution is found
            //are the sum of digits in n*p equal to the sum of digits in n
            for(int i=1; i<=100000; i++)
                if(sumDig(n*p) == sumDig(n)) {
                    System.out.println(p);
                    break;
                }else{
                    p++;
                }
            n=s.nextInt();
        }
        s.close();
    }

    //sumDig: computes the sum of the digits in an integer x
    private static int sumDig(int x){
        int sum = 0;
        while(x!=0){
            //add each digit (adjusted by powers of 10 as we go) to the sum
            sum=sum+x%10;
            x=x/10;
        }
        return sum;
    }
}
