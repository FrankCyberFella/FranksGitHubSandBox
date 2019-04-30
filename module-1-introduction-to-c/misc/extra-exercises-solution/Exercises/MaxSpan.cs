﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public partial class Exercises
    {

        /*
        CHALLENGE: Consider the leftmost and righmost appearances of some value in an array.
        We'll say that the "span" is the number of elements between the two inclusive. 
        A single value has a span of 1. 
        Returns the largest span found in the given array. (Efficiency is not a priority.)

        maxSpan([1, 2, 1, 1, 3]) → 4
        maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
        maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
        */
        public int MaxSpan(int[] nums)
        {
            if (nums.Length > 0)
            {
                int maxSpan = 1;
                for (int i = 0; i < nums.Length; i++)
                {
                    for (int j = nums.Length - 1; j > i; j--)
                    {
                        if (nums[j] == nums[i])
                        {
                            int count = (j - i) + 1;
                            if (count > maxSpan)
                            {
                                maxSpan = count;
                            }
                            break;
                        }
                    }
                }
                return maxSpan;
            }
            else
            {
                return 0;
            }

        }
    }
}
