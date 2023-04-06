import java.util.ArrayList;
import java.util.List;

class B282 {
    // List to store the valid expressions
    List<String> res;  
    // Character array to store the expressions (valid or invalid)
    char[] expArr;     
    // Character array to store the digits of our input number
    char[] charArr; 
    // length of the input number 
    int len;    
    // target currNum for the expressions  
    long target;     

    public List<String> addOperators(String num, int target) {
        // we use an ArrayList because we don't know the size of the res list
        res = new ArrayList<>();     
        // if the target is the minimum possible integer, return the empty res list
        // this is to avoid overflow when we convert the target to a long currNum
        if (target == Integer.MIN_VALUE) {   
            return res;
        }
        // convert string to char array
        charArr = num.toCharArray(); 
        len = charArr.length;  
        // initialize the expArr array with size 2 * len
        // this is because each digit can be followed by either an operator or a digit
        // for example, if the input number is 123, we can generate expressions like 1+2+3, 1+2*3, 1*2+3, 1*2*3
        expArr = new char[len + len];  
        // By storing the target currNum in a class-level variable targetValue, 
        // the helper method can access it without having to pass it as an argument to each recursive call.
        this.target = target;          

        // initialize expression pointer to iterate over the expArr array 
        int expPtr = 0;          
        // initialize the currNum 
        long currNum = 0;  

        for (int i = 0; i < len; i++) {
            // Convert the current char to int current Number
            // for example, if the input number is 105, we will generate expressions starting from 1, 10, and 105
            // this is to avoid cases like 1 + 05 = 6
            // This line will generate every possible combination of the input number
            currNum = currNum * 10 + charArr[i] - '0';  
            // add the current character to the expArr array
            expArr[expPtr++] = charArr[i];  

            helper(i + 1, expPtr, 0, currNum);

            if (currNum == 0) {                                    
                break;
            }
        }
        return res;
    }

    private void helper(int charPtr, int expPtr, long curr, long prev) {
        // Set the limit of recursion to the length of the input number
        if (charPtr == len) {    
            // if the current sum is equal to the target
            if (curr + prev == target) {   
                // add the expression to the res list
                res.add(new String(expArr, 0, expPtr));  
            }
            // exit the recursion
            return;
        }

        // initialize the current number to 0
        long currNum = 0; 
        // initialize operator pointer that points to the operator in the expression array 
        int opPtr = expPtr++;  

        for (int i = charPtr; i < len; i++) {
            // Convert the current char to int current Number
            currNum = currNum * 10 + charArr[i] - '0';    
            // add the current character to the expression array
            expArr[expPtr++] = charArr[i];   

            // Place the '+' operator in the expression array
            expArr[opPtr] = '+';
            helper(i + 1, expPtr, curr + prev, currNum);

            // Place the '-' operator in the expression array
            expArr[opPtr] = '-';
            helper(i + 1, expPtr, curr + prev, -currNum);

            // Place the '*' operator in the expression array
            expArr[opPtr] = '*';
            helper(i + 1, expPtr, curr, prev * currNum);
            
            if (currNum == 0) {        
                break;
            }
        }
    }
}