class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> up = new ArrayList<>();
        for (int num : nums) {
            up.add(num);
        }
        List<Integer> p = new ArrayList<>();
        return permutationsList(p, up);
    }

    public List<List<Integer>> permutationsList(List<Integer> p, List<Integer> up) {
        if (up.isEmpty()) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(p));
            return list;
        }
        int ch = up.get(0);

        // local to this call
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= p.size(); i++) {
            List<Integer> nextP = new ArrayList<>(p.subList(0, i));
            nextP.add(ch);
            nextP.addAll(p.subList(i, p.size()));
            ans.addAll(permutationsList(nextP, up.subList(1, up.size())));
        }
        return ans;
    }
}