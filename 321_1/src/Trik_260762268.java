import java.util.Scanner;
public class Trik_260762268 {
    public static void main(String[]args){
    /*
        as each letter represents a switch of two cups, a series of if/else statements can be used:
        to determine where the ball currently is (using "track")
        to determine if the cup with the ball is switched (in which case, "track" is changed accordingly)
        thus: traversal over each letter, with the above if statements being evaluated at each step
     */
        //uses scanner to read input
        Scanner s = new Scanner(System.in);
        int track = 1;
        //.next() defaults to String
        String moves = s.next();
        for(int i=0; i<moves.length(); i++){
            if(track==1){//if ball is under cup 1
                if(moves.charAt(i)=='A') {
                    track = 2;
                }else if(moves.charAt(i)=='C') {
                    track = 3;
                }
            }else if(track==2){//if ball is under cup 2
                if(moves.charAt(i)=='A') {
                    track = 1;
                }else if(moves.charAt(i)=='B') {
                    track = 3;
                }
            }else{//if ball is under cup 3
                if(moves.charAt(i)=='B') {
                    track = 2;
                }else if(moves.charAt(i)=='C'){
                    track=1;
                }

            }
        }
        System.out.println(track);
        s.close();
    }
}
