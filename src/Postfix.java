/**
 * Created by chen4393 on 3/28/17.
 */
public class Postfix {
    static double evaluate(String[] expression) {
        Stack<Double> s = new Stack<Double>();
        for (String token : expression) {
            if (isNumeric(token) == true) {
                double d = Double.parseDouble(token);
                try {
                    s.push(d);
                } catch (StackException e) {
                    System.out.println("Stack overflow");
                    s.grow();
                }
            } else {
                double num1 = s.pop();
                double num2 = s.pop();
                if (token.equals("+")) {
                    try {
                        s.push(num1 + num2);
                    } catch (StackException e) {
                        System.out.println("Stack overflow");
                        s.grow();
                    }
                } else if (token.equals("-")) {
                    try {
                        s.push(num1 - num2);
                    } catch (StackException e) {
                        System.out.println("Stack overflow");
                        s.grow();
                    }
                } else if (token.equals("*")) {
                    try {
                        s.push(num1 * num2);
                    } catch (StackException e) {
                        System.out.println("Stack overflow");
                        s.grow();
                    }
                } else if (token.equals("/")) {
                    try {
                        s.push(num2 / num1);
                    } catch (StackException e) {
                        System.out.println("Stack overflow");
                        s.grow();
                    }
                }
            }
        }
        return s.pop();
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] exp1 = {"1", "2", "+", "3", "3", "+", "/"};
        String[] exp2 = {"3.14", "2", "*"};
        String[] exp3 = {"1", "2", "+", "3", "3", "+", "2", "1", "*",
                "4", "3", "-", "1", "1", "+", "+", "+", "+"};
        double ans1 = evaluate(exp1);
        System.out.println(ans1);
        double ans2 = evaluate(exp2);
        System.out.println(ans2);
        double ans3 = evaluate(exp3);
        System.out.println(ans3);
    }
}
