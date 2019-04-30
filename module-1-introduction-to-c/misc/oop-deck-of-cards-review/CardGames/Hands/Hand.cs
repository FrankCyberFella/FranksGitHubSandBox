using CardGames.Cards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Hands
{
    public class Hand
    {
        private List<Card> cards = new List<Card>();

        public Card[] Cards
        {
            get { return this.cards.ToArray(); }
        }

        public void AddToHand(Card c)
        {
            cards.Add(c);
        }

        public void RemoveFromHand(Card c)
        {
            cards.Remove(c);
        }
    }
}
