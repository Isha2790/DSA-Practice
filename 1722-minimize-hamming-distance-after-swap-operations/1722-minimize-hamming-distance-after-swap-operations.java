class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] s : allowedSwaps) parent[find(parent, s[0])] = find(parent, s[1]);    
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            groups.computeIfAbsent(root, x -> new HashMap<>())
                .merge(source[i], 1, Integer::sum);
        }      
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            Map<Integer, Integer> count = groups.get(root);
            if (count.getOrDefault(target[i], 0) > 0) 
                count.put(target[i], count.get(target[i]) - 1);
            else 
                diff++;
        }
        return diff;
    }
    int find(int[] p, int x) { return p[x] == x ? x : (p[x] = find(p, p[x])); }
}