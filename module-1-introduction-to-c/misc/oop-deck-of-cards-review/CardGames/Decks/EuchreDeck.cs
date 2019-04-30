using CardGames.Cards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Decks
{
    public class EuchreDeck : Deck
    {
        // A standard euchre deck is 9 -> K and Ace
        protected override List<Card> BuildDeck()
        {
            List<Card> cards = new List<Card>();

            string[] suits = Enum.GetNames(typeof(StandardCard.Suit));


            for (int i = 0; i < suits.Length; i++)
            {
                StandardCard.Suit suit = (StandardCard.Suit)Enum.Parse(typeof(StandardCard.Suit), suits[i]);

                for (int j = 9; j <= 13; j++)
                {
                    StandardCard.Rank rank = (StandardCard.Rank)j;
                    cards.Add(new StandardCard(rank, suit));    
                }

                cards.Add(new StandardCard(StandardCard.Rank.Ace, suit));
            }

            return cards;
        }
    }
}
