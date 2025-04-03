import java.util.Arrays;

public class PracticeProblem {

    // Insertion Sort - returns number of swaps and comparisons
    public static int[] insertionSort(double[] arr) {
        int swaps = 0;
        int comparisons = 0;
        
        for (int i = 1; i < arr.length; i++) {
            double key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparisons++;
                swaps++;  // Consider each insertion step as a swap
            }
            arr[j + 1] = key;
            if (j >= 0) {
                comparisons++;  // Compare the key to arr[j] when exiting the loop
            }
        }
        return new int[] {swaps, comparisons};
    }

    // Selection Sort - returns number of swaps and comparisons
	public static int[] selectionSort(double[] arr) {
		int swaps = 0;
		int comparisons = 0;
	
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				comparisons++;
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
	
			// Only swap if the minimum element is not already in the correct position
			if (minIndex != i) {
				double temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				swaps++;  // Count only actual swaps
			}
		}
	
		return new int[] {swaps, comparisons};
	}
	

    // Bubble Sort - returns number of swaps and comparisons
    public static int[] bubbleSort(double[] arr) {
        int swaps = 0;
        int comparisons = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        return new int[] {swaps, comparisons};
    }

    // Least Swaps - determines which sort method had the fewest swaps
    public static String leastSwaps(double[] arr) {
        double[] arr1 = arr.clone();
        double[] arr2 = arr.clone();
        double[] arr3 = arr.clone();
        
        int[] insertionResult = insertionSort(arr1);
        int[] selectionResult = selectionSort(arr2);
        int[] bubbleResult = bubbleSort(arr3);

        int minSwaps = Math.min(insertionResult[0], Math.min(selectionResult[0], bubbleResult[0]));
        
        if (minSwaps == insertionResult[0]) {
            return "Insertion";
        } else if (minSwaps == selectionResult[0]) {
            return "Selection";
        } else {
            return "Bubble";
        }
    }

    // Least Iterations - determines which sort method had the least number of iterations
    public static String leastIterations(double[] arr) {
        double[] arr1 = arr.clone();
        double[] arr2 = arr.clone();
        double[] arr3 = arr.clone();
        
        int[] insertionResult = insertionSort(arr1);
        int[] selectionResult = selectionSort(arr2);
        int[] bubbleResult = bubbleSort(arr3);

        int minComparisons = Math.min(insertionResult[1], Math.min(selectionResult[1], bubbleResult[1]));
        
        if (minComparisons == insertionResult[1]) {
            return "Insertion";
        } else if (minComparisons == selectionResult[1]) {
            return "Selection";
        } else {
            return "Bubble";
        }
    }

}
