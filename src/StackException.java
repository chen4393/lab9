/**
 * Created by chen4393 on 3/28/17.
 */
public class StackException extends Exception {

    private int size;

    StackException(int size) {
        this.size = size;
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        int size = -1;
        try {
            if (size < 0)
                throw new StackException(size);
        } catch (StackException e) {
            System.out.println("Catch an exception");
            System.out.println(e.getSize());
        }
    }
}
