package CardGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * This class represent a Player
 */
public class Player
{
    //Player Name
    private String playerName;
    //Player Score
    private int playerScore;
    //List of Cards
    private ArrayList<Card> playerCards;

    /**
     * Create a new Player
     * @param playerName is a Player Name
     */
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.playerScore = 0;
        playerCards = new ArrayList<>();
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public int getPlayerScore() {
        int sum = 0;
        for (Card card : playerCards)
        {
            sum+= card.cardValue;
        }
        setPlayerScore(sum);
        return sum;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerScore(int playerScore) {

        this.playerScore = playerScore;
    }

    public void addCardToUser(Card card)
    {
        playerCards.add(card);
    }

    /**
     * Draw All Cards for Player
     */
    public void printCards()
    {
        for (Card card: playerCards)
        {
            card.drawCard();
        }
    }

    public void putCardOnTheDesk(Card card , Desk desk , Repository repository)
    {
        //Add Current card to repository
        repository.addCardToRep(desk.getCurrent());
        //Put in Desk or table
        desk.setCurrent(card);
        //Remove from Player List
        removeCardFromList(card);
    }

    public void removeCardFromList(Card card)
    {
        //Remove from Player List
        playerCards.removeIf(cardMove -> cardMove.getCardID() == card.getCardID());
    }

    public void addTwoRandomCard(Repository repository)
    {
        Random random = new Random();
        int index1 = random.nextInt(repository.getRepositorySize());
        playerCards.add(repository.cardsRep.get(index1));
        repository.cardsRep.remove(index1);

        int index2 = random.nextInt(repository.getRepositorySize());
        playerCards.add(repository.cardsRep.get(index2));
        repository.cardsRep.remove(index2);

    }

    public int getPlayerNumberOfCards()
    {
        return playerCards.size();
    }

}