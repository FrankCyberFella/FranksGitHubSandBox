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
        CHALLENGE: Given a string, return the length of the largest "block" in the string. 
        A block is a run of adjacent chars that are the same.

        maxBlock("hoopla") → 2
        maxBlock("abbCCCddBBBxx") → 3
        maxBlock("") → 0
        */
        public int MaxBlock(string str)
        {
            int max = 0;
            for (int i = 0; i < str.Length; i++)
            {
                int count = 0;
                for (int j = i; j < str.Length; j++)
                {
                    if (str[i] == str[j])
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                if (count > max)
                {
                    max = count;
                }
            }
            return max;
        }
    }
}
