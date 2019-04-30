package com.techelevator;

public class Exercises {

	/*
	 * Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 * helloName("Bob") → "Hello Bob!" helloName("Alice") → "Hello Alice!"
	 * helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {

		return ("Hello " + name + "!");

	}

	/*
	 * Given two strings, a and b, return the result of putting them together in the
	 * order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi". makeAbba("Hi", "Bye") →
	 * "HiByeByeHi" makeAbba("Yo", "Alice") → "YoAliceAliceYo" makeAbba("What",
	 * "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		String joinedAndRepeat = String.join("", a, b, b, a);
		return joinedAndRepeat;
	}

	/*
	 * The web is built with HTML strings like "<i>Yay</i>" which draws Yay as
	 * italic text. In this example, the "i" tag makes <i> and </i> which surround
	 * the word "Yay". Given tag and word strings, create the HTML string with tags
	 * around the word, e.g. "<i>Yay</i>". makeTags("i", "Yay") → "<i>Yay</i>"
	 * makeTags("i", "Hello") → "<i>Hello</i>" makeTags("cite", "Yay") →
	 * "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		String tagged = String.join("", "<", tag, ">", word, "</", tag, ">");
		return tagged;
	}

	/*************
	 * Given an "out" string length 4, such as "<<>>", and a word, return a new
	 * string where the word is in the middle of the out string, e.g. "<<word>>".
	 * Note: use str.substring(i, j) to extract the String starting at index i and
	 * going up to but not including index j. makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 * makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>" makeOutWord("[[]]", "word") →
	 * "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		String first = out.substring(0, 2);
		String last = out.substring(3);
		String connected = String.join("", first, word, last);
		return connected;
	}

	/*
	 * Given a string, return a new string made of 3 copies of the last 2 chars of
	 * the original string. The string length will be at least 2. extraEnd("Hello")
	 * → "lololo" extraEnd("ab") → "ababab" extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {

		String lastTwo = str.substring(str.length() - 2);
		String tripleTwo = String.join("", lastTwo, lastTwo, lastTwo);
		return tripleTwo;
	}

	/*
	 * Given a string, return the string made of its first two chars, so the String
	 * "Hello" yields "He". If the string is shorter than length 2, return whatever
	 * there is, so "X" yields "X", and the empty string "" yields the empty string
	 * "". Note that str.length() returns the length of a string. firstTwo("Hello")
	 * → "He" firstTwo("abcdefg") → "ab" firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {

		if (str.length() <= 2) {
			return str;
		} else {
			String initialTwo = str.substring(0, 2);
			return initialTwo;
		}

	}

	/*
	 * Given a string of even length, return the first half. So the string "WooHoo"
	 * yields "Woo". firstHalf("WooHoo") → "Woo" firstHalf("HelloThere") → "Hello"
	 * firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		int halfLength = (str.length() / 2);
		String halved = str.substring(0, halfLength);
		return halved;
	}

	/*
	 * Given a string, return a version without the first and last char, so "Hello"
	 * yields "ell". The string length will be at least 2. withoutEnd("Hello") →
	 * "ell" withoutEnd("java") → "av" withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		String chopped = str.substring(1, str.length() - 1);
		return chopped;
	}

	/*
	 * Given 2 strings, a and b, return a string of the form short+long+short, with
	 * the shorter string on the outside and the longer string on the inside. The
	 * strings will not be the same length, but they may be empty (length 0).
	 * comboString("Hello", "hi") → "hiHellohi" comboString("hi", "Hello") →
	 * "hiHellohi" comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		int aye = a.length();
		int bee = b.length();

		if (aye > bee) {
			String aBig = String.join("", b, a, b);
			return aBig;
		} else {
			String bBig = String.join("", a, b, a);
			return bBig;
		}
	}

	/*
	 * Given 2 strings, return their concatenation, except omit the first char of
	 * each. The strings will be at least length 1. nonStart("Hello", "There") →
	 * "ellohere" nonStart("java", "code") → "avaode" nonStart("shotl", "java") →
	 * "hotlava"
	 */
	public String nonStart(String a, String b) {

		String aSnip = a.substring(1);
		String bSnip = b.substring(1);
		String glueSnip = (aSnip + bSnip);
		return glueSnip;
	}

