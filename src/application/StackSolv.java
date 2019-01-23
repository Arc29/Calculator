package application;
import java.util.Scanner;

class StackSolv{
    public String postfix(String s){
        if(s.indexOf(" ")==-1)
        return s;
        else{
            int pos,count,i;char ch=' ';
            if((pos=s.indexOf('('))!=-1){
                count=1;
                for(i=pos+1;count>0;i++){
                    if(s.charAt(i)=='(')
                    count++;
                    else if(s.charAt(i)==')')
                    count--;
                }
                
                return postfix(s.substring(0,pos)+postfix(addSpc(s.substring(pos+1,i-1)))+s.substring(i));
                
            }
            else if((pos=s.indexOf(" ^ "))!=-1)
                return postfix(s.substring(0,s.lastIndexOf(' ',pos-1))+s.substring(s.lastIndexOf(' ',pos-1),pos)+s.substring(pos+3,s.indexOf(' ',pos+3))+"^"+s.substring(s.indexOf(' ',pos+3)));
            else if(s.indexOf(" / ")!=-1||s.indexOf(" * ")!=-1){
                pos=0;i=s.indexOf(' ');
                while(pos==0){
                    if(s.substring(i,i+3).equals(" / ")){
                        ch='/';
                        pos=i;
                    }
                    else if(s.substring(i,i+3).equals(" * ")){
                        ch='*';
                        pos=i;
                    }
                    else
                    i=s.indexOf(' ',i+3);
                }
                return postfix(s.substring(0,s.lastIndexOf(' ',pos-1))+s.substring(s.lastIndexOf(' ',pos-1),pos)+s.substring(pos+3,s.indexOf(' ',pos+3))+ch+s.substring(s.indexOf(' ',pos+3)));
            }
            else if(s.indexOf(" + ")!=-1||s.indexOf(" - ")!=-1){
                pos=0;i=s.indexOf(' ');
                while(pos==0){
                    if(s.substring(i,i+3).equals(" + ")){
                        ch='+';
                        pos=i;
                    }
                    else if(s.substring(i,i+3).equals(" - ")){
                        ch='-';
                        pos=i;
                    }
                    else
                    i=s.indexOf(' ',i+3);
                }
                return postfix(s.substring(0,s.lastIndexOf(' ',pos-1))+s.substring(s.lastIndexOf(' ',pos-1),pos)+s.substring(pos+3,s.indexOf(' ',pos+3))+ch+s.substring(s.indexOf(' ',pos+3)));
            }
            else return postfix(s.trim());
}
}
           String addSpc(String s){
               return "   "+s+" ";
}
int stackSolv(String s){
    Integer n;
    Stack<Integer> stk=new Stack<>(new Integer[s.length()]);
    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(!Character.isDigit(s.charAt(i))){
            if(ch=='+'){
                n=stk.pop()+(stk.pop());
                stk.push(n);
            }
            if(ch=='-'){
                Integer temp=stk.pop();
                n=stk.pop()-temp;
                stk.push(n);
            }
            if(ch=='*'){
                n=stk.pop()*(stk.pop());
                stk.push(n);
            }
            if(ch=='/'){Integer temp=stk.pop();
                n=stk.pop()/temp;
                stk.push(n);
            }
            if(ch=='^'){
                Integer temp=stk.pop();
                n=new Integer((int)Math.pow(stk.pop().intValue(),temp.intValue()));
                stk.push(n);
            }
        }
        else
        stk.push(new Integer(ch-'0'));
    }
    return stk.pop();
}
String addSpc2(String s){
    
    for(int i=0;i<s.length();i++){char ch=s.charAt(i);
        if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='^'){
        if(s.charAt(i-1)!=' '||s.charAt(i+1)!=' '){
        s=s.substring(0,i)+" "+ch+" "+s.substring(i+1);
       i+=2;
}
}
}
    return s;
}
public static void main(String args[]){
    Scanner in=new Scanner(System.in);
    System.out.println("Enter expression without spaces");
    String s=in.nextLine();
    StackSolv ss=new StackSolv();
    s=ss.addSpc2(s);
    s=ss.addSpc(s);
    System.out.println("Answer is:"+ss.stackSolv(ss.postfix(s)));
}
}
    
         