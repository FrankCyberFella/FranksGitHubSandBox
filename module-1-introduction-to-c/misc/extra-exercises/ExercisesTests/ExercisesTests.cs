using Microsoft.VisualStudio.TestTools.UnitTesting;
using Exercises;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises.Tests
{
    [TestClass()]
    public class ExercisesTests
    {
        [TestMethod()]
        public void ArraySortTest()
        {
            Exercises e = new Exercises();

            CollectionAssert.AreEqual(new int[] { 8, 9, 12, 13 }, e.ArraySort(new int[] { 8, 13, 9, 12 }));
            CollectionAssert.AreEqual(new int[] { }, e.ArraySort(new int[] { }));
            CollectionAssert.AreEqual(new int[] { 100 }, e.ArraySort(new int[] { 100 }));
            CollectionAssert.AreEqual(new int[] { -3, 5, 15 }, e.ArraySort(new int[] { 5, -3, 15 }));
        }

        [TestMethod()]
        public void ArrayDeduplicationTest()
        {
            Exercises e = new Exercises();

            CollectionAssert.AreEqual(new int[] { 8, 13, 9, 11, 12 }, e.ArrayDeduplication(new int[] { 8, 13, 13, 9, 11, 12 }));
            CollectionAssert.AreEqual(new int[] { }, e.ArrayDeduplication(new int[] { }));
            CollectionAssert.AreEqual(new int[] { 1 }, e.ArrayDeduplication(new int[] { 1, 1, 1 }));            
        }

        [TestMethod]
        public void ArrayIntersectionTest()
        {

            Exercises e = new Exercises();

            CollectionAssert.AreEqual(new int[] { 1, 5 }, e.ArrayIntersection(new int[] { 1, 3, 5 }, new int[] { 1, 5, 7 }));
            CollectionAssert.AreEqual(new int[] { 1 }, e.ArrayIntersection(new int[] { 1 }, new int[] { 1, 5, 7 }));
            CollectionAssert.AreEqual(new int[] { 1 }, e.ArrayIntersection(new int[] { 1, 5, 7 }, new int[] { 1 }));
            CollectionAssert.AreEqual(new int[] { 1 }, e.ArrayIntersection(new int[] { 1, 1, 1 }, new int[] { 1, 5, 7 }));
            CollectionAssert.AreEqual(new int[] { }, e.ArrayIntersection(new int[] { }, new int[] { }));

        }


        [TestMethod]
        public void BlackjackTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(21, e.Blackjack(19, 21));
            Assert.AreEqual(21, e.Blackjack(21, 19));
            Assert.AreEqual(19, e.Blackjack(19, 22));
            Assert.AreEqual(0, e.Blackjack(22, 50));
            Assert.AreEqual(0, e.Blackjack(22, 22));
            Assert.AreEqual(4, e.Blackjack(3, 4));
        }

        [TestMethod]
        public void CloseFarTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.CloseFar(1, 2, 10));
            Assert.AreEqual(false, e.CloseFar(1, 2, 3));
            Assert.AreEqual(true, e.CloseFar(4, 1, 3));
            Assert.AreEqual(false, e.CloseFar(4, 5, 3));
            Assert.AreEqual(false, e.CloseFar(4, 3, 5));
            Assert.AreEqual(true, e.CloseFar(-1, 10, 0));
            Assert.AreEqual(true, e.CloseFar(0, -1, 10));
            Assert.AreEqual(true, e.CloseFar(10, 10, 8));
            Assert.AreEqual(false, e.CloseFar(10, 8, 9));
            Assert.AreEqual(false, e.CloseFar(8, 9, 10));
        }

        [TestMethod]
        public void CountClumpsTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(2, e.CountClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
            Assert.AreEqual(2, e.CountClumps(new int[] { 1, 1, 2, 1, 1 }));
            Assert.AreEqual(1, e.CountClumps(new int[] { 1, 1, 1, 1, 1 }));
            Assert.AreEqual(0, e.CountClumps(new int[] { 1, 2, 3 }));
            Assert.AreEqual(4, e.CountClumps(new int[] { 2, 2, 1, 1, 1, 2, 1, 1, 2, 2 }));
            Assert.AreEqual(4, e.CountClumps(new int[] { 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2 }));
            Assert.AreEqual(5, e.CountClumps(new int[] { 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2 }));
            Assert.AreEqual(0, e.CountClumps(new int[] { }));
        }

        [TestMethod]
        public void FindNodeTests()
        {
            Exercises e = new Exercises();

            LinkedList<int> list = new LinkedList<int>();            
            LinkedListNode<int> head = list.AddFirst(3);
            LinkedListNode<int> nextNode = list.AddAfter(head, 7);
            nextNode = list.AddAfter(nextNode, 9);
            nextNode = list.AddAfter(nextNode, 10);
            nextNode = list.AddAfter(nextNode, 15);
            nextNode = list.AddAfter(nextNode, 18);

            Assert.AreEqual(15, e.FindNode(list, 15).Value);
            Assert.AreEqual(18, e.FindNode(list, 18).Value);
            Assert.IsNull(e.FindNode(list, 17));
        }

        [TestMethod]
        public void Has271Test()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.Has271(new int[] { 1, 2, 7, 1 }));
            Assert.AreEqual(false, e.Has271(new int[] { 1, 2, 8, 1 }));
            Assert.AreEqual(true, e.Has271(new int[] { 2, 7, 1 }));
            Assert.AreEqual(true, e.Has271(new int[] { 3, 8, 2 }));
            Assert.AreEqual(true, e.Has271(new int[] { 2, 7, 3 }));
            Assert.AreEqual(false, e.Has271(new int[] { 2, 7, -2, 4, 10, 2 }));
            Assert.AreEqual(true, e.Has271(new int[] { 2, 7, -2, 4, 9, 3 }));
        }

        [TestMethod]
        public void LastDigitTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.LastDigit(23, 19, 13));
            Assert.AreEqual(false, e.LastDigit(23, 19, 12));
            Assert.AreEqual(true, e.LastDigit(23, 19, 3));
            Assert.AreEqual(true, e.LastDigit(0, 11, 0));
            Assert.AreEqual(true, e.LastDigit(10, 11, 20));
            Assert.AreEqual(true, e.LastDigit(1, 2, 2));
            Assert.AreEqual(true, e.LastDigit(1, 1, 2));
            Assert.AreEqual(false, e.LastDigit(1, 2, 3));
        }

        [TestMethod]
        public void MakeBricksTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.MakeBricks(3, 1, 8));
            Assert.AreEqual(false, e.MakeBricks(3, 1, 9));
            Assert.AreEqual(true, e.MakeBricks(3, 2, 10));
            Assert.AreEqual(true, e.MakeBricks(3, 2, 8));
            Assert.AreEqual(false, e.MakeBricks(3, 2, 9));
            Assert.AreEqual(true, e.MakeBricks(6, 1, 11));
            Assert.AreEqual(false, e.MakeBricks(6, 0, 11));
            Assert.AreEqual(true, e.MakeBricks(1, 4, 11));
            Assert.AreEqual(true, e.MakeBricks(0, 3, 10));
            Assert.AreEqual(false, e.MakeBricks(1, 4, 12));
            Assert.AreEqual(true, e.MakeBricks(1000000, 1000, 1000100));
            Assert.AreEqual(true, e.MakeBricks(20, 4, 39));
            Assert.AreEqual(false, e.MakeBricks(2, 1000000, 100003));
        }

        [TestMethod]
        public void MaxBlockTests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(2, e.MaxBlock("hoopla"));
            Assert.AreEqual(3, e.MaxBlock("abbCCCddBBBxx"));
            Assert.AreEqual(0, e.MaxBlock(""));
            Assert.AreEqual(1, e.MaxBlock("xyz"));
            Assert.AreEqual(2, e.MaxBlock("xxyz"));
            Assert.AreEqual(2, e.MaxBlock("xyzz"));
            Assert.AreEqual(3, e.MaxBlock("abbbcbbbxbbbx"));
            Assert.AreEqual(3, e.MaxBlock("XXBBBbbxx"));
            Assert.AreEqual(4, e.MaxBlock("XXBBBBbbxx"));
            Assert.AreEqual(4, e.MaxBlock("XXBBBbbxxXXXX"));
            Assert.AreEqual(4, e.MaxBlock("XX2222BBBbbXX2222"));
        }

        [TestMethod]
        public void MaxSpanTests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(4, e.MaxSpan(new int[] { 1, 2, 1, 1, 3 }));
            Assert.AreEqual(6, e.MaxSpan(new int[] { 1, 4, 2, 1, 4, 1, 4 }));
            Assert.AreEqual(6, e.MaxSpan(new int[] { 1, 4, 2, 1, 4, 4, 4 }));
            Assert.AreEqual(3, e.MaxSpan(new int[] { 3, 3, 3 }));
            Assert.AreEqual(3, e.MaxSpan(new int[] { 3, 9, 3 }));
            Assert.AreEqual(2, e.MaxSpan(new int[] { 3, 9, 9 }));
            Assert.AreEqual(1, e.MaxSpan(new int[] { 3, 9 }));
            Assert.AreEqual(2, e.MaxSpan(new int[] { 3, 3 }));
            Assert.AreEqual(0, e.MaxSpan(new int[] { }));
            Assert.AreEqual(1, e.MaxSpan(new int[] { 1 }));
        }

        [TestMethod]
        public void MixStartTests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.MixStart("mix snacks"));
            Assert.AreEqual(true, e.MixStart("pix snacks"));
            Assert.AreEqual(false, e.MixStart("piz snacks"));
            Assert.AreEqual(true, e.MixStart("nix"));
            Assert.AreEqual(false, e.MixStart("ni"));
            Assert.AreEqual(false, e.MixStart("n"));
            Assert.AreEqual(false, e.MixStart(""));
        }

        [TestMethod]
        public void More14Tests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.More14(new int[] { 1, 4, 1 }));
            Assert.AreEqual(false, e.More14(new int[] { 1, 4, 1, 4 }));
            Assert.AreEqual(true, e.More14(new int[] { 1, 1 }));
            Assert.AreEqual(true, e.More14(new int[] { 1 }));
            Assert.AreEqual(false, e.More14(new int[] { 1, 4 }));
            Assert.AreEqual(true, e.More14(new int[] { 6, 1, 1 }));
            Assert.AreEqual(false, e.More14(new int[] { 1, 6, 4 }));
            Assert.AreEqual(false, e.More14(new int[] { }));
            Assert.AreEqual(false, e.More14(new int[] { 4, 1, 4, 6 }));
            Assert.AreEqual(true, e.More14(new int[] { 1, 4, 1, 4, 1, 6 }));
        }

        [TestMethod]
        public void NoTriplesTests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.NoTriples(new int[] { 1, 1, 2, 2, 1 }));
            Assert.AreEqual(false, e.NoTriples(new int[] { 1, 1, 2, 2, 2, 1 }));
            Assert.AreEqual(false, e.NoTriples(new int[] { 1, 1, 2, 2, 2, 1 }));
            Assert.AreEqual(true, e.NoTriples(new int[] { 1, 2, 1 }));
            Assert.AreEqual(false, e.NoTriples(new int[] { 1, 1, 1 }));
            Assert.AreEqual(true, e.NoTriples(new int[] { 1, 1 }));
            Assert.AreEqual(true, e.NoTriples(new int[] { 1 }));
            Assert.AreEqual(true, e.NoTriples(new int[] { }));
        }

        [TestMethod]
        public void OneTwoTests()
        {
            Exercises e = new Exercises();

            Assert.AreEqual("bca", e.OneTwo("abc"));
            Assert.AreEqual("cat", e.OneTwo("tca"));
            Assert.AreEqual("catdog", e.OneTwo("tcagdo"));

            Assert.AreEqual("hocolctea", e.OneTwo("chocolate"));
            Assert.AreEqual("231564897", e.OneTwo("1234567890"));
            Assert.AreEqual("abxabxabxabxabxabxabx", e.OneTwo("xabxabxabxabxabxabxab"));
            Assert.AreEqual("bcaefd", e.OneTwo("abcdefx"));
            Assert.AreEqual("bcaefd", e.OneTwo("abcdefxy"));
            Assert.AreEqual("bcaefdyzx", e.OneTwo("abcdefxyz"));
            Assert.AreEqual("", e.OneTwo(""));
            Assert.AreEqual("", e.OneTwo("x"));
            Assert.AreEqual("", e.OneTwo("xy"));
            Assert.AreEqual("yzx", e.OneTwo("xyz"));
        }

        [TestMethod]
        public void RepeatSeparatorTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual("WordXWordXWord", e.RepeatSeparator("Word", "X", 3));
            Assert.AreEqual("ThisAndThis", e.RepeatSeparator("This", "And", 2));
            Assert.AreEqual("This", e.RepeatSeparator("This", "And", 1));
            Assert.AreEqual("Hi-n-Hi", e.RepeatSeparator("Hi", "-n-", 2));
            Assert.AreEqual("AAA", e.RepeatSeparator("AAA", "", 1));
            Assert.AreEqual("", e.RepeatSeparator("AAA", "", 0));
            Assert.AreEqual("ABABABABA", e.RepeatSeparator("A", "B", 5));
            Assert.AreEqual("abcXXabcXXabc", e.RepeatSeparator("abc", "XX", 3));
            Assert.AreEqual("abcXXabc", e.RepeatSeparator("abc", "XX", 2));
            Assert.AreEqual("abc", e.RepeatSeparator("abc", "XX", 1));
            Assert.AreEqual("XYZaXYZ", e.RepeatSeparator("XYZ", "a", 2));
        }

        [TestMethod]
        public void StringETest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.StringE("Hello"));
            Assert.AreEqual(true, e.StringE("Heelle"));
            Assert.AreEqual(false, e.StringE("Heelele"));
            Assert.AreEqual(false, e.StringE("Hll"));
            Assert.AreEqual(true, e.StringE("e"));
            Assert.AreEqual(false, e.StringE(""));
        }

        [TestMethod]
        public void StringMatchTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(3, e.StringMatch("xxcaazz", "xxbaaz"));
            Assert.AreEqual(2, e.StringMatch("abc", "abc"));
            Assert.AreEqual(0, e.StringMatch("abc", "axc"));
            Assert.AreEqual(1, e.StringMatch("hello", "he"));
            Assert.AreEqual(1, e.StringMatch("he", "hello"));
            Assert.AreEqual(0, e.StringMatch("h", "hello"));
            Assert.AreEqual(0, e.StringMatch("", "hello"));
            Assert.AreEqual(1, e.StringMatch("aabbccdd", "abbbxxd"));
            Assert.AreEqual(3, e.StringMatch("aaxxaaxx", "iaxxai"));
            Assert.AreEqual(3, e.StringMatch("iaxxai", "aaxxaaxx"));

        }

        [TestMethod]
        public void TripleUpTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual(true, e.TripleUp(new int[] { 1, 4, 5, 6, 2 }));
            Assert.AreEqual(true, e.TripleUp(new int[] { 1, 2, 3 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 1, 2, 4 }));
            Assert.AreEqual(true, e.TripleUp(new int[] { 1, 2, 4, 5, 7, 6, 5, 6, 7, 6 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 1, 2, 4, 5, 7, 6, 5, 7, 7, 6 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 1, 2 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 1 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { }));
            Assert.AreEqual(true, e.TripleUp(new int[] { 10, 9, 8, -100, -99, -98, 100 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 10, 9, 8, -100, -99, 99, 100 }));
            Assert.AreEqual(true, e.TripleUp(new int[] { -100, -99, -99, 100, 101, 102 }));
            Assert.AreEqual(false, e.TripleUp(new int[] { 2, 3, 5, 6, 8, 9, 2, 3 }));


        }

        [TestMethod]
        public void ZipZapTest()
        {
            Exercises e = new Exercises();

            Assert.AreEqual("zpXzp", e.ZipZap("zipXzap"));
            Assert.AreEqual("zpzp", e.ZipZap("zopzop"));
            Assert.AreEqual("zzzpzp", e.ZipZap("zzzopzop"));
            Assert.AreEqual("zibzp", e.ZipZap("zibzap"));
            Assert.AreEqual("zp", e.ZipZap("zip"));
            Assert.AreEqual("zi", e.ZipZap("zi"));
            Assert.AreEqual("z", e.ZipZap("z"));
            Assert.AreEqual("", e.ZipZap(""));
            Assert.AreEqual("zp", e.ZipZap("zzp"));
            Assert.AreEqual("abcppp", e.ZipZap("abcppp"));
            Assert.AreEqual("azbcppp", e.ZipZap("azbcppp"));
            Assert.AreEqual("azbcpzp", e.ZipZap("azbcpzpp"));

        }
    }
}