package _Missing_Values._Missing_Values;

public class MissingValues {

	public static void main(String[] args) {
		int sum=0;
		for (int i=0; i <=100; i++) {
			sum += i;
		}
		System.out.println("Sum of 0 to 100: " + sum);
		int nums[] = new int[101];
		for (int i=0; i <=43; i++) {
			nums[i] = i;
		}
		for (int i=45; i  < nums.length; i++) {
			nums[i] = i;
		}
		int sum2 = 0;
		for (int i=0; i < nums.length; i++) {
			sum2 += nums[i];
		}
		System.out.println("Missing Number is: " + (sum - sum2));
	}

}
