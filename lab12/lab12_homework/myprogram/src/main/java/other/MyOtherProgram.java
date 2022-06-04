package other;

import annot.Test;

/**
 *
 * @author vital
 */
@Test
public class MyOtherProgram {

    public String name;
    public int age;

    public static void main(String[] args) {

    }

    @Test
    public void t1(int x) {
    }

    @Test
    public void t2(String st) {
    }

    @Test
    public void t3() {
        throw new RuntimeException("Boom");
    }

    public void t4() {
    }

    @Test
    public void t5() {
    }

    public void t6() {
    }

    @Test
    public void t7() {
        throw new RuntimeException("Crash");
    }

    public void t8() {
    }
}
