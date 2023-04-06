class C65 {

    //Method to check if a given string is a valid number
    public boolean isNumber(String s) {
        boolean flag = false; //flag variable to check if 'e' or 'E' has appeared before
        int n = s.length(); 
        int c1 = 0; //counter for number of digits
        int c2 = 0; //counter for number of '.'
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') { //checking for sign
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false; //if sign appears in middle of number, return false
                }
            } else if (c >= '0' && c <= '9') {
                ++c1; //increment digit counter
            } else if (c == '.') {
                ++c2; //increment '.' counter
            } else if (c == 'e' || c == 'E') {
                if (flag || c1 == 0 || c2 > 1) {
                    return false; //if 'e'/'E' has appeared before or there are no digits before or more than one '.', return false
                }
                flag = true;
                c1 = 0; //reset digit counter
                c2 = 0; //reset '.' counter
            } else {
                return false; //if any other character appears, return false
            }
        }
        if (c1 == 0 || c2 > 1) { //final check for number of digits and '.'
            return false;
        }
        if (flag && c2 != 0) { //final check for 'e'/'E' and '.'
            return false;
        }
        return true; //if all checks pass, return true
    }

}
