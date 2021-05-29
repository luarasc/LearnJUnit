package br.ufpe.cin.emprel.stack;

public class UnderFlowStackException extends RuntimeException{
    public UnderFlowStackException() {
        super("Underflow");
    }
}
