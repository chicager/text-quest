package app;

import items.Flashlight;
import items.Hammer;
import locations.MainHall;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
    private static Lang l;
    private static Player player;
    private static Menu menu;
    private static Game game;
    private static MainHall mainHall;

    @BeforeClass
    public static void init() {
        l = new Lang();
        l.setResources();
        player = new Player(l);
        menu = new Menu();
        game = new Game(l, menu);
        mainHall = new MainHall(l, player, game);
        mainHall.setDirections();
        player.setLocation(mainHall);
    }

    @Test
    public void addingItemToInventory() {
        player.getInventory().add(new Hammer(l));
        player.getInventory().add(new Flashlight(l));
        Assert.assertEquals(2,  player.getInventory().getItems().size());
    }

    @Test
    public void testGo() {
        String currentLocation = player.getLocation().getDevName();
        player.go(Direction.RIGHT);
        Assert.assertNotEquals(currentLocation, player.getLocation().getDevName());
        currentLocation = player.getLocation().getDevName();
        player.go(Direction.BACK);
        Assert.assertNotEquals(currentLocation, player.getLocation().getDevName());
        currentLocation = player.getLocation().getDevName();
        player.go(Direction.LEFT);
        Assert.assertNotEquals(currentLocation, player.getLocation().getDevName());
    }
}
