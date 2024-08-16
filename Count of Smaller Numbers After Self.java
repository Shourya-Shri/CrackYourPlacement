public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();

        // Traverse the array from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int idx = bisectLeft(sortedList, num);
            result.add(idx);
            sortedList.add(idx, num);
        }

        // Reverse the result to match the original order
        Collections.reverse(result);
        return result;
    }

    private int bisectLeft(List<Integer> container, int insertVal) {
        int l = 0;
        int r = container.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (container.get(mid) < insertVal) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
