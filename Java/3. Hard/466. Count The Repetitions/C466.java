public class C466 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // eliminate all elements in s1 that are not belong to s2.
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int len1 = ch1.length, len2 = ch2.length;
        int i = 0, j = 0, k = 0, h = 0;
        while (k < n1) {
            if (ch1[i] == ch2[j]) { // check a match
                j++;
                if (j == len2) {
                    j = 0; // reset
                    h++;
                }
            }
            i++;
            if (i == len1) {
                i = 0;
                k++;
            }
        }
        return h / n2;
    }
}