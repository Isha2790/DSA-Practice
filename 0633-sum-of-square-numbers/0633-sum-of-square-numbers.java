class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        while (a <= b) {
            long sum = 1L * a * a + 1L * b * b;
            if (sum == c) return true;
            if (sum < c) a++;
            else b--;
        }
        return false;
    }
}