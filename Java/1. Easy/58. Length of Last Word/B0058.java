class B0058 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length == 0) {
                    continue;
                } else {
                    break;
                }
            }
            length++;
        }
        return length;
    }

}