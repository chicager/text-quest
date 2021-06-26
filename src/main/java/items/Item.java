package items;

import app.Lang;
import app.Player;
import java.util.Scanner;

public class Item {
    private Lang l;
    private String name;
    private String devName;
    private boolean isMoveable;
    private String appliedTo;

    public Item(Lang l) {
        this.l = l;
    }

    //region getters/setters
    public Lang getL() { return l; }
    public String getName() {
        return name;
    }
    public String getDevName() {
        return devName;
    }
    public boolean isMoveable() {
        return isMoveable;
    }
    public String getAppliedTo() {
        return appliedTo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public void setMoveable(boolean moveable) {
        isMoveable = moveable;
    }
    public void setAppliedTo(String appliedTo) {
        this.appliedTo = appliedTo;
    }
    //endregion

    public void pressEnterKey(Lang lang){
        System.out.printf("\n%s", lang.getString("press_enter"));
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void use(Item item, Player p) { return; };
}

