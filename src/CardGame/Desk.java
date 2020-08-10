package CardGame;

import java.awt.*;
import java.util.Random;

/**
 * This is a Desk in our game
 */
public class Desk
{
    //Current Card on the desk
    private Card current;
    //Current Card Color
    private String deskColor;

    public Desk(Repository repository)
    {
        Random random = new Random();
        while (true)
        {
            int randIndex = random.nextInt(repository.getRepositorySize());
            if (repository.cardsRep.get(randIndex) instanceof ColoredCard)
            {
                deskColor = ((ColoredCard) repository.cardsRep.get(randIndex)).color;
                setCurrent(repository.cardsRep.get(randIndex));
                repository.cardsRep.remove(randIndex);
                break;
            }
        }
    }

    public Card getCurrent()
    {
        return current;
    }

    public void setCurrent(Card current)
    {
        if (current instanceof ColoredCard)
        {
            setDeskColor(((ColoredCard) current).color);
            this.current = current;
        }
        else if (current instanceof WildCard)
        {
            setDeskColor(this.deskColor);
            this.current = current;
        }
    }

    public void drawDesk()
    {
        System.out.println("\n\n\t\t\t Current Card On the Table --- " + deskColor + "\n" );
        current.drawCard();
        System.out.print("\n\n\n");
    }

    public void setDeskColor(String deskColor) {
        this.deskColor = deskColor;
    }

    public String getDeskColor() {
        return deskColor;
    }
}
