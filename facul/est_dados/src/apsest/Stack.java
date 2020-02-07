/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsest;

/**
 *
 * @author Roverson
 */
public class Stack {
    private StackNode top;
    private class StackNode{
        private Object element;
        private StackNode next;
        private StackNode(Object o, StackNode n){
            element=o;
            next=n;
        }
    }
    public Stack(){
      top=null;
    }
    public boolean isEmpty(){
        return (top==null);
    }
    public void makeEmpty(){
        top=null;
    }
    public void push(Object o){
        StackNode node= new StackNode(o,top);
        top=node;
    }
    public void pop(){
        if(!isEmpty())
            top=top.next;            
    }
    public Object top(){
        if(isEmpty())
            return null;
        
        return top.element;
    }
    public Object topAndPop(){
        if(isEmpty())
            return null;
        
        Object tmp = top.element;
        top=top.next;
        return tmp;
    }
    
    public void printStack(){
        if(!isEmpty()){
            StackNode itr = top;
            while(itr!=null){
                System.out.println(itr.element);
                itr=itr.next;
            }
        }
    }
}
