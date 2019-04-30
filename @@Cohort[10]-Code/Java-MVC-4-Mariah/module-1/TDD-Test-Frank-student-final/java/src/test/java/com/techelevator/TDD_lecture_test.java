package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class TDD_lecture_test {

 //   RomanNumeral testObject = new RomanNumeral(1);
  

    @Test
    public void RomanNumeral_Ones()
    {

        assertEquals("I", new RomanNumeral(1).getRomanNumeral());
        assertEquals("II", new RomanNumeral(2).getRomanNumeral());
        assertEquals("III", new RomanNumeral(3).getRomanNumeral());
        assertEquals(3, new RomanNumeral(3).getDecimalValue());
    }

    
    @Test
    public void RomanNumeral_Fives()
    {
        //Assert
        assertEquals("V", new RomanNumeral(5).getRomanNumeral());
        assertEquals("VI", new RomanNumeral(6).getRomanNumeral());
        assertEquals("VII", new RomanNumeral(7).getRomanNumeral());
    }

    @Test
    public void RomanNumeral_Tens()
    {
        //Assert
        assertEquals("X", new RomanNumeral(10).getRomanNumeral());
        assertEquals("XI", new RomanNumeral(11).getRomanNumeral());
        assertEquals("XV", new RomanNumeral(15).getRomanNumeral());
        assertEquals("XXVI", new RomanNumeral(26).getRomanNumeral());
    }

    @Test
    public void RomanNumeral_Fifties()
    {
        assertEquals("L", new RomanNumeral(50).getRomanNumeral());
        assertEquals("LX", new RomanNumeral(60).getRomanNumeral());
        assertEquals("LXXVIII", new RomanNumeral(78).getRomanNumeral());
    }

    @Test
    public void RomanNumeral_OtherPlaceholders()
    {
        assertEquals("C", new RomanNumeral(100).getRomanNumeral());
        assertEquals("D", new RomanNumeral(500).getRomanNumeral());
        assertEquals("M", new RomanNumeral(1000).getRomanNumeral());
    }

    @Test
    public void RomanNumeral_Subtractive()
    {
        assertEquals("MIV", new RomanNumeral(1004).getRomanNumeral());
        assertEquals("DIV", new RomanNumeral(504).getRomanNumeral());
        assertEquals("CDLXII", new RomanNumeral(462).getRomanNumeral());
        assertEquals("CDXCIX", new RomanNumeral(499).getRomanNumeral());
        assertEquals("XLI", new RomanNumeral(41).getRomanNumeral());
        assertEquals("XCV", new RomanNumeral(95).getRomanNumeral());
    }


    /* Solve it long form first */
    //@Test
    //public void RomanNumeral_Subtractive()
    //{
    //    assertEquals("MIIII", new RomanNumeral(1004).getRomanNumeral());
    //    assertEquals("DIIII", new RomanNumeral(504).getRomanNumeral());
    //    assertEquals("CCCCLXII", new RomanNumeral(462).getRomanNumeral());
    //    assertEquals("CCCCLXXXXVIIII", new RomanNumeral(499).getRomanNumeral());
    //    assertEquals("XXXXI", new RomanNumeral(41).getRomanNumeral());
    //    assertEquals("LXXXXV", new RomanNumeral(95).getRomanNumeral());
    //}

}

	

