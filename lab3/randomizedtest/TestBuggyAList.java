package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {

        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        correct.addLast(4);
        buggy.addLast(4);
        correct.addLast(5);
        buggy.addLast(5);
        correct.addLast(6);
        buggy.addLast(6);

        assertEquals(correct.size(), buggy.size());

        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());

    }

    //    @Test
//    public void randomizedTest() {
//        AListNoResizing<Integer> L = new AListNoResizing<>();
//
//        int N = 500;
//        for (int i = 0; i < N; i += 1) {
//            int operationNumber = StdRandom.uniform(0, 4);
//            if (operationNumber == 0) {
//                // addLast
//                int randVal = StdRandom.uniform(0, 100);
//                L.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
//            } else if (operationNumber == 1) {
//                // size
//                int size = L.size();
//                System.out.println("size: " + size);
//            } else if (operationNumber == 2 && L.size() != 0) {
//                Integer last = L.getLast();
//                System.out.println("last:" + last);
//
//            } else if (operationNumber == 3 && L.size() != 0) {
//                Integer last = L.removeLast();
//                System.out.println("removelast" + last);
//            }
//        }
//    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                int size1 = correct.size();
                int size = broken.size();
                System.out.println("size: " + size);
                assertEquals(size1, size);
            } else if (operationNumber == 2 && broken.size() != 0) {
                Integer last = broken.getLast();
                Integer last1 = correct.getLast();
                System.out.println("last:" + last);
                assertEquals(last1, last);
            } else if (operationNumber == 3 && broken.size() != 0) {
                Integer last = broken.removeLast();
                Integer last1 = correct.getLast();
                System.out.println("removelast" + last);
                assertEquals(last1, last);
            }
        }
    }
}
