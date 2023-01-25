public class B0006 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int step = 2 * (numRows - 1);
        for (int i = 0; i < s.length(); i += step) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int j = i;
            boolean flag = true;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                j += flag ? step - 2 * i : 2 * i;
                flag = !flag;
            }
        }
        for (int i = numRows - 1; i < s.length(); i += step) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
