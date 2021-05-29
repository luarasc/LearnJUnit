package br.ufpe.cin.emprel.stack;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class JUnitFeaturesTest {

    @Test
    @DisplayName("Exemplos de metodos de assertion")
    void learnAssertions() {
        Object obj1 = new Object();
        Object obj2 = obj1;

        assertAll(
                () ->   assertNotEquals(1,2),
                () ->   assertTrue(true),
                () ->   assertFalse(false),
                () ->   assertNull(null),
                () ->   assertNotNull(obj1)
        );
        /*
        assertAll() -> Para agrupar assertions, as falhas irão ser reportadas em conjunto;
        Executa todos em sequência mesmo se algum método de assertion falhar;
        */


        assertSame(obj1, obj2);
        obj2 = new Object();
        assertNotSame(obj1, obj2);

        int[] a1 = {1,2,3,4};
        int[] a2 = {4,3,2,1};
        Arrays.sort(a2);
        assertArrayEquals( a1, a2);
    }


    @Test
    @DisplayName("Teste assunption")
    void testOnlyOnDev() {
        assumeTrue( 1<2);
        System.out.println("Teste executa se a assumption for satisfeita");
    }


    @Disabled("Disabled até que o bug X seja corrigido.")
    @Test
    void testBuggyMethod(){
        System.out.println("bug X");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testRunsOnlyOnMac() {
        System.out.println("testRunsOnlyOnMac");

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testRunsOnlyOnLinux() {
        System.out.println("testRunsOnlyOnLinux()");

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testRunsOnlyOnWindows() {
        System.out.println("testRunsOnlyOnWindows()");

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testOnSpecifcJRE11() {
        System.out.println("Test Running on JAVA_11");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testOnSpecifcJRE8() {
        System.out.println("Test Running on JAVA_8");
    }

}
