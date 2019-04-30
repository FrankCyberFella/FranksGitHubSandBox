package com.techelevator;

public class testClass {
private int a;
private int b;
private int c;
private int d;
private int e;
private int f;
public testClass(int a, int b, int c, int d, int e, int f) {
	super();
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
	this.e = e;
	this.f = f;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "testClass [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + "]";
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + a;
	result = prime * result + b;
	result = prime * result + c;
	result = prime * result + d;
	result = prime * result + e;
	result = prime * result + f;
	return result;
}
/* (non-Javadoc)
 * @see java.lang.Object#equals(java.lang.Object)
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	testClass other = (testClass) obj;
	if (a != other.a)
		return false;
	if (b != other.b)
		return false;
	if (c != other.c)
		return false;
	if (d != other.d)
		return false;
	if (e != other.e)
		return false;
	if (f != other.f)
		return false;
	return true;
}
}
