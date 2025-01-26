public class Module6Discussion {
    public static void main(String[] args) {
        // This is the array with the sizes of the cinnamon rolls (kinda like diameter in inches)
        int[] rollSizes = {3, 3, 4, 2, 5, 4};

        System.out.println("Roll sizes before Sorting: " + java.util.Arrays.toString(rollSizes));
        
        // Sorting the cinnamon rolls using insertion sort
        insertionSort(rollSizes);

        System.out.println("Roll sizes after Sorting: " + java.util.Arrays.toString(rollSizes));
    }

    // This is the insertion sort method to sort cinnamon rolls, going off their size
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; // This is the current roll being sorted
            int j = i - 1;

            // Shifting larger rolls to the right, for space
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            // Placing the current roll in the correct position
            array[j + 1] = current;
        }
    }
}
