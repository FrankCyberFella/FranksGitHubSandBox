package SwapWithXOR;

public class SwapWithXOR {

	public static void main(String[] args) 
	{
	int a = 10;
	int b = 20;
	System.out.println("a=" + a);
	System.out.println("b=" + b);
	System.out.println("---- Doing XOR ----");
	a = a ^ b;
	b = a ^ b;
	a = a ^ b;
	System.out.println("a=" + a);
	System.out.println("b="+ b);
	
	String str = "";
	str = deFront("Hello");  // "llo"
	System.out.println("Returned: " + str);
	str = deFront("java");   // "va"
	System.out.println("Returned: " + str);
	str = deFront("away");   // "aay"
	System.out.println("Returned: " + str);
	str = deFront("ibis");   // "aay"
	System.out.println("Returned: " + str);
	str = deFront("abacus");   // "aay"
	System.out.println("Returned: " + str);
	}

static	public String deFront(String s) 
	{      
	System.out.println("Received: " + s);
	if (s.charAt(0) == 'a' && s.charAt(1) != 'b')
	   return s.charAt(0) + s.substring(2);
	if (s.charAt(0) != 'a' && s.charAt(1) == 'b')
	   return s.substring(1);
	if (s.charAt(0) == 'a' && s.charAt(1) == 'b')
	    return s;
	return s.substring(2);
	}
}
