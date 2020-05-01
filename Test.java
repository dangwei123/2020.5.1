import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                map.put(sc.nextInt(),i);
            }
            int key=sc.nextInt();
            int index=map.getOrDefault(key,-1);
            System.out.println(index);
        }
    }
}

将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            List<Integer> row=triangle.get(i);
            for(int j=0;j<row.size();j++){
                dp[j]=row.get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}

在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int[][] dp=new int[m+1][n+1];
        int res=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}

