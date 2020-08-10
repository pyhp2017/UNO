package CardGame;

import java.util.Scanner;


/**
 * This is Main Class
 * @author Ahmad Foroughi
 * @version 2.0
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Graphic.mainMenu();
        int Option = scanner.nextInt();
        switch (Option)
        {
            case 1:
                //Single Player
                SinglePlayerLogic.deskStart();
                break;
            case 2:
                //Multi Player
                MultiPlayerLogic.deskStart();
                break;
            case 3:
                //Exit
                System.exit(0);
                break;
        }

    }


}
