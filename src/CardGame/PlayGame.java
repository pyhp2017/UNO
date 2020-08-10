package CardGame;

import java.util.Random;
import java.util.Scanner;

/**
 * PlayGame (Father)
 * @author Ahmad Foroughi
 * @version 2.0
 */
public class PlayGame
{
    
    /**
     * shuffle cards between players
     * @param repository is a repository
     * @param player is a player
     */
    protected static  void shuffle(Repository repository , Player player)
    {
        Random random = new Random();
        for (int i =0; i<7; i++)
        {
            while(true)
            {
                int randIndex = random.nextInt(repository.getRepositorySize());
                if (repository.cardsRep.get(randIndex) != null)
                {
                    player.addCardToUser(repository.cardsRep.get(randIndex));
                    repository.cardsRep.remove(randIndex);
                    break;
                }
            }
        }
    }

    /**
     * turn Method for each Player
     * @param player is a player
     * @param desk is desk
     * @param repository is a repository
     * @param round is a round
     */
    protected static void turn(Player player , Desk desk, Repository repository , String round)
    {
        Boolean flag = true;
        int countP = 0;
        while (flag)
        {
            desk.drawDesk();
            System.out.println("\t\t\tPlayer Cards");
            player.printCards();
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n\n" + player.getPlayerName()+ " Number: " + player.getPlayerNumberOfCards() + "--- Score: " + player.getPlayerScore() + " --- Please select a Card (" + round +")"  +" : ");
            int choosenId = scanner.nextInt();
            for (Card myCards: player.getPlayerCards())
            {
                if (myCards.getCardID() == choosenId)
                {
                    if (myCards instanceof NumberCard)
                    {
                        NumberCard temp = (NumberCard)myCards;
                        if (desk.getCurrent() instanceof NumberCard)
                        {
                            NumberCard tableTemp = (NumberCard)desk.getCurrent();
                            if (temp.getNumber() == tableTemp.getNumber() || temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    int index = random.nextInt(repository.getRepositorySize());
                                    player.addCardToUser(repository.cardsRep.get(index));
                                    repository.cardsRep.remove(index);
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }
                        }
                        else
                        {
                            if(temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    int index = random.nextInt(repository.getRepositorySize());
                                    player.addCardToUser(repository.cardsRep.get(index));
                                    repository.cardsRep.remove(index);
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }

                        }
                        break;
                    }

                    else if (myCards instanceof SkipCard)
                    {
                        SkipCard temp = (SkipCard)myCards;
                        if (desk.getCurrent() instanceof ColoredCard)
                        {
                            ColoredCard tableTemp = (ColoredCard) desk.getCurrent();
                            if (temp.cardType.equals(tableTemp.cardType) || temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }
                        }
                        else
                        {
                            if (temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }

                        }

                        break;
                    }

                    else if (myCards instanceof ReverseCard)
                    {
                        ReverseCard temp = (ReverseCard)myCards;
                        if (desk.getCurrent() instanceof ColoredCard)
                        {
                            ColoredCard tableTemp = (ColoredCard) desk.getCurrent();
                            if (temp.cardType.equals(tableTemp.cardType) || temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }
                        }
                        else
                        {
                            if (temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }

                        }

                        break;
                    }

                    else if (myCards instanceof Draw2)
                    {
                        Draw2 temp = (Draw2)myCards;
                        if (desk.getCurrent() instanceof ColoredCard)
                        {
                            ColoredCard tableTemp = (ColoredCard) desk.getCurrent();
                            if (temp.cardType.equals(tableTemp.cardType) || temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }
                        }
                        else
                        {
                            if (temp.getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(myCards,desk,repository);
                                flag = false;
                            }
                            else
                            {
                                countP++;
                                if (countP<2)
                                {
                                    //Player Can not put any
                                    //So he has to get a new Card and try again
                                    Random random = new Random();
                                    player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                                }
                                else
                                {
                                    flag = false;
                                    countP = 0;
                                }
                            }

                        }

                        break;
                    }

                    else if (myCards instanceof WildDraw)
                    {
                        if (!canPlay(player,desk))//If player could not play
                        {
                            System.out.println("1) RED 2)GREEN 3)BLUE 4)YELLOW\n");
                            System.out.print("Please Select Desk Color :");
                            int colorDeskOption = scanner.nextInt();
                            switch (colorDeskOption)
                            {
                                case 1:
                                    desk.setDeskColor("RED");
                                    break;
                                case 2:
                                    desk.setDeskColor("GREEN");
                                    break;
                                case 3:
                                    desk.setDeskColor("BLUE");
                                    break;
                                case 4:
                                    desk.setDeskColor("YELLOW");
                                    break;
                            }
                            player.putCardOnTheDesk(myCards,desk,repository);
                            flag = false;
                        }
                        break;
                    }
                    else if (myCards instanceof ColorWild)
                    {
                        if (!canPlay(player,desk))
                        {
                            System.out.println("1) RED 2)GREEN 3)BLUE 4)YELLOW\n");
                            System.out.print("Please Select Desk Color :");
                            int colorDeskOption = scanner.nextInt();
                            switch (colorDeskOption)
                            {
                                case 1:
                                    desk.setDeskColor("RED");
                                    break;
                                case 2:
                                    desk.setDeskColor("GREEN");
                                    break;
                                case 3:
                                    desk.setDeskColor("BLUE");
                                    break;
                                case 4:
                                    desk.setDeskColor("YELLOW");
                                    break;
                            }
                            player.putCardOnTheDesk(myCards,desk,repository);
                            flag = false;
                        }
                        break;
                    }

                }
            }

        }


    }

