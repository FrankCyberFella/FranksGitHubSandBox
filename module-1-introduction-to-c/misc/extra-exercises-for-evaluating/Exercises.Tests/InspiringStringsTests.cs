using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Exercises.Tests
{
    [TestClass]
    public class InspiringStringsTests
    {
        [TestMethod]
        public void InspiringStrings_NullOrEmptyString()
        {
            InspiringStrings inspire = new InspiringStrings();

            Assert.AreEqual("", inspire.GetInspired(null), "null string should return \"\"");
            Assert.AreEqual("", inspire.GetInspired(""), "Empty string \"\" should return \"\"");
        }

        [TestMethod]
        public void InspiringStrings_WithOneWord()
        {
            InspiringStrings inspire = new InspiringStrings();

            Assert.AreEqual("red", inspire.GetInspired("red"), "\"red\" should return \"red\"");
            Assert.AreEqual("white", inspire.GetInspired("white"), "\"white\" should return \"white\"");
            Assert.AreEqual("Red", inspire.GetInspired("Red"), "\"Red\" should return \"Red\"");
        }

        [TestMethod]
        public void InspiringStrings_WithOneLongWordAndOtherShortWords()
        {
            InspiringStrings inspire = new InspiringStrings();

            Assert.AreEqual("white", inspire.GetInspired("red white blue"), "\"red white blue\" should return \"white\"");
            Assert.AreEqual("White", inspire.GetInspired("Red White Blue"), "\"Red White Blue\" should return \"White\"");
            Assert.AreEqual("today", inspire.GetInspired("Hi how are you today"), "\"Hi how are you today\" should return \"today\"");
        }

        [TestMethod]
        public void InspiringStrings_WithWordsThatAreSameLength()
        {
            InspiringStrings inspire = new InspiringStrings();

            Assert.AreEqual("Dolly", inspire.GetInspired("Hello Dolly"), "\"Hello Dolly\" should return \"Dolly\"");
            Assert.AreEqual("you", inspire.GetInspired("Hi how are you"), "\"Hi how are you\" should return \"you\"");
        }
    }
}
