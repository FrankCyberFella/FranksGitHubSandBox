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
        * Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and 
        * ending with 'p'. Return a string where for all such words, the middle letter is gone, 
        * so "zipXzap" yields "zpXzp".
        *
        * zipZap("zipXzap") → "zpXzp"
        * zipZap("zopzop") → "zpzp"
        * zipZap("zzzopzop") → "zzzpzp"        * 
        */
        public string ZipZap(string str)
        {
            for (int i = 0; i < str.Length - 2; i++)
            {
                if (str[i] == 'z' && str[i + 2] == 'p') {
                    str = str.Substring(0, i + 1) + str.Substring(i + 2);
                }
            }
            return str;
        }
    }
}
