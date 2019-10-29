import java.util.*;

public class VirusReplication_260762268 {
	/*
	 * Input:
	 * 		 DNA sequence, pre virus
	 * 		 DNA sequence, post virus
	 * Output:
	 * 		 Minimum length of viral insertion
	 * Plan: 
	 * 		 Use for loops to find the number of identical bases at the start and end of the two sequences
	 * 		 The minimum length of insertion is equal to this, subtracted from the length of the DNA post virus
	 * 		 forwards, backwards will track these values
	 * 		 Two loops used to minimize complications from "break" in the forwards count
	 * 		 O(2N) = O(N), where N is the length of the smaller sequence (two loops, each O(N))
	 * 			Assuming trivial reading from Scanner, charAt, and printing
	 */
    public static void main(String[] args) {
        //read in the input (dna alone, find length; dna w/ virus, find length)
        Scanner sc = new Scanner(System.in);
        String dnaAlone = sc.nextLine();
        int dnalen = dnaAlone.length();
        String dnaVirus = sc.nextLine();
        int virlen = dnaVirus.length();
        sc.close();

        //declare useful constants/count variables
        int minlen = Math.min(dnaVirus.length(), dnaAlone.length());
        int forwards = 0; 
        int backwards = 0;
        
        //loop: O(n)
        for(int i = 0; i<minlen; i++) {
        	if(dnaAlone.charAt(i)!=dnaVirus.charAt(i)) {
        		forwards = i;//number of matching characters at start
        		break;        		
        	}
        }
        
        //backwards loop: O(n)
        for(int i = 0; i<minlen; i++) {
        	if(minlen>=backwards && dnaAlone.charAt(dnalen - 1 - backwards)==dnaVirus.charAt(virlen - 1 - backwards))
        		backwards++;//number of matching characters at end
        }
       // System.out.println(backwards + " " + forwards); -- for testing
        System.out.println(Math.max(virlen-dnalen, Math.max(0, virlen-backwards-forwards)));
    }
}