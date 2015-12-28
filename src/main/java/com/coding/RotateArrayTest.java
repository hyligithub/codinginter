package com.coding;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by lihuiyan on 2015/12/28.
 * original : 1,2,3,4,5,6,7
 * result : 5,6,7,1,2,3,4
 * <p/>
 * n = 7,step = 3
 * <p/>
 * 翻转数组
 */
public class RotateArrayTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotateByCopy(nums, 3);
//        rotateByBubble(nums, 3);
        rotateByReverse(nums,3);
        System.out.print(Arrays.toString(nums));
    }

    public static void rotateByCopy(int[] nums, int step) {
        if (step > nums.length)
            step = step % nums.length;
        int[] result = new int[nums.length];

        for (int i = 0; i < step; i++) {
            result[i] = nums[nums.length - step + i];
        }
        int j = 0;

        for (int i = step; i < nums.length; i++) {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void rotateByBubble(int[] nums, int step) {
        if (nums == null || step < 0) {
            throw new IllegalArgumentException("参数错误");
        }
        for (int i = 0; i < step; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }
    }

    public static void rotateByReverse(int[] nums, int step) {
        step = step % nums.length;

        if (step < 0 || nums == null) {
            throw new IllegalArgumentException("参数不正确");
        }

        //
        int firstLength = nums.length - step;
        reverse(nums, 0, firstLength - 1);
        reverse(nums, firstLength, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        if (nums == null || nums.length == 1)
            return;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }

    }
}
