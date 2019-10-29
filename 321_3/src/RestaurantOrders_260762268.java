import java.util.*;

public class RestaurantOrders_260762268 {
	/*
	 * Input: 1<=n<=100 (number of items on the menu)
	 * 		  Integers c1 --> cn, max of each is 1000 (cost of items on the menu)
	 * 		  1<=m<=1000 (number of orders placed)
	 * 		  1<=s<=30000 (total cost of ordered items)
	 * Output: Impossible, Ambiguous, number of each item (in order) for each order
	 * 
	 * Plan:
	 * 		Knapsack Problem variant
	 * 		Use 1D array, determine individual totals able to be reached by each item's cost
	 * 		For each cost in orderCosts, check to see the number recorded there (num of ways to reach it)
	 * 		If 1, return way to reach it
	 * 							
	 */
	public static void main(String[] args) {
		//read inputs
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] menuCosts = new int[n];
		for(int i = 0; i<n; i++) {
			menuCosts[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] orderCosts = new int[m];
		for(int i = 0; i<m; i++) {
			orderCosts[i] = sc.nextInt();
		}
		sc.close();
		
		
		int[] arr = new int[30001];
		Arrays.fill(arr,  -1);
		arr[0]=1;
		for(int  cost : menuCosts) {
			for(int i = cost; i<arr.length; i++) {
				if(arr[i-cost]==-1)
					continue;
				arr[i] = (arr[i] == -1) ? arr[i-cost] : arr[i-cost] + 1;
			}
		}
		
		for(int cost = 0; cost<orderCosts.length; cost++) {
			if(arr[orderCosts[cost]]>1) 
				System.out.println("Ambiguous");
			else if(arr[orderCosts[cost]]<1)
				System.out.println("Impossible");
			//effectively, if arr[orderCosts[cost]]==0
			else {
				for(int i = 0; i<n; i++) {
					//return singular path to reach total cost
					while(orderCosts[cost] >= menuCosts[i] && arr[orderCosts[cost]-menuCosts[i]]==1) {
						orderCosts[cost] = orderCosts[cost] - menuCosts[i];
						System.out.print(i+1 + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
