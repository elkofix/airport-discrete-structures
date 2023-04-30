package test.datastructures;

import model.Passenger;
import model.PriorityQueueMethod;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
public class PriorityQueueTest {

    private PriorityQueueMethod<Passenger> pq = new PriorityQueueMethod<Passenger>();
    public void setupStage1() {
        pq.insert(new Passenger(1596745256, "A23", 1, "08:07:40", 500, 1, 0, 2, 3, 1));
        pq.insert(new Passenger(4567854, "B23", 1, "07:12:25", 0, 1, 1, 1, 1, 0));
        pq.insert(new Passenger(23549845, "C23", 1, "06:07:40", 200, 1, 1, 1, 2, 1));

    }

    public void setupStage2() {

    }

    public void setupStage3() {
        pq.insert(new Passenger(1596745256, "A23", 1, "08:07:40", 500, 1, 0, 2, 3, 1));
        pq.insert(new Passenger(21537832, "A23", 1, "08:07:40", 500, 1, 0, 2, 3, 1));
        pq.insert(new Passenger(104285412, "A23", 1, "08:07:40", 500, 1, 0, 2, 3, 1));
    }

    @Test
    public void testRemoveObjectStandard() {
        setupStage1();
        String result = pq.remove().getCedula()+"";
        String result1 = pq.remove().getCedula()+"";
        String result2 = pq.remove().getCedula()+"";

        assertEquals("1596745256",result);
        assertEquals("23549845",result1);
        assertEquals("4567854",result2);
    }

    @Test
    public void testRemoveObjectsBorder() {
        setupStage2();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            pq.remove();
        });

    }

    @Test
    public void testRemoveObjectsInteresting() {
        setupStage3();
        String result = pq.remove().getCedula()+"";
        String result1 = pq.remove().getCedula()+"";
        String result2 = pq.remove().getCedula()+"";
        assertEquals("1596745256",result);
        assertEquals("104285412",result1);
        assertEquals("21537832",result2);

    }

    @Test
    public void testIsEmptyStandard() {
        setupStage1();
        boolean result = pq.isEmpty();
        assertFalse(result);
    }

    @Test
    public void testIsEmptyBorder() {
        setupStage2();
        boolean result = pq.isEmpty();
        assertTrue(result);
    }

    @Test
    public void testIsEmptyInteresting() {
        setupStage3();
        boolean result = pq.isEmpty();
        pq.remove();
        pq.remove();
        pq.remove();
        boolean result2 = pq.isEmpty();
        assertFalse(result);
        assertTrue(result2);
    }

    @Test
    public void testSizeStandard() {
        setupStage1();
        int result = pq.size();
        assertEquals(3, result);
    }

    @Test
    public void testSizeBorder() {
        setupStage2();
        int result = pq.size();
        assertEquals(0, result);
    }

    @Test
    public void testSizeInteresting() {
        setupStage3();
        int result = pq.size();
        pq.remove();
        int result2 = pq.size();
        pq.remove();
        int result3 = pq.size();
        pq.remove();
        int result4 = pq.size();
        assertEquals(3, result);
        assertEquals(2, result2);
        assertEquals(1, result3);
        assertEquals(0, result4);
    }

    @Test
    public void testPeekStandard() {
        setupStage1();
        String result = pq.peek().getCedula()+"";
        assertEquals("1596745256", result);

    }

    @Test
    public void testPeekBorder() {
        setupStage2();
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            pq.peek();
        });;

    }

    @Test
    public void testPeekInteresting() {
        setupStage3();
        String result1 = pq.peek().getCedula()+"";
        pq.remove();
        String result2 = pq.peek().getCedula()+"";
        pq.remove();
        String result3 = pq.peek().getCedula()+"";
        pq.remove();

        assertEquals("1596745256", result1);
        assertEquals("104285412", result2);
        assertEquals("21537832", result3);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            pq.peek();
        });;

    }
    
}
