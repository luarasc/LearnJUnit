package br.ufpe.cin.emprel.stack;

import java.util.LinkedList;

public class Stack<T> implements StackADT<T> {

    private LinkedList<T> storage;
    private int stackSize;

    public Stack(int size) {
        this.stackSize = size;
        storage = new LinkedList<>();
    }

    @Override
    public int size() {

        return storage.size();
    }

    @Override
    public boolean empty() {
        return (storage.size() == 0);
    }

    @Override
    public T pop() {
        T element = peek();
        this.storage.removeFirst();
        return element;
    }

    @Override
    public void push(T element) {
        if( this.storage.size() < this.stackSize ){
            this.storage.addFirst(element);
        }
        else{
            throw  new OverFlowStackException();
        }


        //this.storage.addFirst(null);
    }

    @Override
    public T peek() {
        if( !empty() ){
            return this.storage.peek();
        }
        throw new UnderFlowStackException();
    }
}
