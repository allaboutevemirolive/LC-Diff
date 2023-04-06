class D65 {

    public boolean isNumber(String s) {
        boolean flag = false;
        int n = s.length();
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                ++c1;
            } else if (c == '.') {
                ++c2;
            } else if (c == 'e' || c == 'E') {
                if (flag) {
                    return false;
                }
                if (c1 == 0 || c2 > 1) {
                    return false;
                }
                flag = true;
                c1 = 0;
                c2 = 0;
            } else {
                return false;
            }
        }
        if (c1 == 0 || c2 > 1) {
            return false;
        }
        if (flag && c2 != 0) {
            return false;
        }
        return true;
    }

}