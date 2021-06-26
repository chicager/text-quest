package app;

import java.util.Scanner;

public class Menu {
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void printHeader(String header) {
        System.out.println("================================");
        System.out.println(header);
        System.out.println("================================");
    }

    public void showMenu(Lang lang) {
        int choice = 0;
        while(true) {
            System.out.println();
            printHeader(lang.getString("main_menu").toUpperCase() + ":");
            if(game.isGameIsStarted())
                System.out.printf("%d: %s\n", 1, lang.getString("continue"));
            else
                System.out.printf("%d: %s\n", 1, lang.getString("new_game"));
            System.out.printf("%d: %s\n", 2, lang.getString("change_lang"));
            System.out.printf("%d: %s\n", 3, lang.getString("about"));
            System.out.printf("%d: %s\n", 4, lang.getString("exit_game"));
            System.out.printf("\n%s ", lang.getString("choice"));

            try {
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                if(choice < 1 || choice > 4)
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.out.printf("%s\n", lang.getString("error_choice"));
            }
        }
        choiceHandler(choice, lang);
    }

    private void choiceHandler(int choice, Lang lang) {
        switch (choice) {
            case 1:
                if(game.isGameIsStarted())
                    return;
                startGame();
                break;
            case 2:
                changeLang(lang);
                break;
            case 3:
                about(lang);
                break;
            case 4:
                System.exit(0);
        }
    }

    private void startGame() {
        System.out.println();
        game.startGame();
    }

    private void about(Lang lang) {
        System.out.println();
        printHeader(lang.getString("about").toUpperCase() + ":");
        System.out.printf("%s\n", lang.getString("about_game"));
        pressEnterKey(lang);
        showMenu(lang);
    }

    public void pressEnterKey(Lang lang){
        System.out.printf("\n%s", lang.getString("press_enter"));
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void changeLang(Lang lang) {
        System.out.println();
        lang.setLang();
        game.getPlayer().updateLang();
        game.getMainHall().updateLang();
        game.getBigroom().updateLang();
        game.getRoomNumTwo().updateLang();
        game.getStoreroom().updateLang();
        showMenu(lang);
    }
}
