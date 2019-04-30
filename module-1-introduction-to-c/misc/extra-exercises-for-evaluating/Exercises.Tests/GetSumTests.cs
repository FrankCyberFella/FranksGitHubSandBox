using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class GetSumTests
    {
        [TestMethod]
        public void GetSum_EqualNumbers()
        {
            GetSum gs = new GetSum();

            Assert.AreEqual(0, gs.Find(0, 0), "The range sum between 0 and 0 is 0.");
            Assert.AreEqual(5, gs.Find(5, 5), "The range sum between 5 and 5 is 5.");
        }

        [TestMethod]
        public void GetSum_ALessThanB()
        {
            GetSum gs = new GetSum();

            Assert.AreEqual(1, gs.Find(0, 1), "The range sum between 0 and 1 is 1.");

            Assert.AreEqual(1 + 2 + 3, gs.Find(1, 3), "The range sum between 1 and 3 is (1 + 2 + 3).");
            Assert.AreEqual(3 + 4 + 5 + 6 + 7, gs.Find(3, 7), "The range sum between 3 and 7 is (3 + 4 + 5 + 6 + 7).");
        }

        [TestMethod]
        public void GetSum_BLessThanA()
        {
            GetSum gs = new GetSum();

            Assert.AreEqual(1, gs.Find(1, 0), "The range sum between 0 and 1 is 1.");

            Assert.AreEqual(1 + 2 + 3, gs.Find(3, 1), "The range sum between 1 and 3 is (1 + 2 + 3).");
            Assert.AreEqual(3 + 4 + 5 + 6 + 7, gs.Find(7, 3), "The range sum between 3 and 7 is (3 + 4 + 5 + 6 + 7).");
        }

        [TestMethod]
        public void GetSum_NegativeNumbers()
        {
            GetSum gs = new GetSum();

            Assert.AreEqual(0, gs.Find(-1, 1), "The range sum between -1 and 1 is (-1 + 0 + 1).");
            Assert.AreEqual(0, gs.Find(1, -1), "The range sum between -1 and 1 is (-1 + 0 + 1).");
            Assert.AreEqual(2, gs.Find(-1, 2), "The range sum between -1 and 2 is (-1 + 0 + 1 + 2)");
        }


    }
}
