package com.dashingqi.arithmetic.solution

/**
 * @author zhangqi61
 * @since 2023/7/3
 */
class DQSolution {

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
        var num = x
        while (num != 0) {
            cur = cur * 10 + num % 10
            num /= 10
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