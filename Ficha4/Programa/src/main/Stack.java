package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stack {
    private List<String> stack;

    public Stack(){
        this.stack = new ArrayList<String>();
    }

    public Stack(List<String> stack){
        this.stack = stack.stream().collect(Collectors.toList());
    }

    public Stack(Stack s){
        this.stack = s.stack;
    }

    /**
     * @return List<String> return the stack
     */
    public List<String> getStack() {
        return stack;
    }

    /**
     * @param stack the stack to set
     */
    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    public String top(){
        return this.stack.get(stack.size() - 1);
    }

    public void push(String s){
        stack.add(s);
    }

    public void pop(){
        stack.remove(stack.size() - 1);
    }

    public boolean empty(){
        return this.stack.isEmpty();
    }

    public int length(){
        return stack.size();
    }

}
