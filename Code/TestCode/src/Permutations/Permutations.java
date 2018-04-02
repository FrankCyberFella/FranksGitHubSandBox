package Permutations;

import java.util.HashSet;
import java.util.Set;
import StringHelper;


public class Permutations {

	public static void main(String[] args) 
	{ 
    Set<String> str;
	str = findPermations("ABC"); // ["ACB","ABC","BCA","CBA","CAB","BAC"]
	str = findPermations(null);    //null 
	str = findPermations("AAC");   // [“"]
	}


}
