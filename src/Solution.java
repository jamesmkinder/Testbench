
public class Solution {


    public boolean isPalindromicPermutation(String s) {

        s = s.replaceAll(" ", "");
        s = s.toLowerCase();
        int bitVector = 0;

        for (char c : s.toCharArray()) {
            bitVector = toggle(c - 'a', bitVector);
        }

        return (bitVector & bitVector - 1) == 0;
    }

    public int toggle(int c, int bitVector) {
        int mask = 1 << c;
        return bitVector ^ mask;
    }
}
