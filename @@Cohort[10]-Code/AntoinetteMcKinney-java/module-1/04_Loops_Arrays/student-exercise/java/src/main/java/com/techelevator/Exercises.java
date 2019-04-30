package com.techelevator;

public class Exercises {
	
	private int[][] makePie1;

	/*
	 1. Given an array of ints, return true if 6 appears as either the first or last element in the array. 
	 The array will be length 1 or more.
	 firstLast6([1, 2, 6]) → true
	 firstLast6([6, 1, 2, 3]) → true
	 firstLast6([13, 6, 1, 2, 3]) → false
	 */
	public boolean firstLast6(int[] nums) { //given an array of ints
		if(nums.length >=1) {//the array will be length 1 or more
			if ((nums[0] == 6)|| (nums[nums.length - 1] == 6)) { //if 6 appears as either first or last element in the array
				return true;// 6 is found at positon 0 or last position of the array
			}
		}
		return false;//array does not meet the required conditon
	}

	
	/*
	 2. Given an array of ints, return true if the array is length 1 or more, and the first element and
	 the last element are equal.
	 sameFirstLast([1, 2, 3]) → false
	 sameFirstLast([1, 2, 3, 1]) → true
	 sameFirstLast([1, 2, 1]) → true
	 */
	public boolean sameFirstLast(int[] nums) {// given an array of ints
		if(nums.length >= 1 && (nums[0]== nums[nums.length -1])) {//The array lenth is 1 or more and the first element and last element are equal
			return true; // Return true
		}	
		return false;
	}

	/*
	 3. Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	 makePi() → [3, 1, 4]
	 */
	public int[] makePi() {
		int[] makePi1 = {3, 1, 4}; //Initalizing array to hold 3 values
				
		return makePi1; //return new array 
	}

	/*
	 4. Given 2 arrays of ints, a and b, return true if they have the same first element or they have 
	 the same last element. Both arrays will be length 1 or more.
	 commonEnd([1, 2, 3], [7, 3]) → true
	 commonEnd([1, 2, 3], [7, 3, 2]) → false
	 commonEnd([1, 2, 3], [1, 3]) → true
	 */
	public boolean commonEnd(int[] a, int[] b) {// 2 arrays of ints
		if ((a[0] == b[0]) || (a[a.length -1] == b[b.length - 1])) {
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

	public int sum3(int[] nums) {// array of ints
		int sum3Total = 0; //initialzed the variable sum with the value zero
		for (int i = 0; i < nums.length; i++) {// Setting the variable for the for loop to zero bec array starting position is zero. The ittirator was chosen because we know the lenght of the array but if the ittirator changes it can. 
			sum3Total = sum3Total + nums[i];// adding the value and array positions.  
		}
			return sum3Total;// return sum
				
	}

	/*
	 6. Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} 
	 yields {2, 3, 1}.
	 rotateLeft3([1, 2, 3]) → [2, 3, 1]
	 rotateLeft3([5, 11, 9]) → [11, 9, 5]
	 rotateLeft3([7, 0, 0]) → [0, 0, 7]
	 */
	public int[] rotateLeft3(int[] nums) {
		int temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i-1] = nums[i];
		}
		nums[nums.length -1 ] = temp;
		return nums;
		
	}

	/*
	 7. Given an array of ints length 3, return a new array with the elements in reverse order, so 
	 {1, 2, 3} becomes {3, 2, 1}.
	 reverse3([1, 2, 3]) → [3, 2, 1]
	 reverse3([5, 11, 9]) → [9, 11, 5]
	 reverse3([7, 0, 0]) → [0, 0, 7]
	 */
	public int[] reverse3(int[] nums) { //array of ints
		int[] nums2 = new int[3];
		
		int backward = nums.length-1;// index of last element
		
		for (int i = 0; i < nums.length; i++) {
			nums2[backward] = nums[i];
					backward--; // move the backward to previous element
		}

		return nums2;
	}
	
	/*
	 int [] nums2 = new int[nums.length];
	 int j = nums.length - 1 //index of last element
	 
	 for (int i =0; i < nums.length; i++) {
	 	nums2[j] = nums [i];
	 	j--; // move the backward to previous element
	 	;
	 	return nums2;
	 */

