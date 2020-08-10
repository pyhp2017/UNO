package CardGame;

/**
 * This Class is for Graphic stuffs
 */
public class Graphic
{
    /**
     * Color Fields
     */
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BRIGHT_RED    = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN  = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE   = "\u001B[94m";
    public static final String ANSI_BRIGHT_WHITE  = "\u001B[97m";

    /**
     *This is menu for Single player game
     */
    public static void menu()
    {
        System.out.println("Welcome to SinglePlayerGame - Please Choose an Option ...");
        System.out.println("1 ) Start Three Player Game (2 Computer + You‌)");
        System.out.println("2 ) Start Four Player Game (3 Computer + You)");
        System.out.println("3 ) Start Five Player Game (4 Computer + You)");
        System.out.println("4 ) Exit");
        System.out.print("Please Select your Option: ");
    }

    /**
     * This is menu for MultiPlayer Game
     */
    public static void menuHuman()
    {
        System.out.println("Welcome to MultiPlayerGame - Please Choose an Option ...");
        System.out.println("1 ) Start Three Player Game");
        System.out.println("2 ) Start Four Player Game ");
        System.out.println("3 ) Start Five Player Game ");
        System.out.println("4 ) Exit");
        System.out.print("Please Select your Option: ");

    }

    /**
     * This is main Menu
     */
    public static void mainMenu()
    {
        System.out.println("\t\t\t\t WELCOME to UNO CARD GAME --- CODED BY Ahmad Foroughi 2020");
        System.out.println("\t\t\t\t 1) Single Player Game (BOT) ");
        System.out.println("\t\t\t\t 2) Multi Player Game (Friends) ");
        System.out.println("\t\t\t\t 3) EXIT ");
        System.out.print("Please Select your Option: ");

    }
}
