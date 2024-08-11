class Solution {
    ArrayList<ArrayList<Integer>> findPerms(ArrayList<Integer> arr, int n) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (n == 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr.get(0));
            ans.add(temp);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr.get(i - 1) == arr.get(i))
                continue;

            int removedElement = arr.remove(i);
            ArrayList<ArrayList<Integer>> permsNext = findPerms(arr, n - 1);
            for (int j = 0; j < permsNext.size(); j++) {
                permsNext.get(j).add(0, removedElement);
                ans.add(permsNext.get(j));
            }
            arr.add(i, removedElement);
        }

        return ans;
    }
    ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        Collections.sort(arr);
        return findPerms(arr, n);
    }
};