	/*
	 * Given a string, return a "rotated left 2" version where the first 2 chars are
	 * moved to the end. The string length will be at least 2. left2("Hello") →
	 * "lloHe" left2("java") → "vaja" left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		String first2 = str.substring(0, 2);
		String theRest = str.substring(2);
		String rotated = (theRest + first2);

		return rotated;
	}

	/*
	 * Given a string, return a "rotated right 2" version where the last 2 chars are
	 * moved to the start. The string length will be at least 2. right2("Hello") →
	 * "loHel" right2("java") → "vaja" right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		String last2 = str.substring(str.length() - 2);
		String theFirstPart = str.substring(0, str.length() - 2);
		String shifted = (last2 + theFirstPart);
		return shifted;
	}

	/*
	 * Given a string, return a string length 1 from its front, unless front is
	 * false, in which case return a string length 1 from its back. The string will
	 * be non-empty. theEnd("Hello", true) → "H" theEnd("Hello", false) → "o"
	 * theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		if (front == true) {
			String fromFront = str.substring(0, 1);
			return fromFront;
		} else {

			String fromBack = str.substring(str.length() - 1);
			return fromBack;
		}
	}

	/*
	 * Given a string, return a version without both the first and last char of the
	 * string. The string may be any length, including 0. withoutEnd2("Hello") →
	 * "ell" withoutEnd2("abc") → "b" withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		if (str.length() == 3) {
			return str.substring(1, 2);
		} else {
			if (str.length() <= 2) {
				return ("");
			}
			String cut = str.substring(1, str.length() - 1);
			return cut;
		}
	}

	/*
	 * Given a string of even length, return a string made of the middle two chars,
	 * so the string "string" yields "ri". The string length will be at least 2.
	 * middleTwo("string") → "ri" middleTwo("code") → "od" middleTwo("Practice") →
	 * "ct"
	 */
	public String middleTwo(String str) {

		int measured = str.length();
		String mid2 = str.substring((measured / 2) - 1, ((measured / 2) + 1));
		return mid2;

	}

