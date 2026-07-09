class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){  // Negative numbers are not palindrome
            return false;
        }
        int reverse = 0;
        int xcopy = x; // store original number

          // build reverse number digit by digit

        while (x > 0){
            reverse = (reverse * 10) + (x % 10);  // get last digit and append digit
            x = x / 10;  //remove last digit
        }
        // compare reversed number with original
        return reverse == xcopy;
    }
}