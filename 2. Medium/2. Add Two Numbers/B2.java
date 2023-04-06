public class B2 {

    public static T2 addTwoNumbers(T2 firstNumber, T2 secondNumber) {
        // Create a dummy node to store the result and a pointer to the current node
        T2 dummyNode = new T2(0);
        T2 currentNode = dummyNode;

        // Initialize a carry variable to 0
        int carry = 0;

        // Loop until both input lists are empty and there is no carry left
        while (firstNumber != null || secondNumber != null || carry > 0) {
            // Get the value of the current node in each list, or 0 if the list is null
            int firstValue = firstNumber != null ? firstNumber.val : 0;
            int secondValue = secondNumber != null ? secondNumber.val : 0;

            // Add the values and the carry, and calculate the new carry
            // Calculate the carry that would be added to the next digit during the next iteration.
            int sum = firstValue + secondValue + carry;
            carry = sum / 10;

            // Create a new node with the last digit of the sum and add it to the result
            currentNode.next = new T2(sum % 10);
            currentNode = currentNode.next;

            // Move to the next node in each list
            firstNumber = firstNumber != null ? firstNumber.next : null;
            secondNumber = secondNumber != null ? secondNumber.next : null;
        }

        // Return the result without the dummy node
        return dummyNode.next;
    }

}
