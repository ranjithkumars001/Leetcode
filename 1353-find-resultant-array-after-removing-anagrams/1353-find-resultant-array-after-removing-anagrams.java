import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (!stack.isEmpty() && isAnagram(stack.peek(), word)) {
               
                continue;
            }
            stack.push(word);
        }

        return new ArrayList<>(stack);
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
