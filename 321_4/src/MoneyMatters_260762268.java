import java.util.*;
public class MoneyMatters_260762268 {
    public static void main(String[] args) {
        //get inputs
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] owes = new int[n];

        //nested ArrayList graph showing friendships (initialize with empty ArrayLists)
        ArrayList<ArrayList<Integer>> friendship = new ArrayList<ArrayList<Integer>>(n);
        for(int i = 0; i<n; i++) {
            owes[i] = sc.nextInt();
            friendship.add(new ArrayList<Integer>());
        }
        boolean[] vis = new boolean[n]; //whether a person's node has been "visited" by test_friends

        //add friendships (more inputs)
        for(int i = 0; i<m; i++) {
            int friend1 = sc.nextInt();
            int friend2 = sc.nextInt();
            friendship.get(friend1).add(friend2);
            friendship.get(friend2).add(friend1);
        }

        //initialize result, update by running test_friends
        int result = -1;
        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                result = test_friends(i, friendship, vis, owes);
                if(result!=0)
                    break;
            }
        }
        if(result!=0) 
            System.out.println("IMPOSSIBLE");
        else
            System.out.println("POSSIBLE");
        sc.close();
    }
    
    public static int test_friends(int indx, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] money) {
        /*
            Inputs:
                indx - index of person that initializes the queue
                graph - graph of friendships
                visited - array indicating whether people have been visited
                money - array of money each person owes/is owed
        */
        int sum = 0;
        //visit person at indx, add them to the queue
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(indx);
        visited[indx]=true;
        //until you exhaust all friendship options
        while(!queue.isEmpty()) {
            //remove first from queue, visit all their neighbors (and add to queue) if they aren't already visited
            int rem = queue.remove();
            for(int nb : graph.get(rem)) {
                if(!visited[nb]) {
                    queue.add(nb);
                    visited[nb]=true;
                }
            }
            //add money (only once - if not visited or else not in queue)
            sum+=money[rem];
        }
        return sum;
    }
}