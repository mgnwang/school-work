import java.awt.Image;

/**
 * Draws a card in a 79x123 pixel rectangle with its
 * upper left corner at a specified point (x,y).  Drawing the card 
 * requires the image file "cards.png".
 * @param g The graphics context used for drawing the card.
 * @param card The card that is to be drawn.  If the value is null, then a
 * face-down card is drawn.
 * @param x the x-coord of the upper left corner of the card
 * @param y the y-coord of the upper left corner of the card
 */
public void drawCard(Graphics g, Card card, int x, int y) {
   int cx;    // x-coord of upper left corner of the card inside cardsImage
   int cy;    // y-coord of upper left corner of the card inside cardsImage
   if (card == null) {
      cy = 4*123;   // coords for a face-down card.
      cx = 2*79;
   }
   else {
      cx = (card.getValue()-1)*79;
      switch (card.getSuit()) {
      case Card.CLUBS:    
         cy = 0; 
         break;
      case Card.DIAMONDS: 
         cy = 123; 
         break;
      case Card.HEARTS:   
         cy = 2*123; 
         break;
      default:  // spades   
         cy = 3*123; 
         break;
      }
   }
   g.drawImage(cardImages,x,y,x+79,y+123,cx,cy,cx+79,cy+123,this);
}