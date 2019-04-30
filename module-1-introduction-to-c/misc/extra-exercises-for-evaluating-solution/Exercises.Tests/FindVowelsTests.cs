using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class FindVowelsTests
    {
        [TestMethod]
        public void FindVowels_WordContainsNoVowels()
        {
            FindVowels fv = new FindVowels();

            CollectionAssert.AreEqual(new List<int> { }, fv.FindTheVowels(""), "The string \"\" should return [].");
            CollectionAssert.AreEqual(new List<int> { }, fv.FindTheVowels("Mmmm"), "The string \"Mmmm\" should return [].");
        }

        [TestMethod]
        public void FindVowels_WordContainsLowercaseVowels()
        {
            FindVowels fv = new FindVowels();

            CollectionAssert.AreEqual(new List<int> { 2, 4 }, fv.FindTheVowels("Super"), "The string \"Super\" should return [2,4].");
            CollectionAssert.AreEqual(new List<int> { 2, 5 }, fv.FindTheVowels("Hello"), "The string \"Hello\" should return [2,5].");
        }

        [TestMethod]
        public void FindVowels_WordContainsUppercaseVowels()
        {
            FindVowels fv = new FindVowels();

            CollectionAssert.AreEqual(new List<int> { 1, 5 }, fv.FindTheVowels("Apple"), "The string \"Apple\" should return [1,5].");
            CollectionAssert.AreEqual(new List<int> { 1, 2, 4, 6 }, fv.FindTheVowels("Eeyore"), "The string \"Eeyore\" should return [1,2,4,6].");
        }

        [TestMethod]
        public void FindVowels_WordIsNull()
        {
            FindVowels fv = new FindVowels();

            CollectionAssert.AreEqual(new List<int> { }, fv.FindTheVowels(null), "When null is passed in, return an empty list [].");            
        }
    }
}
