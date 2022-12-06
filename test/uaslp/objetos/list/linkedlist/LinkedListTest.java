package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exceptions.NullNotAllowedException;
import uaslp.objetos.list.exceptions.WrongIndexException;

public class LinkedListTest {

    @Test
    void givenAnEmptyList_thenSizeIsZero() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        int actualSize = list.size();

        //Then:
        Assertions.assertEquals(0, actualSize);
    }

    @Test
    void givenAnEmptyList_whenAddAtTail_thenSizeIsOne() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        list.addAtTail("First");
        int actualSize = list.size();

        //Then:
        Assertions.assertEquals(1, actualSize);
        Assertions.assertEquals("First", list.getAt(0));
    }

    @Test
    void givenAnNonEmptyList_whenAddAtTail_thenSizeIsTwo() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtTail("First");

        // When:
        list.addAtTail("Second");
        int actualSize = list.size();

        //Then:
        Assertions.assertEquals(2, actualSize);
        Assertions.assertEquals("First", list.getAt(0));
        Assertions.assertEquals("Second", list.getAt(1));
    }

    @Test
    void givenAnNonEmptyList_whenAddAtTailWithNull_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // When:
        // Then:
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.addAtTail(null));
    }

    @Test
    void givenAnEmptyList_whenAddAtFront_thenSizeIsOne() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        list.addAtFront("First");
        int actualSize = list.size();

        //Then:
        Assertions.assertEquals(1, actualSize);
        Assertions.assertEquals("First", list.getAt(0));
    }

    @Test
    void givenAnNonEmptyList_whenAddAtFront_thenSizeIsTwo() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // When:
        list.addAtFront("Second");
        int actualSize = list.size();

        // Then:
        Assertions.assertEquals(2, actualSize);
        Assertions.assertEquals("First", list.getAt(1));
        Assertions.assertEquals("Second", list.getAt(0));
    }

    @Test
    void givenAnNonEmptyList_whenAddAtFrontWithNull_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // When:
        // Then:
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.addAtFront(null));
    }

    @Test
    void givenAList_whenSetAtLessThanZero_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.setAt(-1, "test"));
    }

    @Test
    void givenAList_whenSetAtGreaterThanSize_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.setAt(2, "test"));
    }

    @Test
    void givenAList_whenSetAtWithNull_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // Then:
        Assertions.assertThrows(NullNotAllowedException.class, () -> list.setAt(1, null));
    }

    @Test
    void givenANonEmptyList_whenSetAtZeroIndex_thenAddAtFront() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("Second");

        // When:
        list.setAt(0, "First");
        int size = list.size();
        String data = list.getAt(0);

        // Then:
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("First", data);
    }

    @Test
    void givenANonEmptyList_whenSetAtSizeIndex_thenAddAtTail() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // When:
        list.setAt(1, "Second");
        int size = list.size();
        String data = list.getAt(1);

        // Then:
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Second", data);
    }

    @Test
    void givenANonEmptyList_whenSetAtBetweenTwoNodes_thenSizeIsThree() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");
        list.addAtTail("Third");

        // When:
        list.setAt(1, "Second");
        int size = list.size();
        String data = list.getAt(1);

        // Then:
        Assertions.assertEquals(3, size);
        Assertions.assertEquals("Second", data);
    }

    @Test
    void givenAList_whenGetAtIndexLessThanZero_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        //Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.getAt(-1));
    }

    @Test
    void givenAList_whenGetAtIndexGreaterThanSize_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        //Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.getAt(2));
    }

    @Test
    void givenAList_whenRemoveIndexLessThanZero_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.remove(-1));
    }

    @Test
    void givenAList_whenRemoveIndexGreaterThanSize_thenExceptionThrown() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // Then:
        Assertions.assertThrows(WrongIndexException.class, () -> list.remove(2));
    }

    @Test
    void givenANonEmptyList_whenRemoveFirst_thenSizeDecrease() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");
        list.addAtTail("Second");

        // When:
        int beforeRemoveSize = list.size();
        list.remove(0);
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(2, beforeRemoveSize);
        Assertions.assertEquals(1, afterRemoveSize);
    }

    @Test
    void givenANonEmptyList_whenRemoveLast_thenSizeDecrease() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");
        list.addAtTail("Second");

        // When:
        int beforeRemoveSize = list.size();
        list.remove(1);
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(2, beforeRemoveSize);
        Assertions.assertEquals(1, afterRemoveSize);
        Assertions.assertEquals("First", list.getAt(0));
    }

    @Test
    void givenANonEmptyList_whenRemoveMiddle_thenSizeDecrease() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");
        list.addAtTail("Second");
        list.addAtTail("Third");

        // When:
        int beforeRemoveSize = list.size();
        list.remove(1);
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(3, beforeRemoveSize);
        Assertions.assertEquals(2, afterRemoveSize);
        Assertions.assertEquals("First", list.getAt(0));
        Assertions.assertEquals("Third", list.getAt(1));
    }

    @Test
    void givenAListWithOneNode_whenRemoveNode_thenSizeIsZero() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("First");

        // When:
        int beforeRemoveSize = list.size();
        list.remove(0);
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(1, beforeRemoveSize);
        Assertions.assertEquals(0, afterRemoveSize);
    }

    @Test
    void givenAnEmptyList_whenRemoveAll_thenSizeIsZero() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        list.removeAll();
        int actualSize = list.size();

        // Then:
        Assertions.assertEquals(0, actualSize);
    }

    @Test
    void givenANonEmptyList_whenRemoveAll_thenSizeIsZero() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("Third");
        list.addAtFront("Second");
        list.addAtFront("First");

        // When:
        int beforeRemoveSize = list.size();
        list.removeAll();
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(3, beforeRemoveSize);
        Assertions.assertEquals(0, afterRemoveSize);
    }

    @Test
    void givenAList_whenRemoveAllWithBlueValue_thenAllBlueRemoved() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("red");
        list.addAtTail("blue");
        list.addAtFront("green");
        list.addAtFront("blue");
        list.addAtFront("pink");
        list.addAtFront("blue");

        // When:
        int beforeRemoveSize = list.size();
        list.removeAllWithValue("blue");
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(6, beforeRemoveSize);
        Assertions.assertEquals(3, afterRemoveSize);
    }

    @Test
    void givenAListWithNoBlueValues_whenRemoveAllWithValueBlue_thenSizeDoesntChange() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("red");
        list.addAtTail("orange");
        list.addAtFront("green");
        list.addAtFront("yellow");
        list.addAtFront("pink");
        list.addAtFront("red");

        // When:
        int beforeRemoveSize = list.size();
        list.removeAllWithValue("blue");
        int afterRemoveSize = list.size();

        // Then:
        Assertions.assertEquals(beforeRemoveSize, afterRemoveSize);
    }

    @Test
    void givenAnEmptyList_whenIterator_thenNextReturnsNull() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        Iterator<String> listIterator = list.iterator();
        String data = listIterator.next();

        // Then:
        Assertions.assertNull(data);
    }

    @Test
    void givenANonEmptyList_whenIterator_thenNextReturnsTheElements() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("red");
        list.addAtTail("orange");
        list.addAtFront("blue");

        // When:
        Iterator<String> listIterator = list.iterator();

        // Then:
        Assertions.assertTrue(listIterator.hasNext());
        Assertions.assertEquals("blue", listIterator.next());
        Assertions.assertTrue(listIterator.hasNext());
        Assertions.assertEquals("red", listIterator.next());
        Assertions.assertTrue(listIterator.hasNext());
        Assertions.assertEquals("orange", listIterator.next());
        Assertions.assertFalse(listIterator.hasNext());
        Assertions.assertNull(listIterator.next());
    }

    @Test
    void givenAnEmptyList_whenPrintList_thenPrintsEmptyList() {
        // Given:
        List<String> list = new LinkedList<>();

        // When:
        String result = list.toString();

        // Then:
        Assertions.assertEquals("Empty List", result);
    }

    @Test
    void givenANonEmptyList_whenPrintList_thenPrintsList() {
        // Given:
        List<String> list = new LinkedList<>();
        list.addAtFront("red");
        list.addAtFront("orange");
        list.addAtFront("blue");

        // When:
        String result = list.toString();

        // Then:
        Assertions.assertEquals("[ blue - orange - red ]", result);
    }
}