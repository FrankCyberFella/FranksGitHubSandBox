using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public class HighestAndLowest
    {
        /*
         * DIFFICULT
         * Given a string of space separated numbers, return the highest and lowest
         * number.
         * 
         * EXAMPLES:
         * "1" => "1 1"
         * "3" => "3 3"
         * "1 2 3 4 5"  => "5 1"
         * "1 2 -3 4 5" => "5 -3"
         * "1 9 3 4 -5" => "9 -5"
         * "" => ""
         * null => ""
         * 
         * NOTE: 
         *  All numbers are valid integers and can be parsed.          
         *  You need to check for null or empty string and return "".
         *  Every string that is not null or empty will have at least 1 number.
         *  Output string must be two numbers separated by a single space, and highest number 
         *  is first.
         */ 
        public string GetHighLow(string input)
        {
            if (String.IsNullOrEmpty(input))
            {
                return "";
            }

            string[] numbers = input.Split(' ');
            int high = int.Parse(numbers[0]);
            int low = int.Parse(numbers[0]);

            for (int i = 0; i < numbers.Length; i++)
            {
                int number = int.Parse(numbers[i]);

                if (number > high)
                {
                    high = number;
                }

                if (number < low)
                {
                    low = number;
                }
            }

            return high + " " + low;
        }
    }
}
