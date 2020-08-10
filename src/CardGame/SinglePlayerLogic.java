package CardGame;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is for single player logic
 * @author Ahmad Foroughi
 * @version 2.0
 */
public class SinglePlayerLogic extends PlayGame
{

    /**
     * Start Game
     */
    public static void deskStart() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        Graphic.menu();
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                //Three Players Game
                circleTurn(3);
                break;
            case 2:
                //Four Players Game
                circleTurn(4);
                break;
            case 3:
                //Five Players Game
                circleTurn(5);
                break;

            case 4:
                //Exit
                System.exit(0);
                break;
        }


    }

    /**
     * Move around players
     * @param n is number of players
     */
    public static void circleTurn(int n) throws InterruptedException
    {
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Player[] players;
        Desk desk;
        players = new Player[n];
        createPlayer(n,players,repository);
        desk = new Desk(repository);
        int startPlayerIndex = random.nextInt(players.length);
        int humanPlayerIndex = startPlayerIndex;
        boolean skipRound = true;
        String roundForm = "ClockWise";
        while (true)
        {
            //Check Games end
            if (checkEnd(players) || repository.cardsRep.size() == 0)
            {
                sortByScore(players);
                System.out.println("# | Player Name | SCORE");
                System.out.println("------------------------");
                for (int i =0 ; i<players.length ; i++)
                {
                    System.out.println(i+1+" | " + players[i].getPlayerName() + " | " + players[i].getPlayerScore());
                }

                System.out.println("Games END");
                System.exit(1);
            }

            if (desk.getCurrent() instanceof ReverseCard)
            {
                System.out.println("REVERSE");
                if (roundForm.equals("ClockWise"))
                {
                    roundForm = "AntiClockWise";
                }
                else
                {
                    roundForm = "ClockWise";
                }

            }
            if (desk.getCurrent() instanceof WildDraw && skipRound)
            {
                System.out.println("DRAW IV");
                if (roundForm.equals("ClockWise"))
                {
                    startPlayerIndex = changeTurn(1,startPlayerIndex,n);
                }
                else
                {
                    startPlayerIndex = changeTurn(2,startPlayerIndex,n);
                }
                players[startPlayerIndex].addTwoRandomCard(repository);
                players[startPlayerIndex].addTwoRandomCard(repository);
                skipRound = false;
                continue;
            }
            if (desk.getCurrent() instanceof ColorWild)
            {
                System.out.println("COLOR WILD");
            }
            if (desk.getCurrent() instanceof Draw2 && skipRound)
            {
                System.out.println("DRAW II");
                if (roundForm.equals("ClockWise"))
                {
                    startPlayerIndex = changeTurn(1,startPlayerIndex,n);
                }
                else
                {
                    startPlayerIndex = changeTurn(2,startPlayerIndex,n);
                }
                players[startPlayerIndex].addTwoRandomCard(repository);
                skipRound = false;
                continue;
            }
            if (desk.getCurrent() instanceof SkipCard && skipRound) //Skip Round
            {
                System.out.println("SKIP");
                if (roundForm.equals("ClockWise"))
                {
                    startPlayerIndex = changeTurn(1,startPlayerIndex,n);
                }
                else
                {
                    startPlayerIndex = changeTurn(2,startPlayerIndex,n);
                }
                skipRound = false;
                continue;
            }

            if (roundForm.equals("ClockWise"))
            {
                startPlayerIndex = changeTurn(1,startPlayerIndex,n);
            }
            else
            {
                startPlayerIndex = changeTurn(2,startPlayerIndex,n);
            }
            if (startPlayerIndex == humanPlayerIndex)//Human Player Turn
            {
                turn(players[startPlayerIndex] , desk,repository,roundForm);
                System.out.println("HUMAN");
            }
            else //Computer Player Turn
            {
                turnComputer(players[startPlayerIndex] , desk,repository,roundForm);
                System.out.println("COMPUTER");
            }

            skipRound = true;

        }
    }

    /**
     * Computer Turn (LOGIC and AI)
     * @param player is a player
     * @param desk is a desk
     * @param repository is a repository
     * @param round is a round(Clockwise or AntiCLockWise)
     * @throws InterruptedException for Thread.Sleep
     */
    public static void turnComputer(Player player , Desk desk, Repository repository , String round) throws InterruptedException {
        Random random = new Random();
        boolean flagChoose = true;
        boolean skip = true;
        boolean ColorTrue = false;
        boolean WildTrue = false;
        int countP = 1;
        while (flagChoose)
        {
            desk.drawDesk();
            System.out.println("\t\t\tPlayer Cards");
            player.printCards();
            System.out.print("\n\n" + player.getPlayerName()+ " Number: " + player.getPlayerNumberOfCards() + "--- Score: " + player.getPlayerScore() + " ---  (" + round +")"  +" -- COMPUTER is Thinking ");
            Thread.sleep(10000);

            if (desk.getCurrent() instanceof ColoredCard)
            {
                for (Card card: player.getPlayerCards())
                {
                    //A number card on a number card
                    if (card instanceof NumberCard && desk.getCurrent() instanceof NumberCard)
                    {
                        if (((NumberCard) card).getColor().equals(desk.getDeskColor()) || card.getCardValue() == desk.getCurrent().getCardValue())
                        {
                            player.putCardOnTheDesk(card,desk,repository);
                            flagChoose = false;
                            ColorTrue = false;
                            break;
                        }
                    }

                    //a number card on a move card
                    if (card instanceof NumberCard && desk.getCurrent() instanceof MoveCard)
                    {
                        if (((NumberCard) card).getColor().equals(desk.getDeskColor()))
                        {
                            player.putCardOnTheDesk(card,desk,repository);
                            flagChoose = false;
                            ColorTrue = false;
                            break;
                        }
                    }

                    //a move card on a move card
                    if(card instanceof MoveCard && desk.getCurrent() instanceof  MoveCard)
                    {
                        if (((MoveCard) card).getColor().equals(desk.getDeskColor()) || card.getCardType().equals(desk.getCurrent().getCardType()))
                        {
                            player.putCardOnTheDesk(card,desk,repository);
                            flagChoose = false;
                            ColorTrue = false;
                            break;
                        }
                    }

                    //a move card on number card
                    if (card instanceof MoveCard && desk.getCurrent() instanceof NumberCard)
                    {
                        if (((MoveCard) card).getColor().equals(desk.getDeskColor()))
                        {
                            player.putCardOnTheDesk(card,desk,repository);
                            flagChoose = false;
                            ColorTrue = false;
                            break;

                        }
                    }

                    ColorTrue = true;
                }
                if (ColorTrue)
                {
                    if (desk.getCurrent() instanceof ColoredCard)
                    {
                        for (Card card: player.getPlayerCards())
                        {
                            if (card instanceof WildCard)
                            {
                                int colorDeskOption = random.nextInt(4);
                                switch (colorDeskOption)
                                {
                                    case 0:
                                        desk.setDeskColor("RED");
                                        break;
                                    case 1:
                                        desk.setDeskColor("GREEN");
                                        break;
                                    case 2:
                                        desk.setDeskColor("BLUE");
                                        break;
                                    case 3:
                                        desk.setDeskColor("YELLOW");
                                        break;
                                }
                                player.putCardOnTheDesk(card,desk,repository);
                                flagChoose = false;
                                ColorTrue = false;
                                break;

                            }
                        }
                    }
                }

            }
            else if (desk.getCurrent() instanceof WildCard)
            {
                for (Card card: player.getPlayerCards())
                {
                    //a colored card on a colored card(Only check base on color
                    if (card instanceof ColoredCard)
                    {
                        if (((ColoredCard) card).getColor().equals(desk.getDeskColor()))
                        {
                            player.putCardOnTheDesk(card,desk,repository);
                            flagChoose = false;
                            WildTrue = false;
                            break;
                        }
                    }
                    WildTrue = true;
                }

                if (WildTrue)
                {
                    for (Card card: player.getPlayerCards())
                    {
                        if (card instanceof ColoredCard)
                        {
                            if (((ColoredCard) card).getColor().equals(desk.getDeskColor()))
                            {
                                player.putCardOnTheDesk(card,desk,repository);
                                flagChoose = false;
                                WildTrue = false;
                                break;

                            }
                        }
                    }
                }
            }

            //Check if there is no Move for player
            if (flagChoose && countP<2)
            {
                //Add a Card From Repository to player card list
                System.out.println("Generate new card");
                player.addCardToUser(repository.cardsRep.get(random.nextInt(repository.getRepositorySize())));
                countP++;
            }
            else
            {
                flagChoose = false;
                countP = 0;
            }

        }

    }


}
