using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SampleCode
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Franks's Sample Code");
            SortEm(3, 2, 1);
            SortEm(1, 2, 3);
            SortEm(1, 3, 2);
            SortEm(1, 1, 1);
            SortEm(0, -1, -2);

            Console.WriteLine("\n\nFranks's Sample Code using Alternate Technique");
            SortEm2(3, 2, 1);
            SortEm2(1, 2, 3);
            SortEm2(1, 3, 2);
            SortEm2(1, 1, 1);
            SortEm2(0, -1, -2);
        }
        public static void SortEm(int a, int b, int c)
        {
            Console.WriteLine("\nBefore sort: a=" + a + " b=" + b + " c=" + c);

            int  hold = 0;          // used to hold value when swapping 
            bool done = false;      // loop control variable

            while (!done)           // loop while not done
            {
                if (a > b)          // if 1st value is greater than 2nd value, swap them
                   {
                    hold = b;       // remember the value in the 2nd variable
                    b = a;          // assign content of 1st variable to content of 2nd
                    a = hold;       // assign the "old" value in the 2nd variable to 1st
                   }
                else                // if 1st value is not greater than 2nd value (it's <=)
                   {
                    if (b > c)      // if 2nd value is greater than 3rd value, swap them
                       {
                        hold = c;   // remember the value in the 3rd variable
                        c = b;      // assign content of 2nd variable to content of 3rd
                        b = hold;   // assign the "old" value in the 3rd variable to 2nd
                       }
                    else            // if 1st <= 2nd and 2nd <= 1st
                       {
                        done = true;// we are done!
                       }
                }
            }
           Console.WriteLine(" After sort: a=" + a + " b=" + b + " c=" + c);
        }

//*************************************************************************************
//  Alternate solution using a second method to do the swapping of the values
//*************************************************************************************

        public static void SortEm2(int a, int b, int c)
        {
            Console.WriteLine("\nBefore sort: a=" + a + " b=" + b + " c=" + c);

            bool done = false;       // loop control variable

            while (!done)            // loop while not done
            {
                if (a > b)           // if 1st value is greater than 2nd value, swap them
                   {
                    SwapEm(a, b);    // Swap values in the variables
                   }
                else                 // if 1st value is not greater than 2nd value (it's <=)
                   {
                    if (b > c)       // if 2nd value is greater than 3rd value, swap them
                       {
                        SwapEm(b, c);// Swap the values in the variables
                       }
                    else             // if 1st <= 2nd and 2nd <= 1st
                       {
                        done = true;// we are done!
                       }
                    }
            }
            Console.WriteLine(" After sort: a=" + a + " b=" + b + " c=" + c);
        }

        public static void SwapEm(int var1, int var2)
        {
            int hold = 0;      // used to hold value when swapping

            hold = var2;       // remember the value in the 2nd variable
            var2 = var1;       // assign content of 1st variable to content of 2nd
            var1 = var2;       // assign the "old" value in the 2nd variable to 1st
        }
    }
}
