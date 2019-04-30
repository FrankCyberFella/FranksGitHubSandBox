using CardGames.Cards;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Decks
{
    public sealed class StandardDeck : Deck
    {
        protected override List<Card> BuildDeck()
        {
            List<Card> cards = new List<Card>();

            // Get all possible ranks & suits
            string[] ranks = Enum.GetNames(typeof(StandardCard.Rank));
            string[] suits = Enum.GetNames(typeof(StandardCard.Suit));

            for(int i= 0; i < ranks.Length; i++)
            {
                for(int j = 0; j < suits.Length; j++)
                {
                    StandardCard.Rank rank = (StandardCard.Rank)Enum.Parse(typeof(StandardCard.Rank), ranks[i]);
                    StandardCard.Suit suit = (StandardCard.Suit)Enum.Parse(typeof(StandardCard.Suit), suits[j]);
                    cards.Add(new StandardCard(rank, suit));
                }
            }

            return cards;
        }
    }
}
