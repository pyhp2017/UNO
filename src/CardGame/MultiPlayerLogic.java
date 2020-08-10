package CardGame;

import java.util.Random;
import java.util.Scanner;

/**
 * This class is for MultiPlayer Game Logic
 * @author Ahmad Foroughi
 * @version 2.0
 */
public class MultiPlayerLogic extends PlayGame
{
    public static void deskStart() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        Graphic.menuHuman();
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
    public static void circleTurn(int n)
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
            turn(players[startPlayerIndex] , desk,repository,roundForm);
            skipRound = true;
        }
    }


}