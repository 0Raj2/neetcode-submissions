class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> bagMap = new TreeMap<>();

        int[] resArr = new int[k];
        int ind = k - 1;

        for (Integer n : nums) {
            bagMap.put(n, bagMap.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(bagMap.entrySet());
        entryList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        for (Map.Entry<Integer, Integer> mapElement : entryList) {
            if (ind < 0) {
                break;
            }
            resArr[ind] = mapElement.getKey();
            ind--;
        }

        return resArr;
    }
}
