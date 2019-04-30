using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public class OddOrEven
    {
        /*
         * Create a function that takes an integer as an argument and returns "Even" for 
         * even numbers or "Odd" for odd numbers. Return empty string "" for 0.
         * 
         * 5 returns "Odd"
         * 6 returns "Even"
         */
        public string GetOddOrEven(int number)
        {
            if (number == 0)
            {
                return "";
            }

            if (number % 2 == 0)
            {
                return "Even";
            }

            return "Odd";
        }
    }
}
