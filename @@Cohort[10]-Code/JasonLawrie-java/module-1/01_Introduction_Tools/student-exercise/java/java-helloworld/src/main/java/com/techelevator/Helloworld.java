package com.techelevator;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Exc0 extends Exception{}
class Exc1 extends Exc0{}

public class Helloworld {


    

 public static void main(String[] args) {
        

        
        
        
        
        try {
        	throw new Exc1();
        } catch(Exc0 e0) {
        	System.out.println("l1");
        } catch(Exception e) {
        	System.out.println("second");
        }
   }
}