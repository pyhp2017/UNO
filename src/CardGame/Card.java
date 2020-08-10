package CardGame;

import java.util.Objects;

/**
 * This Class Represent a Card
 */
public class Card
{
    //Fields
    //Card Model or type
    protected String cardType;
    //Card Text
    protected String cardText;
    //Card Value
    protected int cardValue;
    //Card ID
    protected int cardID;

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getCardText()
    {
        return cardText;
    }

    public void setCardText(String cardText)
    {
        this.cardText = cardText;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getCardID() {
        return cardID;
    }

    /**
     * Draw Card
     */
    public void drawCard()
    {
        System.out.println("\t\t\t\t\t|$$$$$$$$$$$$$$$|");
        System.out.println("\t\t\t\t\t|               |");
        System.out.printf ("\t\t\t\t\t     %s       \n",cardText);
        System.out.println("\t\t\t\t\t|               |");
        System.out.println("\t\t\t\t\t|$$$$$$$$$$$$$$$|=== id : " + cardID);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return cardValue == card.cardValue &&
                cardID == card.cardID &&
                Objects.equals(cardType, card.cardType) &&
                Objects.equals(cardText, card.cardText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardText, cardValue, cardID);
    }
}
