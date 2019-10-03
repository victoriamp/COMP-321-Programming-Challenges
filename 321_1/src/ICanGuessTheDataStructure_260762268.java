import java.util.*;
public class ICanGuessTheDataStructure_260762268 {
    public static void main(String[] args){
        //scanner to read input
        Scanner s = new Scanner(System.in);
        //built in Java data structures for queue, priority queue, stack and boolean values for each
        Queue<Integer> queue = new LinkedList<Integer>();
        PriorityQueue<Integer> priority = new PriorityQueue<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean queue_bool, priority_bool, stack_bool;
        int n; //to store current int from scanner

        //for each value "n" in the input
        while(s.hasNext()){
            n = s.nextInt();
            queue_bool = stack_bool = priority_bool = true;

            //for
            for(int i=0; i<n; i++){
                //get comparison, value integers from input
                int comparison = s.nextInt();
                int value = s.nextInt();
                //if type 1 command
                if(comparison==1){
                    stack.push(value);
                    queue.add(value);
                    priority.add(-value);
                }else{
                    //check for each structure whether either it has already been ruled out or if there is a mismatch, thus ruling it out
                    if((stack_bool && stack.isEmpty()) || (stack_bool && stack.pop()!=value))
                        stack_bool=false;
                    if((queue_bool && (queue.isEmpty() || queue.poll()!=value)))
                        queue_bool=false;
                    if(priority_bool && (priority.isEmpty() || -1*value!=priority.poll()))
                        priority_bool = false;
                    //if all are ruled out, we are done --> break out of loop
                    if(!priority_bool && !queue_bool && !stack_bool)
                        break;
                }
            }
            //print conclusion
            if(!queue_bool && !stack_bool && !priority_bool)
                System.out.println("impossible");
            else if(queue_bool && !(stack_bool || priority_bool))
                System.out.println("queue");
            else if(priority_bool && !(queue_bool || stack_bool))
                System.out.println("priority queue");
            else if (stack_bool && !(queue_bool || priority_bool))
                System.out.println("stack");
            else
                System.out.println("not sure");

            //reset values for next iteration
            stack.clear();
            queue.clear();
            priority.clear();
        }
    }
}
