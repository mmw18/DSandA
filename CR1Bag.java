
/**
 * Module 1 Critical Thinking
 * Megan M. Wright
 * Colorado State Univeristy Global
 * CSC400-1: Data Structures and Algorithms
 * Professor Pensado, Herbert
 * December 15th, 2024
 */

import java.util.HashMap;

public class CR1Bag<T> {
    private HashMap<T, Integer> items;

    // This is the constructor to initialize the bag
    public CR1Bag() {
        items = new HashMap<>();
    }

    // This is to add an item to the bag, with item being the item
    public void add(T item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    // This is to remove a single occurance of an item from the bag, item = the item
    public void remove(T item) {
        if (items.containsKey(item)) {
            if (items.get(item) == 1) {
                items.remove(item);
            } else {
                items.put(item, items.get(item) - 1);
            }
        } else {
            System.out.println("Sorry, this item cannot be found in the bag at this time.");
        }
    }

    // This is to check if an item exists in the bag. Item is the item being checked
    // and returned is a T/F
    public boolean contains(T item) {
        return items.containsKey(item);
    }

    // This counts and returns how many of an item there are in the bag.
    public int count(T item) {
        return items.getOrDefault(item, 0);
    }

    // This simply prints out the entire contents of the bag
    public void printContents() {
        System.out.println("Bag contents: " + items);
    }

    // This is the main method that will show how the bag actually works when being
    // interacted with by the user
    public static void main(String[] args) {
        CR1Bag<String> bag = new CR1Bag<>();

        // Adding to the bag
        bag.add("Chocolate Chip Cookies");
        bag.add("Snickerdoodle Cookies");
        bag.add("Chocolate Chip Cookies"); // adding a duplicate for testing's sake
        bag.add("Peanut Butter Cookies");

        // Print what's in the bag
        System.out.println("Greetings! The initial contents of this bag are:");
        bag.printContents();

        // Test of the 'contains' mehtod
        System.out.println("\nTesting existence of a cookie(s):");
        System.out.println("Are there any Chocolate Chip Cookies?: " + bag.contains("Chocolate Chip Cookies"));
        System.out.println("Are there any Oatmeal Raisin Cookies?: " + bag.contains("Oatmeal Raisin Cookies"));

        // Test of the 'count' method
        System.out.println("\nTesting count of cookies:");
        System.out.println("Chocolate Chip Cookies in the bag: " + bag.count("Chocolate Chip Cookies"));
        System.out.println("Oatmeal Raisin Cookies in the bag: " + bag.count("Oatmeal Raisin Cookies"));

        // Removing an element
        System.out.println("\nRemoving one Chocolate Chip Cookie from the bag now");
        bag.remove("Chocolate Chip Cookies");
        System.out.println("Updated cookies in the bag:");
        bag.printContents();

        // Test of 'contains' and 'count' on cookie removed by previous method
        System.out.println("\nChecking if the remove of a single Chocolate Chip Cookie was successful:");
        System.out.println("Chocolate Chip Cookies in the bag: " + bag.count("Chocolate Chip Cookies"));
    }
}

/*
 * PSEUDOCODE
 * 
 * START
 * Bag Class: This will be holding all the items (in this case I chose cookies
 * of different flavors), and how many of each there are.
 * Use a HashMap since this would be best for cases of storing items as keys and
 * their occurances.
 * 
 * Methods needed:
 * - Adding an item to the bag: If the cookie flavor already exists in the bag
 * then add 1 to it's count. If it does not exist within the bag then add it
 * with a count of 1.
 * - Removing an item from the bag: If the cookie flavor IS in the bag drop it's
 * count by 1. If the count of the flavor hits 0, then completely remove this
 * cookie from the bag.
 * If the cookie entered doesn't exist in the bag when trying to be removed,
 * print a message to the user to let them know
 * - Checking if an item exists in the bag at all: Review bag items to see if
 * the cookie in question does exist or not. Provide this answer in a true/false
 * - Counting of a specific item: Check how many cookies of the flavor in
 * question do exist in the bag currently. If the flavor doesn't exist at all
 * the program should print 0.
 * - Printing the contents of the bag to the user: Show all cookie flavors in
 * the bag and how many of each there are
 * 
 * Main Method/Program:
 * - Initialize an empty bag to hold all the cookies
 * - Add cookies of differing flavors, with at least one duplicate
 * - Show everything that's in the bag since initial additions
 * - Testing methods to see if a flavor exists, how many of a flavor are in the
 * bag, and needing to remove from the bag.
 * END
 */