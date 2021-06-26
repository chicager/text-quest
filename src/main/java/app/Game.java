package app;

import locations.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private Lang l;
    private Menu menu;
    private Player player;

    private MainHall mainHall;
    private BigRoom bigroom;
    private Storeroom storeroom;
    private RoomNumTwo roomNumTwo;

    private boolean isIntelligenceSent;
    private boolean gameIsStarted;

    public Game(Lang l, Menu menu) {
        this.l = l;
        this.menu = menu;
        this.gameIsStarted = false;
        this.isIntelligenceSent = false;
        player = new Player(l);
        mainHall = new MainHall(l, player, this);
        bigroom = new BigRoom(l, player, this);
        storeroom = new Storeroom(l, player, this);
        roomNumTwo = new RoomNumTwo(l, player, this);
        mainHall.setDirections();
        bigroom.setDirections();
        storeroom.setDirections();
        roomNumTwo.setDirections();
    }

    //region getters/setters
    public boolean isIntelligenceSent() { return isIntelligenceSent; }
    public boolean isGameIsStarted() {
        return gameIsStarted;
    }
    public Player getPlayer() { return player; }
    public MainHall getMainHall() {
        return mainHall;
    }
    public BigRoom getBigroom() {
        return bigroom;
    }
    public Storeroom getStoreroom() {
        return storeroom;
    }
    public RoomNumTwo getRoomNumTwo() {
        return roomNumTwo;
    }
    public void setIntelligenceSent(boolean intelligenceSent) { isIntelligenceSent = intelligenceSent; }
    //endregion

    public void startGame() {
        if(!gameIsStarted) {
            System.out.println(l.getString("start_game_msg"));
            menu.pressEnterKey(l);
            gameIsStarted = true;
            player.setLocation(mainHall);
        }
        playGame();
    }

    private void playGame() {
        while(true) {
            System.out.println();
            menu.printHeader(l.getString(player.getLocation().getDevName()));
            System.out.printf("%d: %s\n", 1, l.getString("look_around"));
            System.out.printf("%d: %s\n", 2, l.getString("show_inventory"));
            System.out.printf("%d: %s\n", 3, l.getString("help"));
            System.out.printf("%d: %s\n", 4, l.getString("main_menu"));
            System.out.println();
            player.lookAround();

            System.out.printf("\n%s ", l.getString("enter_command"));
            Scanner sc = new Scanner(System.in);
            try {
                String cmd = sc.nextLine();
                if (cmd.length() == 1) {
                    int choice = Integer.parseInt(cmd);

                    switch (choice) {
                        case 1:
                            continue;
                        case 2:
                            System.out.println();
                            menu.printHeader(l.getString("inventory"));
                            player.showInventory();
                            menu.pressEnterKey(l);
                            continue;
                        case 3:
                            System.out.println();
                            menu.printHeader(l.getString("help") + ":");
                            System.out.println(l.getString("help_msg"));
                            menu.pressEnterKey(l);
                            continue;
                        case 4:
                            menu.showMenu(l);
                            continue;
                        default:
                            throw new InputMismatchException();
                    }
                } else
                    parseCommand(cmd);
            } catch (Exception e) {
                showError(l.getString("error_command"));
            }
        }
    }

    private void parseCommand(String cmd) {
        String[] parts = cmd.trim().toLowerCase().split("\\P{L}+");

        if (parts[0].equals(l.getString("go")))
            handleGoCommand(parts);
        else if (parts[0].equals(l.getString("take")))
            handleTakeCommand(parts);
        else if (parts[0].equals(l.getString("use")))
            handleUseCommand(parts);
        else
            showError(l.getString("error_command"));
    }

    private void handleUseCommand(String[] parts) {
        player.use(parts);
    }

    private void handleTakeCommand(String[] parts) {
        if(parts.length > 1)
            player.take(parts[1]);
        else
            showError(l.getString("error_take"));
    }

    private void handleGoCommand(String[] parts) {
        if(parts.length > 1) {
            if (parts[1].equals(l.getString("left")))
                player.go(Direction.LEFT);
            else if (parts[1].equals(l.getString("right")))
                player.go(Direction.RIGHT);
            else if (parts[1].equals(l.getString("straight")))
                player.go(Direction.STRAIGHT);
            else if (parts[1].equals(l.getString("back")))
                player.go(Direction.BACK);
            else
                showError(l.getString("error_go"));
        }
        else
            showError(l.getString("error_go"));
    }

    public void showError(String err) {
        System.out.printf("%s\n", err);
        menu.pressEnterKey(l);
    }
}
