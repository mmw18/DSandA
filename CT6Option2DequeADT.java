/**
 * Module 6 Critical Thinking
 * Megan M. Wright
 * Colorado State Univeristy Global
 * CSC400-1: Data Structures and Algorithms
 * Professor Pensado, Herbert
 * January 26th, 2024
 */

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
    public void insertToback(int value) {
        dequeStorage.addLast(value);
    }

    // This is removing and returning the element from the front of the deque
    public int removeFromFront() {
        if (isDequeEmpty()) {
            throw new NoSuchElementException("The deque is currently empty.");
        }
        return dequeStorage.removeFirst();
    }

    // This is removing and returning the element from the back of the deque
    public int removeFromBack() {
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

    // This it the main method that's going to bring everything together for the
    // program to work
    public static void main(String[] args) {
        CT6Option2DequeADT customDeque = new CT6Option2DequeADT();

        // A collection of numbers from my pet's birthdays
        int[] testNumbers = { 03, 21, 20, 18, 07, 19, 93, 02, 14, 22 };
        System.out.println("Now enqueuing the elements...");

        // This is adding the elements to the front and back
        for (int i = 0; i < testNumbers.length; i++) {
            if (i % 2 == 0) {
                customDeque.insertToFront(testNumbers[i]);
                System.out.println("Inserted " + testNumbers[i] + " to the front.");
            } else {
                customDeque.insertToback(testNumbers[i]);
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

/*
 * PSEUDOCODE
 * 
 * START
 * CustomDeque Class: This will be used to hold elements (in this case integers)
 * and allow operations at both the front and back of the deque. It will also 
 * allow traversing through elements using a custom iterator.
 * Use a LinkedList for the internal storage since it efficiently handles 
 * additions and removals at both ends.
 * 
 * Methods needed:
 * - Adding an element to the front: This will take an integer and place it at 
 * the front of the deque.
 * - Adding an element to the back: This will take an integer and place it at 
 * the back of the deque.
 * - Removing an element from the front: This will remove and return the integer 
 * at the front of the deque. If the deque is empty, throw an error.
 * - Removing an element from the back: This will remove and return the integer 
 * at the back of the deque. If the deque is empty, throw an error.
 * - Checking if the deque is empty: This will return true if the deque has no 
 * elements, false otherwise.
 * - Providing an iterator to traverse the deque: The iterator will allow 
 * traversing all elements in the deque from front to back.
 * 
 * CustomDequeIterator Class:
 * - This will serve as an inner class within CustomDeque.
 * - The iterator will have methods to:
 *   - Check if there are more elements to traverse (hasNext).
 *   - Return the next element in the deque and move to the next position (next).
 *   - Throw an error if next is called when no elements remain.
 * 
 * Main Method/Program:
 * - Create an instance of the CustomDeque.
 * - Add 10 integers (switching between the front and back).
 * - Print out the elements in the deque using the custom iterator.
 * - Remove all elements from the front, printing each element as it’s removed.
 * - Verify that the deque is empty after all elements are removed.
 * END
 */
