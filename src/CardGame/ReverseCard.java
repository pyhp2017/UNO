package CardGame;

public class ReverseCard extends MoveCard
{
    /**
     * Create a new Reverse Card
     */
    public ReverseCard(String color , int id)
    {
        super();
        setCardText("REVERSE");
        setCardType("ReverseCard");
        setColor(color);
        setCardID(id);
    }
}
