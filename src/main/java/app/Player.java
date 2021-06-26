package app;

import items.Item;
import locations.Location;
import java.util.Scanner;


public class Player {
    private Location location;
    private Inventory inventory;
    private Lang l;

    public Player(Lang l) {
        this.inventory = new Inventory();
        this.l = l;
    }

    public Location getLocation() {
        return location;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public void lookAround() {
        System.out.println(location.getDescription());
    }

    public void showInventory() {
        if(this.getInventory().getItems().size() == 0)
            System.out.println(l.getString("empty_inventory"));
        else
            this.getInventory().show();
    }

    public void updateLang() {
        for (Item item: inventory.getItems()) {
            item.setName(l.getString(item.getDevName()));
        }
    }

    public void go(Direction direction){
        if(this.getLocation().getDirections().containsKey(direction)) {
            if(this.getLocation().getDirections().get(direction).isLocked()) {
                for(Item item: this.getInventory().getItems()) {
                    if(item.getDevName().equals("key")) {
                        System.out.printf("%s\n", l.getString("apply_key"));
                        this.getInventory().remove(item);
                        this.getLocation().getDirections().get(direction).setLocked(false);
                        this.location = this.getLocation().getDirections().get(direction);
                        pressEnterKey(l);
                        return;
                    }
                }
                System.out.printf("%s\n", l.getString("error_locked"));
                pressEnterKey(l);
            }
            else
                this.location = this.getLocation().getDirections().get(direction);
        }
        else {
            System.out.printf("%s\n", l.getString("cant_go"));
            System.out.printf("\n%s", l.getString("press_enter"));
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }

    public void take(String obj) {
        for(Item item: this.getLocation().getInventory().getItems()) {
            if(obj.equals(item.getName())) {
                if(item.isMoveable()) {
                    this.getInventory().add(item);
                    this.getLocation().getInventory().remove(item);
                    this.getLocation().updateDescription();
                    System.out.printf("%s %s...\n", l.getString("took_msg"), obj);
                    this.pressEnterKey(l);
                    return;
                }
                else {
                    this.getLocation().getGame().showError(l.getString("error_no_movable"));
                    return;
                }
            }
        }
        this.getLocation().getGame().showError(l.getString("error_take"));
    }

    public void use(String[] objs) {
        if(objs.length == 2 && (objs[1].equals(l.getString("safe")) ||
                objs[1].equals(l.getString("radiotransmitter")))) {
            if(objs[1].equals(l.getString("radiotransmitter")) ||
                    objs[1].equals(l.getString("safe"))) {
                for(Item item: this.getLocation().getInventory().getItems()) {
                    if(item.getName().equals(objs[1])) {
                        item.use(null, this);
                        return;
                    }
                }
                this.getLocation().getGame().showError(l.getString("error_obj_location"));
                return;
            }
        }
        else if(objs.length > 3 && objs[2].equals(l.getString("on"))) {
            for(Item item: this.getInventory().getItems()) {
                if(item.getName().equals(objs[1])) {
                    for(Item item2: this.getLocation().getInventory().getItems()) {
                        if(item2.getName().equals(objs[3])) {
                            item.use(item2, this);
                            return;
                        }
                    }
                    this.getLocation().getGame().showError(l.getString("error_obj_location"));
                    return;
                }
            }
            this.getLocation().getGame().showError(l.getString("error_obj_inventory"));
        }
        else
            this.getLocation().getGame().showError(l.getString("error_use"));
    }

    private void pressEnterKey(Lang lang){
        System.out.printf("\n%s", lang.getString("press_enter"));
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
