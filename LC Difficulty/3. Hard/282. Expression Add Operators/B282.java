import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;
    char[] operators;
    char[] inputNumbers;
    int inputLength;
    long targetValue;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (target == Integer.MIN_VALUE) {
            return result;
        }
        inputNumbers = num.toCharArray();
        inputLength = inputNumbers.length;
        operators = new char[inputLength + inputLength];
        this.targetValue = target;

        int operatorsIndex = 0;
        long currentValue = 0;
        for (int i = 0; i < inputLength; i++) {
            currentValue = currentValue * 10 + inputNumbers[i] - '0';
            operators[operatorsIndex++] = inputNumbers[i];
            helper(i + 1, operatorsIndex, 0, currentValue);
            if (currentValue == 0) {
                break;
            }
        }
        return result;
    }

    private void helper(int inputIndex, int operatorsIndex, long currentSum, long previousValue) {
        if (inputIndex == inputLength) {
            if (currentSum + previousValue == targetValue) {
                result.add(new String(operators, 0, operatorsIndex));
            }
            return;
        }
        long value = 0;
        int operatorPosition = operatorsIndex++;
        for (int i = inputIndex; i < inputLength; i++) {
            value = value * 10 + inputNumbers[i] - '0';
            operators[operatorsIndex++] = inputNumbers[i];

            operators[operatorPosition] = '+';
            helper(i + 1, operatorsIndex, currentSum + previousValue, value);

            operators[operatorPosition] = '-';
            helper(i + 1, operatorsIndex, currentSum + previousValue, -value);

            operators[operatorPosition] = '*';
            helper(i + 1, operatorsIndex, currentSum, previousValue * value);
            if (value == 0) {
                break;
            }
        }
    }
}