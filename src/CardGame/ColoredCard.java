package CardGame;

/**
 * This Class Represents a Colored Card
 */
public class ColoredCard extends Card
{
    //Fields
    //Color Field
    protected String color;


    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public void drawCard()
    {
        switch (color)
        {
            case "RED":
                System.out.print(Graphic.ANSI_BRIGHT_RED);
                break;
            case "GREEN":
                System.out.print(Graphic.ANSI_BRIGHT_GREEN);
                break;
            case "YELLOW":
                System.out.print(Graphic.ANSI_BRIGHT_YELLOW);
                break;
            case "BLUE":
                System.out.print(Graphic.ANSI_BRIGHT_BLUE);
                break;
        }
        super.drawCard();
        System.out.print(Graphic.ANSI_RESET);
    }
}
