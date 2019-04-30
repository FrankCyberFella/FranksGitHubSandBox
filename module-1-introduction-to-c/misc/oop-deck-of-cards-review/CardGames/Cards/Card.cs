using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CardGames.Cards
{
    public abstract class Card
    {             
        private bool isFaceUp = true;
        public bool IsFaceUp
        {
            get { return this.isFaceUp; }
            set { this.isFaceUp = value; }
        }        

        public void Flip()
        {
            this.isFaceUp = !this.isFaceUp;
        }

        // Returns XX if the card is face down
        // Else returns GetDisplayValue() if its face up
        public sealed override string ToString()
        {
            if (!this.isFaceUp)
            {
                return "XX";
            }
            else
            {
                return this.GetDisplayValue();
            }
        }

        protected abstract string GetDisplayValue();

    }
}
