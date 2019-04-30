using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Cards
{
    public class UnoCard : Card
    {
        private CardColor color;
        public CardColor Color
        {
            get { return this.color; }
        }

        private CardValue value;
        public CardValue Value
        {
            get { return this.value; }
        }

        // Blue Reverse
        // Wild
        // Wild DrawFour
        // Red 9
        protected override string GetDisplayValue()
        {
            if (this.color == CardColor.Wild && this.value == CardValue.Wild)
            {
                return "Wild";
            }
            else if ((int)this.value >= (int)CardValue.Reverse)
            {
                return this.color.ToString() + " " + this.value.ToString();
            }
            else
            {
                return this.color.ToString() + " " + (int)this.value;
            }
        }

        public UnoCard(CardColor color, CardValue value)
        {
            this.color = color;
            this.value = value;
        }


        public enum CardColor
        {
            Red,
            Blue,
            Yellow,
            Green,
            Wild
        }

        public enum CardValue
        {
            Zero,
            One,
            Two,
            Three,
            Four,
            Five,
            Six,
            Seven,
            Eight,
            Nine,
            Reverse,
            Skip,
            DrawTwo,
            DrawFour,
            Wild
        }

        
    }
}
