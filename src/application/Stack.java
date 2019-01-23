package application;

class Stack<T>{
    int top,size;
    T[] arr;
    public Stack(T[] n){
        size=n.length;
        arr=n;
        top=-1;
    }
    void push(T el){
        if((top+1)==size)
        System.out.println("Stack overflow");
        else
        arr[++top]=el;
    }
    
    T pop(){
        if(top==-1){
        System.out.println("Stack underflow");
        return null;}
        else
        return(arr[top--]);
    }
    T peek(){
        if(top==-1)
        return null;
        else
        return arr[top];
    }
}