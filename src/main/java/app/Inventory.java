package app;

import items.Item;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() { return items; }

    public void add(Item item){
        items.add(item);
    }

    public void remove(Item toDelete) {
        String name = toDelete.getName().toLowerCase();
        for (Item item: items) {
            if (item.getName().toLowerCase().equals(name)) {
                items.remove(item);
                break;
            }
        }
    }

    public void show() {
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d: %s\n", (i + 1), items.get(i).getName());
        }
    }
}
