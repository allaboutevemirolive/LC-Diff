class C273 {
    static final int THOUSAND = 1000, MILLION = 1_000_000, BILLION = 1_000_000_000;

    static final String[] L0 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    static final String[] L1 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static final String[] L2 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return nt(num);
    }
    private String nt(int num) {
        if (num >= BILLION) return concat(nt(num / BILLION) + " Billion", nt(num % BILLION));
        if (num >= MILLION) return concat(nt(num / MILLION) + " Million", nt(num % MILLION));
        if (num >= THOUSAND) return concat(nt(num / THOUSAND) + " Thousand", nt(num % THOUSAND));
        String res = num < 100 ? "" : L0[num / 100] + " Hundred";
        num %= 100;
        return num >= 10 && num <= 19 ? concat(res, L1[num % 10]) : concat(res, concat(L2[num / 10], L0[num % 10]));
    }

    private String concat(String s1, String s2) {
        return s1 == "" ? s2 : s2 == "" ? s1 : s1 + " " + s2;
    }
}