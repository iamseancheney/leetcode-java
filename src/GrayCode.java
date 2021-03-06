import java.util.*;

/*
 89	Gray Code	32.8%	Medium
 Problem:    Gray Code
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/gray-code/
 Notes:
 The gray code is a binary numeral system where two successive values differ in only one bit.
 Given a non-negative integer n representing the total number of bits in the code, print the 
 sequence of gray code. A gray code sequence must begin with 0.
 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.
 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 Solution: Refer to http://en.wikipedia.org/wiki/Gray_code.
 */

public class GrayCode {
	public List<Integer> grayCode(int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i =0; i<1<<n;++i){
			res.add((int)((i>>1)^i));
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode slt = new GrayCode();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Given a non-negative integer n representing the total number of bits");
		int n = sc.nextInt();
		List<Integer> res = slt.grayCode(n);
		System.out.println(res);
	}

}
