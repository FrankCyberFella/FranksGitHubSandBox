using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public partial class Exercises
    {
        /*
        CHALLENGE: Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
        Return the number of clumps in the given array.

        countClumps([1, 2, 2, 3, 4, 4]) → 2
        countClumps([1, 1, 2, 1, 1]) → 2
        countClumps([1, 1, 1, 1, 1]) → 1
        */
        public int CountClumps(int[] nums)
        {
            int count = 0;
            for (int i = 0; i < nums.Length - 1; i++)
            {
                if (nums[i] == nums[i + 1])
                {
                    count++;
                    for (int j = i + 1; j < nums.Length; j++)
                    {
                        if (nums[j] == nums[i])
                        {
                            i++;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
            return count;
        }
    }
}
