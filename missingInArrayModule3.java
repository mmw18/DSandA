public class missingInArrayModule3 {
    public static int missing(int[] array) {
        int n = array.length;
        
        // First calculate the expected sum of numbers from 1 to n+1
        int totalSum = (n + 1) * (n + 2) / 2;
        
        // Now calculate the actual sum of numbers in the array
        int arraySum = 0;

        for(int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }

        return totalSum - arraySum;
    }
    public static void main(String[] args) {
        int[] array = {3, 6, 5, 1, 4};

        System.out.println("The number not icluded in the array is: " + missing(array));
    }
}
