package week6.challenges;
/*Challenge 4 - Stocks
Best Time to Buy and Sell Stocks III Say you have an array for which the ith element is the price of a given stock on
day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2] Output : 2

Explanation : Day 1 : Buy Day 2 : Sell Day 3 : Buy Day 4 : Sell*/
public class Challenges4 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        boolean[][] dp = new boolean[A.length() + 1][B.length() + 1];
        dp[A.length()][B.length()] = true;

        for (int i = A.length(); i >= 0; i--){
            for (int j = B.length() - 1; j >= 0; j--){
                boolean first_match = (i < A.length() &&
                        (B.charAt(j) == A.charAt(i) ||
                                B.charAt(j) == '.'));
                if (j + 1 < B.length() && B.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0]?1:0;
    }
}
