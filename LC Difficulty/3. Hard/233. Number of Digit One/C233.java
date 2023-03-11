class C233 {
    public int countDigitOne(int n) {
        int count = 0;
        for (int digitPlace = 1; digitPlace <= n; digitPlace *= 10) {
            int higherDigits = n / digitPlace;
            int lowerDigits = n % digitPlace;
            if (higherDigits > 0) {
                count += higherDigits * digitPlace;
            }
            if (lowerDigits >= digitPlace) {
                count += Math.min(lowerDigits - digitPlace + 1, digitPlace);
            }
        }
        return count;
    }
}