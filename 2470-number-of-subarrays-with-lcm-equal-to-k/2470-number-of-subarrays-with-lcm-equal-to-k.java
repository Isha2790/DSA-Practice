class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int lcm = nums[i];
            for (int j = i; j < nums.length; j++) {
                lcm = lcm(lcm, nums[j]);
                if (lcm == k) count++;
                if (lcm > k) break;
            }
        }
        return count;
    }
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}