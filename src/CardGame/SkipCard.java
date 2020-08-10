package CardGame;

public class SkipCard extends MoveCard
{
    /**
     * Create a new Skip Card
     */
    public SkipCard(String color, int id)
    {
        super();
        setCardText("SKIP");
        setCardType("SkipCard");
        setColor(color);
        setCardID(id);
    }
}