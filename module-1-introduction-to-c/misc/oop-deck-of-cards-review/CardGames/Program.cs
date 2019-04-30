using CardGames.Cards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CardGames.Decks;

namespace CardGames
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.OutputEncoding = Encoding.UTF8;

            EuchreDeck deck = new EuchreDeck();
            deck.Shuffle();
            while (deck.HasCardsRemaining)
            {
                Console.WriteLine(deck.Draw(1)[0]);
            }
            
        }
    }

   
}
