class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
        
        Integer[] arr1Wrapper = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Wrapper, Collections.reverseOrder());
        // Sort arr2 in natural order
        Arrays.sort(arr2);

        boolean result = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1Wrapper[i] + arr2[i] < k) {
                return false;
            }
        }
        return true;
    }
}
