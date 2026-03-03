class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            if (rev > 214748364 || rev < -214748364) return 0;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }
}