package CardGame;

import java.util.ArrayList;

/**
 * This Class Holds All Cards
 */
public class Repository
{
    //Fields
    public ArrayList<Card> cardsRep;

    /**
     * Create a new Repository
     */
    public Repository()
    {
        cardsRep = new ArrayList<>();
        String[] colors = {"RED","YELLOW","GREEN","BLUE"};
        //We have 108 Cards in our Rep in the begging
        int idCount = 0;
//        Creating NumberCards
        for (int i = 0; i<4 ; i++)//For Colors
        {
            for (int j=0 ; j<10 ; j++)//ForNumbers
            {
                cardsRep.add(new NumberCard(j,colors[i],idCount));
                idCount++;
                if (j!=0)
                {
                    cardsRep.add(new NumberCard(j,colors[i],idCount));
                    idCount++;
                }
            }
        }

        //Creating MoveCards
        for (int i =0 ; i <4 ; i++)
        {
            cardsRep.add(new SkipCard(colors[i], idCount));
            idCount++;
            cardsRep.add(new SkipCard(colors[i] , idCount));
            idCount++;
            cardsRep.add(new ReverseCard(colors[i] , idCount));
            idCount++;
            cardsRep.add(new ReverseCard(colors[i] , idCount));
            idCount++;
            cardsRep.add(new Draw2(colors[i] ,idCount));
            idCount++;
            cardsRep.add(new Draw2(colors[i] , idCount));
            idCount++;
        }
//
//        //Creating WildCards
        for(int i =0; i<4; i++)
        {
            cardsRep.add(new WildDraw(idCount));
            idCount++;
            cardsRep.add(new ColorWild(idCount));
            idCount++;
        }

    }

    public void printAllCards()
    {
        for (Card card: cardsRep)
        {
            card.drawCard();
        }
    }

    public int getRepositorySize()
    {
        return cardsRep.size();
    }

    public void addCardToRep(Card card)
    {
        cardsRep.add(card);
    }

}