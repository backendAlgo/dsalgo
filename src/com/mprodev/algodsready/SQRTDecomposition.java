package com.mprodev.algodsready;

public class SQRTDecomposition {
    private final int[] blocks;
    private final int blockSize;
    private final int[] nums;
    private final int n;

    public SQRTDecomposition(int[] nums) {
        blockSize = (int) Math.ceil(Math.sqrt(nums.length));
        int n = nums.length / blockSize + 1;
        blocks = new int[n];
        for (int i = 0; i < n; i++) {
            int blockSum = 0;
            for (int j = i * blockSize; j < nums.length && j < (i + 1) * blockSize; j++) {
                blockSum += nums[j];
            }
            blocks[i] = blockSum;
        }
        this.nums = nums;
        this.n = nums.length;
        // System.out.println(Arrays.toString(blocks));
    }

    public void update(int index, int newVal) {
        int oldVal = nums[index];
        int blockIndex = index / blockSize;
        blocks[blockIndex] += (newVal - oldVal);
        nums[index] = newVal;
    }

    public int sumRange(int left, int right) {
        int leftBlockIndex = left / blockSize;
        int rightBlockIndex = right / blockSize;
        int ans = 0;
        for (int i = leftBlockIndex + 1; i < rightBlockIndex; i++) {
            ans += blocks[i];
        }
        for (int i = left; i < (leftBlockIndex + 1) * blockSize && i < n; i++) {
            ans += nums[i];
        }
        for (int i = rightBlockIndex * blockSize; i <= right && i < n; i++) {
            ans += nums[i];
        }
        return ans;
    }
}

