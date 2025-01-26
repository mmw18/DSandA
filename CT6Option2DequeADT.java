import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CT6Option2DequeADT {
    // This is the internal deque structure to hold all the elements
    private Deque<Integer> dequeStorage;

    // This is the constructor to initialize the deque
    public CT6Option2DequeADT() {
        this.dequeStorage = new LinkedList<>();
    }

    // This is adding an element to the front of the deque
    public void insertToFront(int value) {
        dequeStorage.addFirst(value);
    }

    // This is adding an element to the bacl of the deque
    public void insertToRear(int value) {
        dequeStorage.addLast(value);
    }

    // This is removing and returning the element from the front of the deque
    public int removeFromFront() {
        if (isDequeEmpty()) {
            throw new NoSuchElementException("The deque is currently empty.");
        }
        return dequeStorage.removeFirst();
    }

    // This is removing and returning the element from the rear of the deque
    public int removeFromRear() {
        if (isDequeEmpty()) {
            throw new NoSuchElementException("The deque is currently empty.");
        }
        return dequeStorage.removeLast();
    }

    // This function will return true if the deque is empty, false otherwise
    public boolean isDequeEmpty() {
        return dequeStorage.isEmpty();
    }

    // This function will return a custom iterator to traverse the deque
    public CustomDequeIterator getIterator() {
        return new CustomDequeIterator();
    }

    // This is the iner class to implement a custom iterator
    private class CustomDequeIterator implements Iterator<Integer> {
        private Iterator<Integer> internalIterator = dequeStorage.iterator();

        @Override
        public boolean hasNext() {
            return internalIterator.hasNext();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Sorry, there are no more elements to traverse.");
            }
            return internalIterator.next();
        }
    }

    // This it the main method that's going to bring everything together for the program to work
    public static void main(String[] args) {
        CT6Option2DequeADT customDeque = new CT6Option2DequeADT();

        // A collection of numbers from my pet's birthdays
        int[] testNumbers = {03, 21, 20, 18, 07, 19, 93, 02, 14, 22};
        System.out.println("Now enqueuing the elements...");

        // This is adding the elements to the front and back
        for (int i = 0; i < testNumbers.length; i++) {
            if (i % 2 == 0) {
                customDeque.insertToFront(testNumbers[i]);
                System.out.println("Inserted " + testNumbers[i] + " to the front.");
            } else {
                customDeque.insertToRear(testNumbers[i]);
                System.out.println("Inserted " + testNumbers[i] + " to the back.");
            }
        }

        // This is to display the elements
        System.out.println("\nDeque elements now (using iterator):");
        CustomDequeIterator iterator = customDeque.getIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // This is showing the deque
        System.out.println("\n\nDequeuing the elements...");
        while (!customDeque.isDequeEmpty()) {
            System.out.println("Removed from front: " + customDeque.removeFromFront());
        }
    }
}
