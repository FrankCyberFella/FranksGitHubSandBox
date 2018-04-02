
public class LowestEvenNumber {

	public static void main(String[] args) 
	{
	int nums[] = {3,8,6,8,1,3};
	int lowNum=Integer.MAX_VALUE;
	
	for (int i=0; i < nums.length; i++)
	{
		lowNum = (nums[i] % 2)  == 0  ? ((nums[i] < lowNum) ? nums[i] : lowNum) : lowNum;
	}
	System.out.println("Lowest Even Value is: " + lowNum);
	}

}