	/*
	 * Given a string, return true if it ends in "ly". endsLy("oddly") → true
	 * endsLy("y") → false endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		boolean endsLee = str.endsWith("ly");
		return endsLee;
	}

	/*
	 * Given a string and an int n, return a string made of the first and last n
	 * chars from the string. The string length will be at least n. nTwice("Hello",
	 * 2) → "Helo" nTwice("Chocolate", 3) → "Choate" nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {

		String n1 = str.substring(0, n);
		String n2 = str.substring(str.length() - 3);
		return (n1 + n2);
	}

	/*
	 * Given a string and an index, return a string length 2 starting at the given
	 * index. If the index is too big or too small to define a string length 2, use
	 * the first 2 chars. The string length will be at least 2. twoChar("java", 0) →
	 * "ja" twoChar("java", 2) → "va" twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int index) {

		if (index < 0 || index > str.length() - 2) {
			return str.substring(0, 2);
		} else {
			String tooChar = str.substring(index);
			if (tooChar.length() > 2) {
				String tooChar1 = tooChar.substring(0, 2);
				return tooChar1;
			} else {
				if (tooChar.length() == 2) {
					return tooChar;
				} else if (tooChar.length() < 2)

					return str.substring(0, 2);

			}
			return tooChar;
		}
	}

	/*
	 * Given a string of odd length, return the string length 3 from its middle, so
	 * "Candy" yields "and". The string length will be at least 3.
	 * middleThree("Candy") → "and" middleThree("and") → "and"
	 * middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		int a = (str.length() / 2) - 1;
		String mid3 = str.substring(a, a + 3);
		return mid3;
	}

	/*
	 * Given a string, return true if "bad" appears starting at index 0 or 1 in the
	 * string, such as with "badxxx" or "xbadxx" but not "xxbadxx". The string may
	 * be any length, including 0. Note: use .equals() to compare 2 strings.
	 * hasBad("badxx") → true hasBad("xbadxx") → true hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {

		if (str.length() < 3) {
			return false;
		}
		boolean startBad = str.startsWith("bad");
		String snipFirst = str.substring(1);
		boolean snippedBad = snipFirst.startsWith("bad");

		if (startBad || snippedBad == true) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Given a string and a non-negative int n, return a larger string that is n
	 * copies of the original string. stringTimes("Hi", 2) → "HiHi"
	 * stringTimes("Hi", 3) → "HiHiHi" stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {

		String glue = "";
		for (int i = 0; i < n; i++) {
			glue += str;
		}
		return glue;
	}

	/*
	 * Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less than
	 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) → "ChoCho"
	 * frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {

		if (str.length() == 3) {
			String glue = "";
			for (int i = 0; i < n; i++) {
				glue += str;
			}
			return glue;

		} else {
			if (str.length() > 3) {
				String slice = str.substring(0, 3);
				String glue = "";
				for (int i = 0; i < n; i++) {
					glue += slice;
				}
				return glue;
			}

			else {
				if (str.length() <= 2) {
					// String slicedAgain = str.substring(0, 3);
					String glue = "";
					for (int i = 0; i < n; i++) {
						glue += str;
					}
					return glue;
				}

				return null;
			}
		}
	}

	/*
	 * Count the number of "xx" in the given string. We'll say that overlapping is
	 * allowed, so "xxx" contains 2 "xx". countXX("abcxx") → 1 countXX("xxx") → 2
	 * countXX("xxxx") →
	 */
	public int countXX(String str) {

		boolean has1 = str.contains("xx");
		boolean has2 = str.contains("xxx");
		boolean has3 = str.contains("xxxx");

		if (has3 == true) {
			return 3;
		} else {
			if (has2 == true) {
				return 2;
			} else {
				if (has1 == true) {
					return 1;
				}
				return 0;
			}

		}
	}

	/*
	 * Given a string, return true if the first instance of "x" in the string is
	 * immediately followed by another "x". doubleX("axxbb") → true
	 * doubleX("axaxax") → false doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x') {
				return true;
			}
			if (str.charAt(i) == 'x' && str.charAt(i + 1) != 'x') {
				return false;
			}

		}

		return false;
	}

	/*
	 * Given a string, return a new string made of every other char starting with
	 * the first, so "Hello" yields "Hlo". stringBits("Hello") → "Hlo"
	 * stringBits("Hi") → "H" stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		return null; // DO A SPLIT AND MAKE AN ARRAY, THEN FOR LOOP?
	}

	/*
	 * Given a non-empty string like "Code" return a string like "CCoCodCode".
	 * stringSplosion("Code") → "CCoCodCode" stringSplosion("abc") → "aababc"
	 * stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		return null;
	}

	/*
	 * Given a string, return the count of the number of times that a substring
	 * length 2 appears in the string and also as the last 2 chars of the string, so
	 * "hixxxhi" yields 1 (we won't count the end substring). last2("hixxhi") → 1
	 * last2("xaxxaxaxx") → 1 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		return 0;
	}

	/*
	 * Given a string, return a version where all the "x" have been removed. Except
	 * an "x" at the very start or end should not be removed. stringX("xxHxix") →
	 * "xHix" stringX("abxxxcd") → "abcd" stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		return null;
	}

	/*
	 * Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9
	 * ... so "kittens" yields "kien". altPairs("kitten") → "kien"
	 * altPairs("Chocolate") → "Chole" altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		return null;
	}

	/*
	 * Suppose the string "yak" is unlucky. Given a string, return a version where
	 * all the "yak" are removed, but the "a" can be any char. The "yak" strings
	 * will not overlap. stringYak("yakpak") → "pak" stringYak("pakyak") → "pak"
	 * stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		return null;
	}

}
