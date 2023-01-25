public class B0029 {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        while (absDividend >= absDivisor) {
            int shift = 0;
            while (absDividend >= (absDivisor << shift)) {
                shift++;
            }
            result += 1 << (shift - 1);
            absDividend -= absDivisor << (shift - 1);
        }

        return isNegative ? -result : result;
    }
}
