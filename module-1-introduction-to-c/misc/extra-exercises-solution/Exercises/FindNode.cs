using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public partial class Exercises
    {
        /*
        CHALLENGE: Write the algorithm to find and return the given node based on its value, n. 
        If the node cannot be found, return null.

        */
        public LinkedListNode<int> FindNode(LinkedList<int> nodes, int n)
        {
            for (var recentNode = nodes.First; recentNode != null; recentNode = recentNode.Next)
            {
                var val = recentNode.Value;
                if (val == n)
                {
                    return recentNode;
                }
            }
            return null;
        }
    }
}
