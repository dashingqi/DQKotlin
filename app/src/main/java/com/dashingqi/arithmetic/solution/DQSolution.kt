package com.dashingqi.arithmetic.solution

/**
 * @author zhangqi61
 * @since 2023/7/3
 */
class DQSolution {
    /**
     * 动态规划 查找最长递增子序列
     * @param nums IntArray 数组
     * @return Int 递增子序列的长度
     */
    fun method(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = intArrayOf(nums.size)
        dp[0] = 1
        var max = 0
        for (i in 1 until nums.size) {
            dp[i] = 1
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                }
            }
            max = max.coerceAtLeast(dp[i])
        }
        return max
    }

    /**
     * 搜索插入元素
     * @param nums IntArray
     * @param target Int
     * @return Int
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            }
        }
        return left
    }


    /**
     * 移除数组中元素
     * @param nums IntArray
     * @param target Int
     * @return Int 数组的长度
     */
    fun removeElement(nums: IntArray, target: Int): Int {
        var slow = 0
        var fast = 0
        while (fast < nums.size) {
            if (nums[fast] != target) {
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        return slow
    }

    /**
     * 移除数据中重复的元素
     * @param nums IntArray
     * @return Int
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var slow = 0
        var fast = 0
        while (fast < nums.size) {
            if (nums[fast] != nums[slow]) {
                slow++
                nums[slow] = nums[fast]
            }
            fast++
        }
        return slow + 1
    }

    /**
     * 两数之和l
     * @param nums IntArray
     * @param target Int
     * @return IntArray?
     */
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val maps = hashMapOf<Int, Int>()
        for (index in nums.indices) {
            val tempValue = nums[index]
            val value = target - tempValue
            if (maps.containsKey(value)) {
                return intArrayOf(maps[value] ?: 0, index)
            }
            maps[tempValue] = index
        }
        return null
    }


    /**
     * 是否是回文数
     * 121
     * 131
     * 343
     * @param x Int 回文数
     * return 计算倒序值 比较大小
     */
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var cur = 0
        var temp = x
        while (temp != 0) {
            val lastNumber = temp % 10
            temp /= 10
            cur = cur * 10 + lastNumber
        }
        return cur == x
    }

    /**
     * 最长公共前缀
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * @param strs Array<String>
     * @return String
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        var ans = strs[0]
        for (i in 1 until strs.size) {
            var j = 0
            while (j < ans.length && j < strs[i].length) {
                if (ans[j] != strs[i][j]) break
                j++
            }
            ans = ans.substring(0, j)
            if (ans == "") return ans
        }
        return ans
    }
}