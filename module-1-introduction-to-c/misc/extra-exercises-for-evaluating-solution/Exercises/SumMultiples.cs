using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public class SumMultiples
    {

        /*
         * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
         * we get 3, 5, 6 and 9. The sum of these multiples is 23.
         * 
         * Finish the solution so that it returns the sum of all 
         * numbers that are a multiple of 3 or 5 below the number passed in.
         * 
         * Note: If the number is a multiple of both 3 and 5, only count it once.
         */
        public int MultiplesOf3And5(int number)
        {
            int sum = 0;

            for (int i = 0; i < number; i++)
            {
                if (i % 3 == 0 || i % 5 == 0)
                {
                    sum += i;
                }
            }
            return sum;
        }

    }
}
