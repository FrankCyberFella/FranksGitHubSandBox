using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CardGames.Cards;
using static CardGames.Cards.UnoCard;

namespace CardGames.Decks
{
    public class UnoDeck : Deck
    {
        protected override List<Card> BuildDeck()
        {
            List<Card> cards = new List<Card>();

            foreach(CardColor color in Enum.GetValues(typeof(CardColor)))
            {
                if (color != CardColor.Wild)
                {
                    foreach(CardValue value in Enum.GetValues(typeof(CardValue)))
                    {
                        switch (value)
                        {
                            case CardValue.One:
                            case CardValue.Two:
                            case CardValue.Three:
                            case CardValue.Four:
                            case CardValue.Five:
                            case CardValue.Six:
                            case CardValue.Seven:
                            case CardValue.Eight:
                            case CardValue.Nine:
                            case CardValue.Skip:
                            case CardValue.Reverse:
                            case CardValue.DrawTwo:
                                //Add two copies of each card 1-9, skip, reverse, and draw two
                                cards.Add(new UnoCard(color, value));
                                cards.Add(new UnoCard(color, value));
                                break;

                            case CardValue.Zero:
                                cards.Add(new UnoCard(color, value));
                                break;                                
                        }
                    }
                }
                else
                {
                    // Add four regular wild cardss
                    for (int i = 1; i <= 4; i++)
                    {
                        cards.Add(new UnoCard(color, CardValue.Wild));
                    }

                    for (int i = 1; i <= 4; i++)
                    {
                        cards.Add(new UnoCard(color, CardValue.DrawFour));
                    }
                }
            }

            return cards;
        }
    }
}