    /**
     * Create a new Player
     * @param n is number of player
     * @param players is an array of players
     * @param repository is a repository
     */
    protected static void createPlayer(int n , Player[] players , Repository repository)
    {
        for (int i = 0; i<n; i++)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please Select a Name for Player " + (i+1) + " : ");
            String playerName = scanner.next();
            players[i] = new Player(playerName);
            shuffle(repository,players[i]);
        }
    }

    /**
     * Change Player Turn
     * @param chooseRound --> 1 for clockwise and 2 for anti clockwise
     * @param startPlayerIndex is current player index
     * @param n is number of players
     * @return startPlayerIndex new
     */
    protected static int changeTurn(int chooseRound, int startPlayerIndex , int n)
    {
        if (chooseRound == 1)//ClockWise
        {
            if (startPlayerIndex == n-1)//Last
            {
                startPlayerIndex = 0;
                return startPlayerIndex;
            }
            else
            {
                startPlayerIndex++;
                return startPlayerIndex;
            }
        }
        else if (chooseRound == 2)//AntiClockWise
        {
            if (startPlayerIndex == 0)
            {
                startPlayerIndex = n-1;
                return startPlayerIndex;
            }
            else
            {
                startPlayerIndex--;
                return startPlayerIndex;
            }
        }
        return startPlayerIndex;
    }

    /**
     * can i put wild card ?
     * @param player is a player
     * @param desk is a desk
     * @return true or false
     */
    protected static boolean canPlay(Player player , Desk desk)
    {
        for (Card card : player.getPlayerCards())
        {
            if (card instanceof ColoredCard && desk.getCurrent() instanceof ColoredCard)
            {
                if (((ColoredCard) card).getColor().equals(desk.getDeskColor()) || card.getCardValue() == desk.getCurrent().getCardValue())
                {
                    return true;
                }
                else if (card instanceof MoveCard && desk.getCurrent() instanceof MoveCard)
                {
                    if (card.cardType.equals(desk.getCurrent().getCardType()))
                    {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     * Check end of the game
     * @param players is players array
     * @return true or false
     */
    protected static boolean checkEnd(Player[] players)
    {
        for (Player player: players)
        {
            if (player.getPlayerCards().size() == 0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * sort players by their score from low to high
     * @param players is players array
     */
    protected static void sortByScore(Player[] players)
    {
        int n = players.length;
        for (int i = 0; i<n-1 ; i++)
        {
            for (int j =0 ; j<n-i-1 ; j++)
            {
                if (players[j].getPlayerScore() > players[j+1].getPlayerScore())
                {
                    Player temp = players[j];
                    players[j] = players[j+1];
                    players[j+1] = temp;
                }
            }
        }
    }



}
