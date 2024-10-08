class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        
        getCombinations(1, n, k, new ArrayList<>(), ans);
        return ans;
    }


    private void getCombinations(int i, int n, int k, List<Integer> curr, List<List<Integer>> ans){
        if(i > n){
            if(curr.size() == k){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        //choose
        if(curr.size() < k){
            curr.add(i);
            getCombinations(i + 1, n, k, curr, ans);
            curr.remove(curr.size() - 1);
        }

        // not choose
        getCombinations(i + 1, n, k, curr, ans);

    }
}
