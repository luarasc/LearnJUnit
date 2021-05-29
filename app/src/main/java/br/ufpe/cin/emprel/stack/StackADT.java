package br.ufpe.cin.emprel.stack;

public interface StackADT<T> {

    int size();

    boolean empty();

    T pop();

    void push(T element);

    T peek();
}
