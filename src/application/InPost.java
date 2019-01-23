package application;

import java.util.*;

class InPost{
    String infix,postfix;
    char[] arr;
    int top;
    InPost(){
        top=-1;
        arr=new char[10];
        infix=postfix="";
    }
    void input(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter infix notation");
        infix=in.next();
    }
    void push(char ch){  //Push into stack
        if(top+1==10){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top]=ch;
    }
    char pop(){  //Pop from stack
        if(top==-1)
        return ' ';
        else
        return arr[top--];
    }
    char readStack(){  //Read topmost element of stack
        if(top==-1){
            return ' ';
        }
        else
        return arr[top];
    }
    int precedence(char ch){
        if(ch=='$'||ch=='^')
        return 5;
        else if(ch=='*'||ch=='/')
        return 4;
        else if(ch=='+'||ch=='-')
        return 3;
        else if(ch==')')
        return 2;
        else if(ch=='(')
        return 1;
        else return 0;
    }
    String convert(){   //Convert infix to postfix using the algorithm
        infix+=")";
        Stack<String> stk=new Stack<String>(new String[10]);
        stk.push("(");char c;
        for(int i=0;i<infix.length();i++){
            c=infix.charAt(i);
            if(c=='(')
            stk.push("(");
            else if(c==')'){
                while(stk.peek()!="(")
                postfix+=(stk.pop()+" ");
                stk.pop();
            }
            
            else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^'){
                int a=precedence(c);
                int b=precedence(stk.peek().charAt(0));
                if(b>=a){
                	while(b>=a) {
                    postfix+=(stk.pop()+" ");
                    
                    b=precedence(stk.peek().charAt(0));
                	}
                	stk.push(Character.toString(c));
                }
                else
                	stk.push(Character.toString(c));
            }
            else {
            	String num="";
            	if(i<(infix.length()-2)&&"sincostanloglgnexp".indexOf(infix.substring(i,i+3))!=-1) {
            		while(c!=')') {
            			num+=c;
            			i++;
            			c=infix.charAt(i);
            		}
            		num+=infix.charAt(i++);
            	}
            	else {
            	while(Character.isLetter(c)||Character.isDigit(c)||c=='.') {
            		num+=c;
            		i++;
            		c=infix.charAt(i);
            	}
            	}
            	postfix+=(num+" ");
            		i--;
            	
            }
        }
        return postfix;
    }
    String stackSolv(String pf,int base,boolean isRad ) {
    	StringTokenizer st=new StringTokenizer(pf);
    	Stack<Double> stk=new Stack<Double>(new Double[10]);
    	while(st.hasMoreTokens()) {
    		String temp=st.nextToken();
    		if("+-*/^".indexOf(temp)==-1) {
    			if(temp.length()>3&&"sincostanlgnlogexp".indexOf(temp.substring(0,3))!=-1)
    				temp=funcSimp(temp,base,isRad);
    			else temp=baseConv(temp,base);
    		
    			stk.push(Double.parseDouble(temp));
    		}
    		else {
    			
    			if(temp.equals("+") )
    				stk.push(stk.pop()+stk.pop());
    			else if(temp.equals("-") ) {
    				double tmp=stk.pop();
    				stk.push(stk.pop()-tmp);
    				
    			}
    			else if(temp.equals("*") ) {
    				double tmp=stk.pop();
    				stk.push(stk.pop()*tmp);
    				
    			}
    			else if(temp.equals("/") ) {
    				double tmp=stk.pop();
    				stk.push(stk.pop()/tmp);
    				
    			}
    			else if(temp.equals("^") ) {
    				double tmp=stk.pop();
    				stk.push(Math.pow(stk.pop(),tmp));
    				
    			}
    		}
    	}
    	return baseReConv(stk.pop().toString(),base);
    }
String funcSimp(String inf,int base,boolean isRad) {
	InPost obj=new InPost();
	
    	obj.infix=inf.substring(inf.indexOf("(")+1,inf.indexOf(")"));
	
    	double t1=Double.parseDouble(obj.stackSolv(obj.convert(), base, isRad));
    	String ret="";
    	if(inf.substring(0,3).equals("sin")) {
    		if(isRad)
    			ret= Double.toString(Math.sin(t1));
    		else
    			ret= Double.toString(Math.sin(Math.toRadians(t1)));
    	}
    	else if(inf.substring(0,3).equals("cos")) {
    		if(isRad)
    			ret= Double.toString(Math.cos(t1));
    		else
    			ret= Double.toString(Math.cos(Math.toRadians(t1)));
    	}
    	else if(inf.substring(0,3).equals("tan")) {
    		if(isRad)
    			ret= Double.toString(Math.tan(t1));
    		else
    			ret= Double.toString(Math.tan(Math.toRadians(t1)));
    	}
    	else if(inf.substring(0,3).equals("log")) {
    		
    			ret= Double.toString(Math.log10(t1));
    		
    	}
    	else if(inf.substring(0,3).equals("lgn")) {
    		
			ret= Double.toString(Math.log(t1));
		
	}
    	else if(inf.substring(0,3).equals("exp")) {
    		
			ret= Double.toString(Math.exp(t1));
		
	}
    	return ret;
}
String baseConv(String s,int old) {
	if(old==10)
		return s;
	double d=0;
	int k=0;
	for(int i=s.length()-1;i>=0;i--) {
		if(Character.isDigit(s.charAt(i)))
		d+=(((int)(s.charAt(i)-'0'))*Math.pow(old,k++ ));
		else
			d+=(((int)(s.charAt(i)-55))*Math.pow(old,k++ ));	
	}
	return Double.toString(d);
		
	
}
String baseReConv(String s,int old) {
	if(old==10)
		return s;
	else {
		String code="";
		int n=(int)Double.parseDouble(s);
    for(int k=n;k>0;k/=old) {
    	
    if(k%old<10)
    code=(k%old)+code;
    else
    	code=((char)((k%old)+55))+code;
    
    }
    return code;
}

}

    
    public static void main(String args[]){
        InPost obj=new InPost();
       obj.infix="sin(30)+log(100/10)";
       System.out.println(obj.stackSolv(obj.convert(),10,false));
    }
}
 

