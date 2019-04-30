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
        CHALLENGE: Using array A and array B, return an array that is the intersection of both A and B.
        The intersection includes numbers that appear in both arrays.

            ArrayIntersection([1, 3, 5], [1, 5, 7]) → [1, 5]
            ArrayIntersection([1], [1, 5, 7]) → [1]
            ArrayIntersection([1, 1, 1], [1, 5, 7]) → [1]
            ArrayIntersection([], []) → []
        */
        public int[] ArrayIntersection(int[] a, int[] b)
        {
            //Need to use ArrayList to preserve order so result can be unit tested
            List<int> list = new List<int>();
            a = ArrayDeduplication(a);  //Remove duplicates in array "a" before proceeding
            foreach (int num in a)      //Now, loop through array "a"
            {
                for (int i = 0; i < b.Length; i++)
                {
                    if (num == b[i])    //See if num intersects with the element in array "b"
                    {
                        list.Add(num);
                    }
                }
            }
            int[] newArray = new int[list.Count()];
            for (int i = 0; i < list.Count(); i++)
            {
                newArray[i] = list[i];
            }
            return newArray;
        }
    }
}
