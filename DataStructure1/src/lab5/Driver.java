package lab5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Driver {

	public static void main(String[] args) {
		readFile("C:\\Users\\HP\\OneDrive\\Desktop\\eclipse\\lab1\\src\\lab1//lab.java");
		System.out.println(checkBalance("C:\\Users\\HP\\OneDrive\\Desktop\\eclipse\\lab1\\src\\lab1//lab.java"));
		System.out.println(infixToPostfix("5 + 16 - 20 * 5 / 6"));
		System.out.println(evaluatePostfix("5 16 + 20 5 * 6 / -"));
		
		double i = (5 + 16 - 20 * 5 / 6);
		System.out.println(i);

	}

	private static void readFile(String filePath) {
		StringBuilder content = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
						content.append(c);
					}
				}
			}
			System.out.println(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkBalance(String str) {
		Stack<Character> stack = new Stack<>();

		for (char c : str.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	public static int precedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}

	public static String infixToPostfix(String str) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (char ch : str.toCharArray()) {
			switch (ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				int chPrecedence = precedence(ch);
				while (!stack.isEmpty() && chPrecedence <= precedence(stack.peek())) {
					result.append(stack.pop());
				}
				stack.push(ch);
				break;
			case '(':
				stack.push(ch);
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') {
					result.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					return "Invalid Expression";
				} else {
					stack.pop();
				}
				break;
			default:
				if (Character.isLetterOrDigit(ch)) {
					result.append(ch);
				}
				break;
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				return "Invalid Expression";
			}
			result.append(stack.pop());
		}

		return result.toString();
	}
	
	//evaluate the postfix using stack
    public static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.size() < 2) {
                    System.out.println("Invalid postfix expression");
                    return 0;
                }
                
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = 0;
                
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            System.out.println("Division by zero error");
                            return 0;
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        System.out.println("Invalid operator: " + token);
                        return 0;
                }
                
                stack.push(result);
            }
        }
        
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            System.out.println("Invalid postfix expression");
            return 0;
        }
    }
    
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
