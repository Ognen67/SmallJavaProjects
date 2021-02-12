package com.github.ognen67.newtonRaphson;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class NewtonRaphson {


    public static double evaluate(String expression, double x1) {

        char[] tokens = expression.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == 'x') {
                tokens[i] = (char) (x1 + '0');
            }
        }

        Stack<Double> values = new
                Stack<Double>();

        Stack<Character> ops = new
                Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' &&
                    tokens[i] <= '9') {
                StringBuilder sbuf = new
                        StringBuilder();

                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.
                        toString()));

                i--;
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/' ||
                    tokens[i] == '^') {

                while (!ops.empty() &&
                        hasPrecedence(tokens[i],
                                ops.peek()))
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));

        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '^':
                return (int) Math.pow(a, b);
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return (double) a / b;
        }
        return 0;
    }


    public static void main(String[] args) {
        // x^3 + 2x - 2 = 0
        // the derivative is: 3*x^2 + 4x + 1
        // xn+1  = xn - f(x)/f'(x)

        String function = "x^3+2*x-2=0";
        String derivative = "3*x^2+4*x+1";

        Stack<Character> stack = new Stack<>();

        Scanner input = new Scanner(System.in);
        int x1 = Integer.parseInt(input.nextLine());

        char[] fun = function.toCharArray();

        for (int i = 0; i < fun.length; i++) {
            if (fun[i] == 'x') {
                fun[i] = (char) (x1 + '0');
            }
        }

        double f = evaluate("x^3+2*x-2", x1);
        double fderiv = evaluate("3*(x^2)+4*x+1", x1);

        System.out.println(f);
        System.out.println(fderiv);

        double x2 = x1 - f / fderiv;
        System.out.println(x2);


        f = evaluate("x^3+2*x-2", x2);
        fderiv = evaluate("3*(x^2)+4*x+1", x2);

        double x3 = x2 - f / fderiv;
        System.out.println(x3);
    }
}
