class B16 { 
    public int threeSumClosest(int[] numbers, int target) {
        int arrayLength = numbers.length;
        if (arrayLength < 44) {
            java.util.Arrays.sort(numbers);
        } else {
            byte[] frequencyArray = new byte[2001];
            for (int value : numbers) {
                frequencyArray[value + 1000]++;
            }
            for (int index = 0, currentIndex = 0; index < 2001; ++index) {
                int frequency = frequencyArray[index];
                while (frequency-- != 0) {
                    numbers[currentIndex++] = index - 1000;
                }
            }
        }

        int startIndex = 0;
        int endIndex = arrayLength - 1;

        int sumOfLastTwo = numbers[endIndex - 1] + numbers[endIndex];
        for (int minLow = target - sumOfLastTwo, end = endIndex - 2; startIndex < end && numbers[startIndex] <= minLow; ++startIndex) {}
        if (startIndex == endIndex - 2) {
            return sumOfLastTwo + numbers[endIndex - 2];
        }

        int sumOfFirstTwo = numbers[startIndex] + numbers[startIndex + 1];
        for (int maxHigh = target - sumOfFirstTwo, end = startIndex + 2; endIndex > end && numbers[endIndex] >= maxHigh; --endIndex) {}
        if (endIndex == startIndex + 2) {
            return sumOfFirstTwo + numbers[endIndex];
        }

        int minAbsolute = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int end = endIndex - 1; startIndex < end; ++startIndex) {
            int currentStartNumber = numbers[startIndex];
            for (int leftPointer = startIndex + 1, rightPointer = endIndex; leftPointer < rightPointer;) {
                int currentSum = currentStartNumber + numbers[leftPointer] + numbers[rightPointer];
                if (currentSum == target) {
                    return currentSum;
                }

                int absolute;
                if (currentSum > target) {
                    absolute = currentSum - target;
                    rightPointer--;
                } else {
                    absolute = target - currentSum;
                    leftPointer++;
                }
                if (absolute < minAbsolute) {
                    minAbsolute = absolute;
                    closestSum = currentSum;
                }
            }
        }
        return closestSum;
    }
}
