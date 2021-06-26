package app;

import items.Rope;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InventoryTest {
    private static Lang l;
    private static Inventory inventory;
    private static Rope rope;

    @BeforeClass
    public static void init() {
        inventory = new Inventory();
        l = new Lang();
        l.setResources();
        rope = new Rope(l);
    }

    @Test
    public void addingItemToInventory() {
       int currentSize = inventory.getItems().size();
       inventory.add(rope);
       Assert.assertNotEquals(currentSize, inventory.getItems().size());
    }

    @Test
    public void removingItemFromInventory() {
        inventory.add(rope);
        int currentSize = inventory.getItems().size();
        inventory.remove(rope);
        Assert.assertNotEquals(currentSize, inventory.getItems().size());
    }

    @Test
    public void removingIncorrectItem() {
        int currentSize = inventory.getItems().size();
        inventory.remove(rope);
        Assert.assertEquals(currentSize, inventory.getItems().size());
    }
}
