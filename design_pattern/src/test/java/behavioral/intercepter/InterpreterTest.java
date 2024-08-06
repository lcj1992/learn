package behavioral.intercepter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class InterpreterTest {

    @Test
    public void test() {
        String expression = "w x z - +";
        Evaluator sentence = new Evaluator(expression);
        Map<String, Expression> variables = new HashMap<String, Expression>();
        variables.put("w", new Number(5));
        variables.put("x", new Number(10));
        variables.put("z", new Number(42));
        int result = sentence.interpret(variables);
        System.out.println(result);
    }

    public interface Expression {
        int interpret(Map<String, Expression> variables);
    }

    public static class Number implements Expression {
        private final int number;

        public Number(int number) {
            this.number = number;
        }

        public int interpret(Map<String, Expression> variables) {
            return number;
        }
    }

    public static class Plus implements Expression {
        private final Expression leftOperand;
        private final Expression rightOperand;

        Plus(Expression left, Expression right) {
            leftOperand = left;
            rightOperand = right;
        }

        public int interpret(Map<String, Expression> variables) {
            return leftOperand.interpret(variables) + rightOperand.interpret(variables);
        }
    }

    public static class Minus implements Expression {
        private final Expression leftOperand;
        private final Expression rightOperand;

        Minus(Expression left, Expression right) {
            leftOperand = left;
            rightOperand = right;
        }

        public int interpret(Map<String, Expression> variables) {
            return leftOperand.interpret(variables) - rightOperand.interpret(variables);
        }
    }

    public static class Variable implements Expression {
        private final String name;

        Variable(String name) {
            this.name = name;
        }

        public int interpret(Map<String, Expression> variables) {
            if (null == variables.get(name)) return 0; //Either return new Number(0).
            return variables.get(name).interpret(variables);
        }
    }

    public static class Evaluator implements Expression {
        private final Expression syntaxTree;

        Evaluator(String expression) {
            Stack<Expression> expressionStack = new Stack<Expression>();
            for (String token : expression.split(" ")) {
                if (token.equals("+")) {
                    Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
                    expressionStack.push(subExpression);
                } else if (token.equals("-")) {
                    // it's necessary remove first the right operand from the stack
                    Expression right = expressionStack.pop();
                    // ..and after the left one
                    Expression left = expressionStack.pop();
                    Expression subExpression = new Minus(left, right);
                    expressionStack.push(subExpression);
                } else
                    expressionStack.push(new Variable(token));
            }
            syntaxTree = expressionStack.pop();
        }

        public int interpret(Map<String, Expression> context) {
            return syntaxTree.interpret(context);
        }
    }
}
