class B7 {

    public int reverse(int number) {
        int reversed = 0; // variable to store the reversed integer
        while (number != 0) { // loop until all digits of `number` have been processed
            int lastDigit = number % 10; // get the last digit of `number`
            int potentialReversed = reversed * 10 + lastDigit; // calculate the potential reversed integer
            if ((potentialReversed - lastDigit) / 10 != reversed) { // check if there was overflow during the calculation
                return 0; // overflow, return 0
            }
            reversed = potentialReversed; // update the reversed integer
            number = number / 10; // remove the last digit from `number`
        }
        return reversed; // return the reversed integer
    }
}
