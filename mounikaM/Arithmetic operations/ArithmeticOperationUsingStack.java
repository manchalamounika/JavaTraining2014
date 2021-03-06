import java.util.Scanner;
import java.util.Stack;
import java.util.*;
class ArithmeticOperationUsingStack{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a string to evaluate");
		String eval=s.next();
		ArithmeticOperation cal=new ArithmeticOperation();
		int val=cal.expressionEvaluation(eval);
		System.out.println("the value of the expression "+eval+" is");
		System.out.println(val);
	}
}
class ArithmeticOperation{
	public int expressionEvaluation(String eval)
	{
		boolean precedence=false;
		boolean open_parenthesis=false;
		char ch;
		Stack<Integer> operand=new Stack<Integer>();
		Stack<Character> operator=new Stack<Character>();
		for(int i=0;i<eval.length();i++){
			ch=eval.charAt(i);
			switch(ch)
			{
				case '+': 
					try
					{
						while( operator.peek()=='*' || operator.peek()=='/')
						{
							char a=operator.pop();
							operand=evaluation(a,operand);
						}
					}
					catch(Exception e)
					{
					}
					operator.push(ch);	
					break;
				case '-':
					try
					{
						while( operator.peek()=='*' || operator.peek()=='/')
						{
							char b=operator.pop();
							operand=evaluation(b,operand);
						}
					}
					catch(Exception e)
					{
					}
					operator.push(ch);	
					break;
				case '*':
					operator.push(ch);
					break;
				case '/':
					operator.push(ch);
					break;
				case '(':
					operator.push(ch);
					open_parenthesis=true;
					break;
				case ')':
					precedence=false;
					while(!operator.isEmpty() && open_parenthesis==true)
					{
						char op1=operator.pop();
						if(op1!='(')
							operand=evaluation(op1,operand);
						else
							open_parenthesis=false;
					}					
					break;
				default:
					operand.push(Character.getNumericValue(ch));
			}
		}
		while(!operator.isEmpty())
		{
			char op=operator.pop();
			operand=evaluation(op,operand);	
		}
		return operand.pop();
		
		
	}
	Stack<Integer> evaluation(char op,Stack<Integer> operand)
	{
		int x=operand.pop();
		int y=operand.pop();
		switch(op){
			case '+':	
				operand.push(x+y);
				break;
			case '-':	
				operand.push(y - x);
				break;
			case '*':	
				operand.push(y * x);
				break;
			case '/':	
				operand.push(y/x);
				break; 
			default:		
		}	
		return operand;
	}	
}

