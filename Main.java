
import java.util.Stack;

public class Main {
    Stack<Integer> numbers = new Stack<>();

    public int addNumber( int x){
        return numbers.push(x);
    }

    public void display(){
        System.out.println("Original stack: " + numbers);
    }

    public int removeNumber (int x){
        Stack<Integer> tempStack = new Stack<>();
        // search element if is existed
        if (numbers.search(x) != -1){
            // if stack is not empty
            while(!numbers.isEmpty()){

                int top = numbers.pop();
                //if element is at top of stack
                if (top == x){
                    // remove element and break loop
                    break;
                }
                // Keep the other elements in a temporary stack
                tempStack.push(top);
            }
            // Restore the other elements back to the original stack
            while (!tempStack.isEmpty()) {
                numbers.push(tempStack.pop());
            }

            // Return the removed number
            return x;
        }else{
            return 0;
        }
    }
    public Stack<Integer>  updateStack(Stack<Integer> stack, int index, Integer newValue){
        if (index >= 0 && index < stack.size()) {
            stack.set(index, newValue);  // Update the element at the given index
        } else {
            System.out.println("Index out of bounds");
        }
        return stack;
    }
    public static void main(String[] args) {
        Main main = new Main();  // Create an instance of Main
        main.addNumber(5);
        main.addNumber(6);
        System.out.println("Elements in stack:");
        main.display();
        System.out.println("==========");

        // Remove element
        main.removeNumber(6);
        System.out.println("Elements in stack after removing 6:");
        main.display();
        System.out.println("==========");

        // Update the stack
        main.updateStack(main.numbers, 0, 10);
        System.out.println("Elements in stack after update:");
        main.display();
        System.out.println("==========");


    }
}