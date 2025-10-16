import java.util.*;
class Solution {
    public static int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();
        
       
        for (int num : nums) {
            int r = ((num % value) + value) % value; 
            count.put(r, count.getOrDefault(r, 0) + 1);
        }

        int i = 0;
        while (true) {
            int r = i % value;
            if (!count.containsKey(r) || count.get(r) == 0) {
                return i; 
            }
            count.put(r, count.get(r) - 1); 
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, -10, 7, 13, 6, 8};
        int value1 = 5;
        System.out.println(findSmallestInteger(nums1, value1)); 
        int[] nums2 = {1, -10, 7, 13, 6, 8};
        int value2 = 7;
        System.out.println(findSmallestInteger(nums2, value2));
    }
}
