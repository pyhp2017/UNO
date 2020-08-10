package CardGame;

public class WildDraw extends WildCard
{
    /**
     * Create a new Wild Draw
     */
    public WildDraw(int id)
    {
        super();
        setCardText("WILD +4");
        setCardType("WildDraw");
        setCardID(id);
    }
}
