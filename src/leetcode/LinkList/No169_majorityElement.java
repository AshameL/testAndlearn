package leetcode.LinkList;

/**
 * 求众数
 */
public class No169_majorityElement {
    /*
    摩尔投票法？
     */
    public static int majorityElement(int[] nums) {
        int count = 1, maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i];
                    count = 1;
                }
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        //int[] arr = {2,2,1,1,1,2,2};
        int[] arr = {3,2,3};

        int i = majorityElement(arr);
        System.out.println(i);
    }
}
