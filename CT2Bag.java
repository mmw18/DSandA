/**
 * Module 1 Critical Thinking
 * Megan M. Wright
 * Colorado State University Global
 * CSC400-1: Data Structures and Algorithms
 * Professor Pensado, Herbert
 * December 15th, 2024
 */

 import java.util.HashMap;

 public class CT2Bag<T> {
     private HashMap<T, Integer> items;
 
     // This is the constructor to initialize the bag
     public CT2Bag() {
         items = new HashMap<>();
     }
 
     // This is to add an item to the bag, with item being the item
     public void add(T item) {
         items.put(item, items.getOrDefault(item, 0) + 1);
     }
 
     // This is to remove a single occurrence of an item from the bag, item = the item
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
 
     // ******* Newly added for module 2: bagSize, addBagContents, and getDistinctBag
 
     // This method gives the size of the bag, including any duplicates
     public int bagSize() {
         int total = 0;
         for (int count : items.values()) {
             total += count;
         }
         return total;
     }
 
     // This combines the contents of another bag into the current bag
     public void addBagContents(CT2Bag<T> otherBag) {
         for (T item : otherBag.items.keySet()) {
             int newCount = otherBag.count(item) + this.count(item);
             this.items.put(item, newCount);
         }
     }
 
     // This returns a new bag with only the items from the current bag
     public CT2Bag<T> getDistinctBag() {
         CT2Bag<T> distinctBag = new CT2Bag<>();
         for (T item : this.items.keySet()) {
             distinctBag.add(item);
         }
         return distinctBag;
     }
 
     // This simply prints out the entire contents of the bag
     public void printContents() {
         System.out.println("Bag contents: " + items);
     }
 
     // This is the main method that will show how the bag actually works when being
     // interacted with by the user
     public static void main(String[] args) {
         // Creating two bags
         CT2Bag<String> bag1 = new CT2Bag<>();
         CT2Bag<String> bag2 = new CT2Bag<>();
 
         // Adding items to first bag
         bag1.add("Chocolate Chip Cookies");
         bag1.add("Snickerdoodle Cookies");
         bag1.add("Chocolate Chip Cookies"); // Duplicate
         bag1.add("Peanut Butter Cookies");
 
         // Adding items to second bag
         bag2.add("Oatmeal Raisin Cookies");
         bag2.add("Peanut Butter Cookies");
         bag2.add("Snickerdoodle Cookies");
 
         // Displaying the contents of both bags
         System.out.println("These are the contents of Bag 1:");
         bag1.printContents();
         System.out.println("\nThese are the contents of Bag 2:");
         bag2.printContents();
 
         // Testing the bagSize method
         System.out.println("\nNow testing the bagSize method:");
         System.out.println("This is the size of Bag 1: " + bag1.bagSize());
         System.out.println("This is the size of Bag 2: " + bag2.bagSize());
 
         // Combining the two bags
         System.out.println("\nNow merging Bag 2 into Bag 1...");
         bag1.addBagContents(bag2);
         System.out.println("These are the contents of combined Bag 1:");
         bag1.printContents();
 
         // Finally, testing the getDistinctBag method
         System.out.println("\nNow creating a bag with only the unique flavors...");
         CT2Bag<String> distinctBag = bag1.getDistinctBag();
         System.out.println("These are the contents of the unique Bag:");
         distinctBag.printContents();
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
 * ***New Methods for Module 2:  ***
 * - Calculating the total size of the bag (bagSize): Go through the all the
 * counts within a bag and then add those up. THe returned total should also include
 * duplicates.
 * - Merging the contents of two bags (addBagContents): Go through all items in the
 * second bag, and for every item found, add it's count to the count of that item in
 * the first bag. If it's not found in the first bag then count it originally.
 * - Creating a new bag with only distinct items (getDistinctBag): Create a brand new
 * bag that it empty and add every unique item from the current bag to the new bag,
 * with a count of one. THe new bag will be the return.
 * 
 * Main Method/Program:
 * - Initialize an empty bag to hold all the cookies
 * - Add cookies of differing flavors, with at least one duplicate
 * - Show everything that's in the bag since initial additions
 * - Testing methods to see if a flavor exists, how many of a flavor are in the
 * bag, and needing to remove from the bag, how many of each flavor are in the
 * second bag, combine the first bag into the second bag, and then create a new
 * bag which will only hold unique flavors from the conbined bag.
 * END
 */