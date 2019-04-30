using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class HighestAndLowestTests
    {
        [TestMethod]
        public void GetHighLow_EmptyAndNullString()
        {
            HighestAndLowest hl = new HighestAndLowest();

            Assert.AreEqual("", hl.GetHighLow(null), "null should return \"\"");
            Assert.AreEqual("", hl.GetHighLow(""), "\"\" should return \"\"");
        }

        [TestMethod]
        public void GetHighLow_1Value()
        {
            HighestAndLowest hl = new HighestAndLowest();

            Assert.AreEqual("1 1", hl.GetHighLow("1"), "\"1\" should return \"1 1\"");
            Assert.AreEqual("3 3", hl.GetHighLow("3"), "\"1\" should return \"3 3\"");
        }

        [TestMethod]
        public void GetHighLow_SameValues()
        {
            HighestAndLowest hl = new HighestAndLowest();

            Assert.AreEqual("1 1", hl.GetHighLow("1 1"), "\"1 1\" should return \"1 1\"");
            Assert.AreEqual("-1 -1", hl.GetHighLow("-1 -1"), "\"-1 -1\" should return \"-1 -1\"");
        }

        [TestMethod]
        public void GetHighLow_MultipleValues()
        {
            HighestAndLowest hl = new HighestAndLowest();

            Assert.AreEqual("5 1", hl.GetHighLow("1 2 3 4 5"), "\"1 2 3 4 5\" should return \"5 1\"");
            Assert.AreEqual("5 -3", hl.GetHighLow("1 2 -3 4 5"), "\"1 2 -3 4 5\" should return \"5 -3\"");
            Assert.AreEqual("9 -5", hl.GetHighLow("1 9 3 4 -5"), "\"1 9 3 4 -5\" should return \"1 9 3 4 -5\"");
        }
    }
}
