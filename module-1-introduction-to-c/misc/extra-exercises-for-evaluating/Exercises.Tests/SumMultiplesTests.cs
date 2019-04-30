using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class SumMultiplesTests
    {
        [TestMethod]
        public void SumMultiplesTests_ContainsNoMultiples()
        {
            SumMultiples sm = new SumMultiples();

            Assert.AreEqual(0, sm.MultiplesOf3And5(0), "0 has no numbers below it that are multiples of 3 or 5.");
            Assert.AreEqual(0, sm.MultiplesOf3And5(2), "2 has no numbers below it that are multiples of 3 or 5.");
            Assert.AreEqual(0, sm.MultiplesOf3And5(3), "3 has no numbers below it that are multiples of 3 or 5.");
        }

        [TestMethod]
        public void SumMultiplesTests_Contains1Multiple()
        {
            SumMultiples sm = new SumMultiples();

            Assert.AreEqual(3, sm.MultiplesOf3And5(4), "4 has 1 number below it that is a multiple of 3 or 5.");
            Assert.AreEqual(3, sm.MultiplesOf3And5(5), "5 has 1 number below it that is a multiple of 3 or 5.");
        }

        [TestMethod]
        public void SumMultiplesTests_Contains2OrMoreMultiple()
        {
            SumMultiples sm = new SumMultiples();

            Assert.AreEqual(8, sm.MultiplesOf3And5(6), "6 has 3 numbers below it that are a multiple of 3 or 5.");
            Assert.AreEqual(14, sm.MultiplesOf3And5(9), "9 has 3 numbers below it that are a multiple of 3 or 5.");
            Assert.AreEqual(45, sm.MultiplesOf3And5(13), "13 has 6 numbers below it that are a multiple of 3 or 5 (3, 5, 6, 9, 10, 12).");
        }

        [TestMethod]
        public void SumMultiplesTests_ContainsMultiplesOf3And5()
        {
            SumMultiples sm = new SumMultiples();

            Assert.AreEqual(60, sm.MultiplesOf3And5(16), "16 has 7 numbers below it that are multiples of 3 or 5 (3, 5, 6, 9, 10, 12, 15).");            
        }

    }
}
