import java.util.Arrays;

public class Solution16400 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > max) {
                max = nums[i + 1] - nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(new Solution16400().maximumGap(nums));
    }
}
