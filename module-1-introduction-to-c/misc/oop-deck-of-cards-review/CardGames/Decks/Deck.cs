using CardGames.Cards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Decks
{
    public abstract class Deck
    {
        private List<Card> cards;
        private const int NumberOfIterations = 1000;

        public bool HasCardsRemaining
        {
            get { return cards.Count > 0; }
        }

        public Deck()
        {
            cards = BuildDeck();
        }
        protected abstract List<Card> BuildDeck();

        public Card[] Draw(int amount)
        {
            if (amount > cards.Count)
            {
                amount = cards.Count;
            }

            Card[] drawCards = cards.GetRange(0, amount).ToArray();
            cards.RemoveRange(0, amount);

            return drawCards;
        }

        public void RemoveCard(Card cardToRemove)
        {
            cards.Remove(cardToRemove);
        }

        public void Shuffle()
        {
            Random r = new Random();

            for(int i = 0; i < NumberOfIterations; i++)
            {
                int randomSpot1 = r.Next(0, cards.Count - 1);
                int randomSpot2 = r.Next(0, cards.Count - 1);

                Card temp = cards[randomSpot1];
                cards[randomSpot1] = cards[randomSpot2];
                cards[randomSpot2] = temp;
            }
        }
    }
}
