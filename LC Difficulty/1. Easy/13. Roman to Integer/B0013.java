public class B0013 {
    
    public static int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                num += 1000;
            } else if (c == 'D') {
                num += 500;
            } else if (c == 'C') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    num -= 100;
                } else {
                    num += 100;
                }
            } else if (c == 'L') {
                num += 50;
            } else if (c == 'X') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    num -= 10;
                } else {
                    num += 10;
                }
            } else if (c == 'V') {
                num += 5;
            } else if (c == 'I') {
                if (i < s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    num -= 1;
                } else {
                    num += 1;
                }
            }
        }
        return num;
    }
}
