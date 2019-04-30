using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class OddOrEvenTests
    {
        [TestMethod]
        public void OddOrEven_0()
        {
            OddOrEven oe = new OddOrEven();

            Assert.AreEqual("", oe.GetOddOrEven(0), "0 should return \"\"");
        }

        [TestMethod]
        public void OddOrEven_OddNumbers()
        {
            OddOrEven oe = new OddOrEven();

            Assert.AreEqual("Odd", oe.GetOddOrEven(1), "1 should return \"Odd\"");
            Assert.AreEqual("Odd", oe.GetOddOrEven(3), "3 should return \"Odd\"");
            Assert.AreEqual("Odd", oe.GetOddOrEven(-1), "-1 should return \"Odd\"");
            Assert.AreEqual("Odd", oe.GetOddOrEven(-3), "-3 should return \"Odd\"");
        }

        [TestMethod]
        public void OddOrEven_EvenNumbers()
        {
            OddOrEven oe = new OddOrEven();

            Assert.AreEqual("Even", oe.GetOddOrEven(2), "2 should return \"Even\"");
            Assert.AreEqual("Even", oe.GetOddOrEven(4), "4 should return \"Even\"");
            Assert.AreEqual("Even", oe.GetOddOrEven(-2), "-2 should return \"Even\"");
            Assert.AreEqual("Even", oe.GetOddOrEven(-4), "-4 should return \"Even\"");
        }

    }
}
