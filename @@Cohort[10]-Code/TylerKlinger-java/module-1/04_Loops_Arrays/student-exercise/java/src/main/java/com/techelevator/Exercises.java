package com.techelevator;

public class Exercises {
	
	/*
	 1. Given an array of ints, return true if 6 appears as either the first or last element in the array. 
	 The array will be length 1 or more.
	 firstLast6([1, 2, 6]) → true
	 firstLast6([6, 1, 2, 3]) → true
	 firstLast6([13, 6, 1, 2, 3]) → false
	 */
	/*public boolean firstLast6(int[] nums) {//nums is being declared as an int array, hence no comma separating the variable and datatype
		
		if (nums[0] == 6 || nums[nums.length-1] == 6) {
			
			return true;
		}
		return false;
	
	}*/
	
	public boolean firstLast6(int[] nums) {
		if (nums[0] == 6 || nums.length-1 == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 2. Given an array of ints, return true if the array is length 1 or more, and the first element and
	 the last element are equal.
	 sameFirstLast([1, 2, 3]) → false
	 sameFirstLast([1, 2, 3, 1]) → true
	 sameFirstLast([1, 2, 1]) → true
	 */
	/*public boolean sameFirstLast(int[] nums) {
		
		if (nums[0] == nums[nums.length-1]) { //what is being returned is contained within curly braces
		
			return true;
		}
		return false;
	}
	*/
	public boolean sameFirstLast(int[] nums) {
		if (nums[0] == nums.length-1) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 3. Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	 makePi() → [3, 1, 4]
	 */
	/*public int[] makePi() {
		
		return new int[] {3, 1, 4};
	}
	*/
	
	public int[] makePi() {
		return new int[] {3, 1, 4};
	}

	/*
	 4. Given 2 arrays of ints, a and b, return true if they have the same first element or they have 
	 the same last element. Both arrays will be length 1 or more.
	 commonEnd([1, 2, 3], [7, 3]) → true
	 commonEnd([1, 2, 3], [7, 3, 2]) → false
	 commonEnd([1, 2, 3], [1, 3]) → true
	 */
	public boolean commonEnd(int[] a, int[] b) {
		
		
		if ((a[0] == b[0]) || (a.length-1 == b.length-1)) {
			return true;
		}
		else {
			return false;
		}
	}

	/*
	 5. Given an array of ints length 3, return the sum of all the elements.
	 sum3([1, 2, 3]) → 6
	 sum3([5, 11, 2]) → 18
	 sum3([7, 0, 0]) → 7
	 */
	public int sum3(int[] nums) {
		return nums[0] + nums[1] + nums[2];
	}

	/*
	 6. Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} 
	 yields {2, 3, 1}.
	 rotateLeft3([1, 2, 3]) → [2, 3, 1]
	 rotateLeft3([5, 11, 9]) → [11, 9, 5]
	 rotateLeft3([7, 0, 0]) → [0, 0, 7]
	 */
	/*public int[] rotateLeft3(int[] nums) {
		int whateverYouWant = nums[0];
		for (int i = 0; i < nums.length-1; i++) {
			nums[i] = nums[i + 1];// this transfers the value of one index to the next until the index length is reached
		}
		nums[nums.length-1] = whateverYouWant;//this gives the value of the last index to the first since the for loop does not return to the first unless looped infinitely
		
		return nums;
	}
	*/
	
	public int[] rotateLeft3(int[] nums) {
		int whateverYouWant = nums[0];
		for (int i = 0; i < nums.length-1; i++) {
			nums[i] = nums[i + 1];
		}
		nums[nums.length-1] = whateverYouWant;
		return nums;
	}

	/*
	 7. Given an array of ints length 3, return a new array with the elements in reverse order, so 
	 {1, 2, 3} becomes {3, 2, 1}.
	 reverse3([1, 2, 3]) → [3, 2, 1]
	 reverse3([5, 11, 9]) → [9, 11, 5]
	 reverse3([7, 0, 0]) → [0, 0, 7]
	 */
	/*public int[] reverse3(int[] nums) {
		int holdValue; // created as placeholder for the value of the first index 
		int forward = 0;// created for the first value
		int backward = nums.length-1;//created for the last value
		for (int i = forward; i < nums.length /2; i++) {//loops the first half of the array
			holdValue = nums[i];//takes the value of the first index so it is not lost when the first is changed
			nums[i] = nums[backward];//changes the first value to be equal to the last
			nums[backward] = holdValue;//places the stored value within the last index
			backward--;//continues the loop in reverse to return the last half of the array
		}
		return nums;
	}
	*/
	public int[] reverse3(int[] nums) {
		int holdValue;
		int forward = 0;
		int backward = nums.length-1;
		for (int i = forward; i < nums.length /2; i++) {
			holdValue = nums[i];
			nums[i] = nums[backward];
			nums[backward] = holdValue;
			
			backward--;
		}
		return nums;
	}
	
	/*
	 8. Given an array of ints length 3, figure out which is larger between the first and last elements 
	 in the array, and set all the other elements to be that value. Return the changed array.
	 maxEnd3([1, 2, 3]) → [3, 3, 3]
	 maxEnd3([11, 5, 9]) → [11, 11, 11]
	 maxEnd3([2, 11, 3]) → [3, 3, 3]
	 */
	
	/*
	 * int largestval
	 * int firstVal = nums[0];
	 * int lastVal = nums[nums.length-1];
	 * 
	 * if (firstVal > lastVal){
	 * largestVal = firstVal;
	 * }
	 * else {
	 * largestVal = lastVal;
	 * }
	 * for (int i = 0; i < nums.length; i++) {
	 * nums[i] = largestVal;
	 * }
	 * return nums;
	 * 
	 *}
	 */
	
	public int[] maxEnd3(int[] nums) {
		if (nums[0] > nums[nums.length - 1]) {
			return new int[] { nums[0], nums[0], nums[0] };
		}
		
		return new int[] { nums[nums.length - 1], nums[nums.length - 1], nums[nums.length - 1]};
	}

	/*
	 9. Given an array of ints, return the sum of the first 2 elements in the array. If the array length
	  is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.
	 sum2([1, 2, 3]) → 3
	 sum2([1, 1]) → 2
	 sum2([1, 1, 1, 1]) → 2
	 */
	public int sum2(int[] nums) {
		
		int first = nums[0];
		int second = nums[1];
		int sum = 0;
		
		
		for (int i = 0; i < nums.length; i++) {
		
		sum = first + second;
		}
	return sum;
	
	}
	/*
	 10. Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle 
	 elements.
	 middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
	 middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
	 middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
	 */
	public int[] middleWay(int[] a, int[] b) {
		
						
	int[] array1;
	array1 = new int[2];
	
	for (int i = 0; i < a.length-1; i++) {
		a[1] = array1[0];
	}
		
	for (int i = 0; i < b.length-1; i++) { 
		b[1] = array1[1];
	}
	for (int i = 0; i < array1.length-1; i++) {
		
	}
	return array1;
	}

	/*
	 11. Return the number of even ints in the given array. Note: the % "mod" operator computes the 
	 remainder, e.g. 5 % 2 is 1.
	 countEvens([2, 1, 2, 3, 4]) → 3
	 countEvens([2, 2, 0]) → 3
	 countEvens([1, 3, 5]) → 0
	 */
	public int countEvens(int[] nums) {
		
		int even = 0;
		int odd = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) 
				return even;
		}
		return odd;
	}

	/*
	 12. Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 
	 13 is very unlucky, so it does not count and numbers that come immediately after a 13 also do 
	 not count.
	 sum13([1, 2, 2, 1]) → 6
	 sum13([1, 1]) → 2
	 sum13([1, 2, 2, 1, 13]) → 6
	 */
	public int sum13(int[] nums) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 13) {
				i++;
			}
			else {
				total = total + nums[i];
			}
		}
		
		return total;
	}

	/*
	 13. Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
	 has22([1, 2, 2]) → true
	 has22([1, 2, 1, 2]) → false
	 has22([2, 1, 2]) → false
	 */
	public boolean has22(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] == 2) && ((nums[i + 1] == 2) || (nums[i - 1] == 2))){
			return true;
			}
		}
		return false;
	}
	
	/*
	 14. Given an array of ints, return true if the array contains no 1's and no 3's.
	 lucky13([0, 2, 4]) → true
	 lucky13([1, 2, 3]) → false
	 lucky13([1, 2, 4]) → false
	 */
	public boolean lucky13(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] != 1) && (nums[i] != 3))
				return true;		
		}
		return false;
	}

	/*
	 15. Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
	 sum28([2, 3, 2, 2, 4, 2]) → true
	 sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 sum28([1, 2, 3, 4]) → false
	 */
	public boolean sum28(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2) {
				if (sum + i == 8)
				 {
					return true;
				}
			}
		}
		return false;
	}

}
