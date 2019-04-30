using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Cards
{
    public class StandardCard : Card
    {
        private const char Heart = '\u2665';
        private const char Spade = '\u2660';
        private const char Diamond = '\u2666';
        private const char Club = '\u2663';

        // Rank of the playing card
        private Rank cardRank;
        public Rank CardRank
        {
            get { return this.cardRank; }
        }

        // Suit of the playing card
        private Suit suit;
        public Suit CardSuit
        {
            get { return this.suit; }
        }

        public StandardCard(Rank rank, Suit suit)
        {
            this.cardRank = rank;
            this.suit = suit;
        }

        protected override string GetDisplayValue()
        {            
            Dictionary<Rank, string> specialRanks = new Dictionary<Rank, string>()
            {
                { Rank.Ace, "A" }, {Rank.Jack, "J" }, {Rank.Queen, "Q" }, {Rank.King, "K" }
            };
            Dictionary<Suit, char> suits = new Dictionary<Suit, char>()
            {
                { Suit.Club, Club }, {Suit.Diamond, Diamond }, {Suit.Heart, Heart }, {Suit.Spade, Spade }
            };

            string outputRank = "";
            char outputSuit = suits[this.suit];

            if (specialRanks.ContainsKey(this.cardRank))
            {
                outputRank = specialRanks[this.cardRank];
            }
            else
            {
                outputRank = ((int)this.cardRank).ToString();
            }

            return outputRank + outputSuit;
            
        }
    
        public enum Rank
        {
            Ace = 1,
            Two = 2,
            Three = 3,
            Four = 4,
            Five = 5,
            Six = 6,
            Seven = 7,
            Eight = 8,
            Nine = 9,
            Ten = 10,
            Jack = 11,
            Queen = 12,
            King = 13
        }

        public enum Suit
        {
            Spade,
            Club,
            Diamond,
            Heart
        }

        
    }
}
