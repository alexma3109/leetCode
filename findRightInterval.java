package findRightInterval;
import java.util.*;
import findRightInterval.TreeNode;
import findRightInterval.Interval;
public class Solution {
	public static void main(String[] args){
		//Interval i
	}
    public static int[] findRightInterval(Interval[] intervals) {
    	if(intervals.length == 1){
    		int[] res = new int[]{-1};
        	return res;
        }
    	
    	return null;
    }
    public static int binarySearchTree(TreeNode root, Interval[] intervals, int pos){
    	if(root == null){
    		root = new TreeNode(intervals[pos].start, pos);
    		return ++pos;
    	}
    	if(intervals[pos].start < root.val){
    		pos = binarySearchTree(root.left, intervals, pos);
    	}
    	else{
    		pos = binarySearchTree(root.right, intervals, pos);
    	}
    	return pos;
    }
}
