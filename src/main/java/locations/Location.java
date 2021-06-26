package locations;

import app.*;
import items.Item;
import java.util.HashMap;

public class Location {
    private Lang l;
    private String name;
    private String devName;
    private String description;
    private String devDescription;
    private boolean isLocked;
    private Inventory inventory;
    private Player player;
    private Game game;
    private HashMap<Direction, Location> directions;

    public Location(Lang l, Player player, Game game) {
        this.l = l;
        this.player = player;
        this.game = game;
        this.inventory = new Inventory();
        this.directions = new HashMap<>();
    }

    //region getters/setters
    public boolean isLocked() { return isLocked; }
    public Lang getL() {
        return l;
    }
    public String getName() {
        return name;
    }
    public String getDevName() {
        return devName;
    }
    public String getDescription() {
        return description;
    }
    public String getDevDescription() { return devDescription; }
    public Inventory getInventory() {
        return inventory;
    }
    public Player getPlayer() {
        return player;
    }
    public Game getGame() {
        return game;
    }
    public HashMap<Direction, Location> getDirections() {
        return directions;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDevDescription(String devDescription) { this.devDescription = devDescription; }
    public void setName(String name) {
        this.name = name;
    }
    public void setDevName(String devName) {
        this.devName = devName;
    }
    public void setLocked(boolean locked) { isLocked = locked; }
    //endregion

    public void updateDescription() { return; }

    public void updateLang() {
        this.setName(this.getL().getString(this.getDevName()));
        for (Item item: this.getInventory().getItems()) {
            item.setName(this.getL().getString(item.getDevName()));
        }
        this.setDescription(this.getL().getString(this.getDevDescription()));
    }
}
