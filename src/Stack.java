/**
 * Created by chen4393 on 3/28/17.
 */
public class Stack<T extends Comparable<T>> {
    private int size;
    int top;
    T a[];

    public Stack() {
        size = 5;
        a = (T[])new Comparable[size];
        top = -1;
    }

    Stack(int size) {
        this.size = size;
        a = (T[])new Comparable[size];
        top = -1;
    }

    T pop() {
        if (top == -1) {
            System.out.println("Empty stack");
            return null;
        }
        return a[top--];
    }

    void push(T item)throws StackException {
        if (top + 1 < size) {
            a[++top] = item;
        } else {
            throw new StackException(size);
        }
    }

    void grow() {
        int capacity = a.length;	// physical length
        capacity *= 2;	// grow
        T[] temp = (T[]) new Comparable[capacity];
        for (int i = 0; i <= top; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    void display() {
        for (int i = 0; i <= top; i++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>(2);
        try {
            s.push(1);
            s.push(2);
            s.push(3);
        } catch(StackException e) {
            System.out.println("Stack overflow");
        }
        s.display();
        s.pop();
        s.display();
    }
}
