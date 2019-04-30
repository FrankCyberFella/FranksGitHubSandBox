using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public class InspiringStrings
    {
        /*
         * When given a string of space separated words, return the word with the 
         * longest length. If there are multiple words with the longest length, 
         * return the last instance of the word with the longest length.
         * 
         * Null or empty string should return "".
         * 
         * Example:
         * "red white blue" => "white"
         * "red blue gold" => "gold"
         * "" => ""
         * null => ""
         */
        public string GetInspired(string phrase)
        {
            if (String.IsNullOrEmpty(phrase))
            {
                return "";
            }

            string[] words = phrase.Split(' ');
            string longestWord = "";
            for (int i = 0; i < words.Length; i++)
            {
                if (words[i].Length >= longestWord.Length)
                {
                    longestWord = words[i];
                }
            }

            return longestWord;
        }
    }
}
