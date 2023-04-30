package test.datastructures;


import model.HashTable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    private HashTable<Integer, String> ht = new HashTable<Integer, String>(10);

    public void setupStage1() {
        ht.put(1, "persona1");
        ht.put(456, "persona2");
        ht.put(719, "persona3");
        ht.put(3, "persona4");
    }

    public void setupStage2() {
        ht.put(1, "persona1");
        ht.put(456, "persona2");
        ht.put(719, "persona3");
        ht.put(3, "persona4");
        ht.put(523, "persona5");
        ht.put(6455, "persona6");
        ht.put(71, "persona7");
        ht.put(309, "persona8");
        ht.put(864, "persona9");
        ht.put(69, "persona10");
        ht.put(4879, "persona11");
        ht.put(305, "persona12");
        ht.put(956, "persona13");
        ht.put(895, "persona14");
        ht.put(425, "persona15");
        ht.put(532, "persona16");
    }

    public void setupStage3() {
        ht.put(1, "persona1");
        ht.put(1, "persona2");
        ht.put(1, "persona3");
        ht.put(1, "persona4");
    }

    @Test
    public void testRetrieveObjectsStandard() {
        setupStage1();
        String result = ht.get(1);
        String result1 = ht.get(456);
        String result2 = ht.get(719);
        String result3 = ht.get(3);
        assertEquals("persona1",result);
        assertEquals("persona2",result1);
        assertEquals("persona3",result2);
        assertEquals("persona4",result3);
    }

    @Test
    public void testRetrieveObjectsBorder() {
        setupStage2();
        String result = ht.get(1);
        String result1 = ht.get(456);
        String result2 = ht.get(719);
        String result3 = ht.get(3);
        String result4 = ht.get(523);
        String result5 = ht.get(6455);
        String result6 = ht.get(71);
        String result7 = ht.get(309);
        String result8 = ht.get(864);
        String result9 = ht.get(69);
        String result10 = ht.get(4879);
        String result11 = ht.get(305);
        String result12 = ht.get(956);
        String result13 = ht.get(895);
        String result14 = ht.get(425);
        String result15 = ht.get(532);

        assertEquals("persona1",result);
        assertEquals("persona2",result1);
        assertEquals("persona3",result2);
        assertEquals("persona4",result3);
        assertEquals("persona5",result4);
        assertEquals("persona6",result5);
        assertEquals("persona7",result6);
        assertEquals("persona8",result7);
        assertEquals("persona9",result8);
        assertEquals("persona10",result9);
        assertEquals("persona11",result10);
        assertEquals("persona12",result11);
        assertEquals("persona13",result12);
        assertEquals("persona14",result13);
        assertEquals("persona15",result14);
        assertEquals("persona16",result15);
    }

    @Test
    public void testRetrieveObjectsInteresting() {
        setupStage2();
        String result = ht.get(1);
        String result1 = ht.get(1);
        String result2 = ht.get(1);
        String result3 = ht.get(1);

        assertEquals("persona1",result);
        assertEquals("persona1",result1);
        assertEquals("persona1",result2);
        assertEquals("persona1",result3);
    }

   /* @Test
    public void testRemoveObjectsStandard() {
        setupStage1();
        String result = ht.remove(1);
        String result1 = ht.getValue(456);
        String result2 = ht.getValue(719);
        String result3 = ht.getValue(3);
        assertEquals("",result);
        assertEquals("",result1);
        assertEquals("",result2);
        assertEquals("",result3);
    }

    @Test
    public void testRemoveObjectsBorder() {
        setupStage2();
        String result = ht.remove(1);
        String result1 = ht.remove(456);
        String result2 = ht.remove(719);
        String result3 = ht.remove(1);
        String result4 = ht.remove(456);
        String result5 = ht.remove(719);

        assertEquals("",result);
        assertEquals("",result1);
        assertEquals("",result2);
        assertEquals("Value not found to delete",result3);
        assertEquals("Value not found to delete",result4);
        assertEquals("Value not found to delete",result5);
    }

    @Test
    public void testRemoveObjectsInteresting() {
        setupStage3();
        String result = ht.remove(1);
        String result1 = ht.getValue(1);
        String result2 = ht.remove(1);
        String result3 = ht.getValue(1);
        String result4 = ht.remove(1);
        String result5 = ht.getValue(1);
        String result6 = ht.remove(1);
        String result7 = ht.getValue(1);
        String result8 = ht.remove(1);

        assertEquals("",result);
        assertEquals("persona1",result1);
        assertEquals("",result2);
        assertEquals("persona1",result3);
        assertEquals("",result4);
        assertEquals("persona1",result5);
        assertEquals("",result6);
        assertNull(result7);
        assertEquals("Value not found to delete",result8);
    }

*/



}