	/*
	 8. Given an array of ints length 3, figure out which is larger between the first and last elements 
	 in the array, and set all the other elements to be that value. Return the changed array.
	 maxEnd3([1, 2, 3]) → [3, 3, 3]
	 maxEnd3([11, 5, 9]) → [11, 11, 11]
	 maxEnd3([2, 11, 3]) → [3, 3, 3]
	 */
	public int[] maxEnd3(int[] nums) {
		int[] largest= new int[3];//  Initialized array to hold 3 datatypes
		
		int largeVal = 0;
		int first = nums[0];
		int last = nums[nums.length -1];
		
		//Check for the largest value between first and last.	
		
		if (first >= last) {
			largeVal = first;
		}else {
			largeVal = last;
		}
		
		for (int i = 0; i < largest.length; i++) {
			largest[i]=largeVal;
		}
		return largest;
	}

		 	
	
		
	/*
	 9. Given an array of ints, return the sum of the first 2 elements in the array. If the array length
	  is less than 2, just sum up the elements that exist, returning 0 if the array is length 0.
	 sum2([1, 2, 3]) → 3
	 sum2([1, 1]) → 2
	 sum2([1, 1, 1, 1]) → 2
	 */
	public int sum2(int[] nums) {//array of ints
		
		//Create a Variable to hold the sum
		int sum = 0;
		
		if(nums.length == 0) {//if the arry length is less than 2
			return sum; 
		} else if(nums.length < 2 && nums.length > 0) {//if the arry length is less than 2
			//Create for..loop to interate through the array 
			for(int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			return sum; 
		} else {
			return sum;
		}
			
	}
	
	/*
	 10. Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle 
	 elements.
	 middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
	 middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
	 middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
	 */
	public int[] middleWay(int[] a, int[] b) {
		int[] middle = {a[1], b[1]};
		return middle;
	
	}

	/*
	 11. Return the number of even ints in the given array. Note: the % "mod" operator computes the 
	 remainder, e.g. 5 % 2 is 1.
	 countEvens([2, 1, 2, 3, 4]) → 3
	 countEvens([2, 2, 0]) → 3
	 countEvens([1, 3, 5]) → 0
	 */
	public int countEvens(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0){
				count++; //count = count + 1 or count+1
				}
			}
		return count;
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
			int sumnum =0;
			  for (int i = 0;i <nums.length ;i++)
			  {
			  if (nums[i] != 13)
			  sumnum+=nums[i];
			  else if (nums[i] == 13 && i < nums.length -1 ) {
			  nums[i]=0;
			  nums[i+1] =0; }
			  }
			  return sumnum;
			
	}

	/*
	 13. Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
	 has22([1, 2, 2]) → true
	 has22([1, 2, 1, 2]) → false
	 has22([2, 1, 2]) → false
	 */
	public boolean has22(int[] nums) {
		for (int i = 0; i < nums.length -1; i++)
			if (nums [i] == 2 && nums [i +1] == 2) {
				return true;
			}
		return false;
	}
	
	/*
	 14. Given an array of ints, return true if the array contains no 1's and no 3's.
	 lucky13([0, 2, 4]) → true
	 lucky13([1, 2, 3]) → false
	 lucky13([1, 2, 4]) → false
	 */
	public boolean lucky13(int[] nums) {//array if ints
		int onesOrThrees = 0;// Creating a variable and assigning it to zero. So it can count ones and threes.
		
		for (int i = 0; i < nums.length; i++) {//created a for loop to search the array for ones or threes.
			if(nums[i] == 1 ||nums[i] == 3 ) {// wanted to compare if its ones or threes
				onesOrThrees =+1;//if you find a one or three in positon zero one is added to the counter
			
			}
					
		}
		
		if (onesOrThrees > 0) {//if the counter is greater than zero return false
			return false;
		}else {
			return true;
		}
		
		
		} 
	
		
		

	/*
	 15. Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
	 sum28([2, 3, 2, 2, 4, 2]) → true
	 sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 sum28([1, 2, 3, 4]) → false
	 */
	public boolean sum28(int[] nums) {
		boolean result =false;
		int summb = 0;
		  for (int i = 0; i <nums.length;i++)
		  {
		  if (nums[i] == 2) summb+=2;
		  }
		  if (summb == 8) result = true;
		  
		  return result;
		}


}
