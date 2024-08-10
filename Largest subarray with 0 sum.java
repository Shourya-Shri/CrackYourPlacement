//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int maxLen(int arr[], int n) {
        // HashMap to store the cumulative sum and its corresponding index
        HashMap<Integer, Integer> hm = new HashMap<>();
        int cumulativeSum = 0; // To store the cumulative sum of elements
        int maxLength = 0; // To store the maximum length of the subarray with sum 0

        for (int i = 0; i < n; i++) {
            // Add the current element to the cumulative sum
            cumulativeSum += arr[i];

            // Check if the cumulative sum is zero
            if (cumulativeSum == 0) {
                // If yes, update maxLength to the current index + 1
                maxLength = i + 1;
            } else {
                // If the cumulative sum has been seen before
                if (hm.containsKey(cumulativeSum)) {
                    // Calculate the length of the subarray and update maxLength if it's the largest so far
                    maxLength = Math.max(maxLength, i - hm.get(cumulativeSum));
                } else {
                    // Store the index of the cumulative sum
                    hm.put(cumulativeSum, i);
                }
            }
        }

        return maxLength;
    }
}
