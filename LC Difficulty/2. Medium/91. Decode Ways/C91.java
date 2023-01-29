class C91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int p1 = 1;
        int p2 = 1;
        int ways = 1;
        for (int i = 1; i < s.length(); i++) {
            final char pc = s.charAt(i - 1);
            final char cc = s.charAt(i);

            if (cc == '0') {
                ways = 0;
            }

            if (pc == '1' || (pc == '2' && cc <= '6')) {
                ways += p2;
            }

            p2 = p1;
            p1 = ways;
        }
        return p1;
    }
}