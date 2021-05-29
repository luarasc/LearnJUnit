package br.ufpe.cin.emprel.stack;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class StackTest {

    private final int STACK_SIZE = 10;
    public Stack<Integer> stack;
    //Fixtures
    @BeforeEach
    void setup() {
        stack = new Stack<>(STACK_SIZE);
    }



    @Test
    @DisplayName("Testar inicialmente se a pilha inicialmente está vazia")
    void empty() {
        //oráculo
        assertEquals(
                true,
                stack.empty(),
                "Pilha inicialmente deveria estar vazia"
        );
    }

    @Test
    @DisplayName("Pilha não está vazia após inserir um elemento")
    void notEmptyAfterPush() {
        stack.push(10);
        //oráculo
        assertNotEquals(
                true,
                stack.empty(),
                "Pilha não deveria estar vazia após um push"
        );
    }

    @Test
    void push() {
        stack.push(90);
        stack.push(112);
        stack.push(28);
        assertEquals(3, stack.size(), "a quantidade de elementos nao deveria ser menor que 3");
        assertEquals(28, stack.pop().intValue());
        assertEquals(112, stack.pop());
        assertEquals(90, stack.pop());
    }

    @Test
    @DisplayName(" Testar a remoção de elemento no topo da pilha")
    void pop() {
        //Adicionar elementos.
        stack.push(12);
        stack.push(10);
        //verificar se existe um elemento : empty() == false #
        assertNotEquals(true, stack.empty(), "A pilha não contêm elementos");
        assertEquals(10, stack.peek());
        assertNotNull(stack.pop());
        assertEquals(12, stack.peek());
    }



    @Test
    @DisplayName("testar se corresponde ao valor esperado no topo")
    void peek() {
        stack.push(90);
        assertEquals(90, stack.peek() );
        assertEquals(1, stack.size() );
        stack.push(112);
        assertEquals(112, stack.peek() );
        assertEquals(2, stack.size() );
        stack.push(28);
        assertEquals(28, stack.peek() );
        assertEquals(3, stack.size() );
        assertEquals(28, stack.peek() );
    }

    @Test
    void testPeek () {
        stack.push(90);
        //assertAll() O conjunto d
        assertAll(
                ()-> assertEquals(90, stack.peek()),
                ()-> assertEquals(1, stack.size())
        );
    }

    @Test
    void testPopEmptyStack() {
        stack.push(8);
        Integer element = stack.pop();
        assertEquals(8, element);
    }

    @Test
    @Tag("exceptions")
    @DisplayName( "TestPopEmptyStackNotRecommended" )
    void TestPopEmptyStackNotRecommended() {
        try{
            Integer element = stack.pop();
        }
        catch(RuntimeException e ) {
            assertEquals("Underflow", e.getMessage() );
        }
    }

    @Test
    @Tag("exceptions")
    void testUnderflowOnEmptyStack() {
        RuntimeException exception =  assertThrows(
                UnderFlowStackException.class,
                () -> stack.pop() );
        assertEquals( "Underflow", exception.getMessage() );
    }


    private void fillStack() {
        while( stack.size() < STACK_SIZE ) {
            stack.push(1);
        }
    }

    @Test
    @Tag("exceptions")
    @DisplayName("OverFlowTest")
    void testOverFlowException() {
        assertThrows(
                OverFlowStackException.class,
                () -> {
                    fillStack();
                    stack.push(11);
                }
        );
    }

    @Test
    @Tag("exceptions")
    void testOverflowOnFullStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        assertThrows(OverFlowStackException.class,
                ()-> stack.push(11)
        );
    }
}