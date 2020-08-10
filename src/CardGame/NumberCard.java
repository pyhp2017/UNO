package CardGame;

/**
 * This Class is for Number Card
 */
public class NumberCard extends ColoredCard
{
    //Fields
    //Number Field
    private int number;

    /**
     * Create a new Number Card
     */
    public NumberCard(int number , String color , int id)
    {
        this.number = number;
        setCardText(String.valueOf(number));
        setCardType("NumberCard");
        setColor(color);
        setCardValue(number);
        setCardID(id);
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }
}
