class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> bagMap = new HashMap<>();

        List<Integer> resList = new ArrayList<>();

        for (Integer n : nums) {
            bagMap.put(n, bagMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mapElement : bagMap.entrySet()) {
            if (mapElement.getValue() >= k) {
                resList.add(mapElement.getKey());
            }
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
