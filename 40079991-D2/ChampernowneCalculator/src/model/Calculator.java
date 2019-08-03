package model;

import java.util.Stack;

/**
 * Class to produce the operations of the Calculator Panel
 * @author nellybett
 *
 */
public class Calculator {
	char[] operators={'+','-','*','/'};
	Caretaker caretaker = new Caretaker();
	Originator originator = new Originator();
	
	/**
	 * Caretaker to get mementos
	 * @return the element
	 */
	public Caretaker getCaretaker() {
		return caretaker;
	}

	/**
	 * Setter of caretaker
	 * @param caretaker new value
	 */
	public void setCaretaker(Caretaker caretaker) {
		this.caretaker = caretaker;
	}

	/**
	 * Originator of memento pattern
	 * @return the attribute
	 */
	public Originator getOriginator() {
		return originator;
	}

	/**
	 * Setter of originator
	 * @param originator the new value
	 */
	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
	
	/**
	 * Determines if a char is in the operators array
	 * @param elem the element
	 * @return boolean
	 */
	public boolean isOperator(char elem){
		for(char x:this.operators){
			if(x==elem)
				return true;
		}
		return false;
	}
	
	/**
	 * Power operation
	 * @param i base
	 * @param j exponent
	 * @return result
	 */
	public static double pow(double i, int j){ 
	        if (j == 0) 
	            return 1; 
	        else if (j % 2 == 0) 
	            return pow(i, j / 2) * pow(i, j / 2); 
	        else
	            return i * pow(i, j / 2) * pow(i, j / 2); 
	 }
	 
	/**
	 * Executes an operation
	 * @param operator operator
	 * @param b operand
	 * @param a operand
	 * @return result
	 */
	 public static double operate(char operator, double b, double a){ 
	        switch (operator){ 
	        case '+': 
	            return a + b; 
	        case '-': 
	            return a - b; 
	        case '*': 
	            return a * b; 
	        case '/': 
	            if (b == 0) 
	                throw new
	                UnsupportedOperationException("Cannot divide by zero"); 
	            return a / b; 
	        case '^':
	        	return Math.pow(a, b);
	        } 
	        return 0; 
	    } 
	 
	 /**
	  * Floor operation
	  * @param num the number
	  * @return the result
	  */
	 public static int floor(double num){
		 
		 if(num<0){
			 return (int) (num-(num%1))-1;
		 }else
			 return (int) (num-(num%1));
	 }
	 
	 /**
	  * log2 operation
	  * @param num number to apply the operation
	  * @return double result
	  */
	 public static double log2(double num){
		return (num>1)? 1+log2(num/2):0;
	 }
	 
	 /**
	  * Precedence function
	  * @param op1 first operator
	  * @param op2 second operator
	  * @return boolean with precendence
	  */
	 public static boolean isPrecedent(char op1, char op2){ 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false; 
        if ((op1 == '^') && (op2=='*' || op2 == '/' || op2 == '+' || op2 == '-'))
        	return false;
        else
            return true; 
    } 
	
	/**
	 * Calculates the value of a mathematical expression 
	 * @param expressionMath the expression
	 * @return the result, doble value
	 */
	public double calculate(String expressionMath){
		char[] expression=expressionMath.toCharArray();
        Stack<Double> operands = new Stack<Double>(); 
        Stack<Character> operators = new Stack<Character>(); 
       
        
		for(int i=0;i<expression.length;i++){
			
			//Space
			if(expression[i]==' '){
				continue;
			}
			
			//Negative Unary
			else if(expression[i]=='-' && i+1<expression.length && expression[i+1]!=' '){
				operands.push(Double.valueOf(-1));
				
				while (!operators.empty() && isPrecedent('*', operators.peek())) 
	                  operands.push(operate(operators.pop(), operands.pop(), operands.pop())); 
				
				operators.push('*');
			}
			
			//Numbers
			else if((expression[i]>='0' && expression[i]<='9')){
				String number="";
				int counter=0;
				
				//Integer part
				while(i<expression.length && ((expression[i]>='0' && expression[i]<='9'))){
						number=number+expression[i];
						i=i+1;
				}
				
				//Decimal Part
				if(i+1<expression.length && expression[i]=='.' && (expression[i+1]>='0' && expression[i+1]<='9')){
					number=number+expression[i];
					i=i+1;
					while(i<expression.length && ((expression[i]>='0' && expression[i]<='9'))){
						if(counter<4)
							number=number+expression[i];
						i=i+1;
						counter=counter+1;
					}
				}
				
				//Decimal Error
				if(i+1<expression.length && expression[i]=='.' && !(expression[i+1]>='0' && expression[i+1]<='9')){
					return -1;
				}

				i=i-1;
				operands.push(Double.valueOf(number));
			}
			
			//Operators
			else if(isOperator(expression[i]) && expression[i+1]==' '){
				
				 while (!operators.empty() && isPrecedent(expression[i], operators.peek())) 
	                  operands.push(operate(operators.pop(), operands.pop(), operands.pop())); 
	  
	                // Push operator. 
				 
	             operators.push(expression[i]); 
			}
			
			//Champernowne Constant
			else if(expression[i]=='C' && i+2<expression.length && expression[i+1]=='1' && expression[i+2]=='0'){
				operands.push(Double.valueOf(ChampernowneModel.calculate(3, 10)));
				i=i+2;
			}
			
			//New expression
			else if(expression[i]=='('){
				operators.push(expression[i]);
			}
			
			else if(expression[i]==')'){
				while (operators.peek() != '(') 
	                operands.push(operate(operators.pop(), operands.pop(), operands.pop())); 
	            operators.pop();
	            	
			}
			
		}
		
		//Elements left
		 while (!operators.empty()){
			 char operator=operators.pop();
			 if(isOperator(operator))
				 operands.push(operate(operator, operands.pop(),operands.pop()));
		 }
	             
		 
		return operands.pop();
		
	}
	
	
}
