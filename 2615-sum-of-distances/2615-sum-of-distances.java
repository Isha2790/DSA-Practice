class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);

        long[] res = new long[n];
        for (List<Integer> idxs : map.values()) {
            int m = idxs.size();
            long[] prefix = new long[m + 1];
            for (int i = 0; i < m; i++)
                prefix[i + 1] = prefix[i] + idxs.get(i);

            for (int i = 0; i < m; i++) {
                int idx = idxs.get(i);
                long left = (long) i * idx - prefix[i];
                long right = (prefix[m] - prefix[i + 1]) - (long) (m - i - 1) * idx;
                res[idx] = left + right;
            }
        }
        return res;
    }
}