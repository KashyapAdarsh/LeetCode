public class Solution {
    public boolean isPalindrome(int x) {
    if( x < 0)
        return false;
    int y = 0;
    int temp =x;

    while(temp != 0){
        y = temp % 10 + y * 10;
        temp /= 10;
    }
    if (y == x){
        return true;
    }
    else{
        return false;
    }
 }
}