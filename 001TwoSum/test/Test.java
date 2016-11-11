import p001.Solution;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = new int[]{2,7,1,34};
        int [] result = solution.twoSum(nums,9);
        for (int i :
                result) {
            System.out.println(i);
        }
    }
}
