import java.util.Scanner;
import java.util.Stack;

public class TailofTwoStacks {

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();

    }

    public static class MyQueue<T> {
        Stack<T> newest_on_top = new Stack<T>();
        Stack<T> oldest_on_top = new Stack<>();

        public void enqueue (T element){

            newest_on_top.push(element);

        }

        public T dequeue(){

            if(oldest_on_top.empty())
                newest_to_oldest();

            return oldest_on_top.pop();

        }

        public T peek(){

            T oldest_element = dequeue();
            oldest_on_top.push(oldest_element);

            return oldest_element;

        }

        public void newest_to_oldest(){

            while(!newest_on_top.empty()){

                oldest_on_top.push(newest_on_top.pop());
            }
        }

    }

}
