﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
   
    public class FindVowels
    {
        /* 
         * We want to know the index of the vowels in a given word, 
         * for example, there are two vowels in the word super (the second and fourth letters).
         * 
         * Given the string "super", we should return a list of [2, 4].
         * 
         * Vowels in this context refer to English language vowels - a e i o u
         * These are index from [1...n] (not zero indexed!)
         * Mmmm  => []
         * Super => [2, 4]
         * Apple => [1, 5]
         */
        public List<int> FindTheVowels(string word)
        {
            List<int> output = new List<int>();

            if (String.IsNullOrEmpty(word))
            {
                return output;
            }

            word = word.ToLower();
            for (int i = 0; i < word.Length; i++)
            {
                if (word[i] == 'a' || word[i] == 'e' || word[i] == 'o' || word[i] == 'u')
                {
                    output.Add(i + 1);
                }
            }

            return output;
        }


    }
}
