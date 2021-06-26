package locations;

import app.Game;
import app.Lang;
import app.Menu;
import app.Player;
import items.Item;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocationsTest {
    private static Lang l;
    private static Player player;
    private static Menu menu;
    private static Game game;
    private static MainHall mainHall;
    private static BigRoom bigroom;
    private static Storeroom storeroom;
    private static RoomNumTwo roomNumTwo;

    @BeforeClass
    public static void init() {
        l = new Lang();
        l.setResources();
        player = new Player(l);
        menu = new Menu();
        game = new Game(l, menu);
        mainHall = new MainHall(l, player, game);
        bigroom = new BigRoom(l, player, game);
        storeroom = new Storeroom(l, player, game);
        roomNumTwo = new RoomNumTwo(l, player, game);
        mainHall.setDirections();
        bigroom.setDirections();
        storeroom.setDirections();
        roomNumTwo.setDirections();
        player.setLocation(mainHall);
    }

    @Test
    public void updatingMainHallDescription() { ;
        String currentDesc = mainHall.getDevDescription();
        for(Item item: mainHall.getInventory().getItems()) {
            if(item.getDevName().equals("hammer")) {
                mainHall.getInventory().remove(item);
                mainHall.updateDescription();
                break;
            }
        }
        Assert.assertNotEquals(currentDesc, mainHall.getDevDescription());
    }

    @Test
    public void updatingBigRoomDescription() { ;
        String currentDesc = bigroom.getDevDescription();
        for(Item item: bigroom.getInventory().getItems()) {
            if(item.getDevName().equals("vase")) {
                bigroom.getInventory().remove(item);
                bigroom.updateDescription();
                break;
            }
        }
        Assert.assertNotEquals(currentDesc, bigroom.getDevDescription());
    }

    @Test
    public void updatingStoreroomDescription() { ;
        String currentDesc = storeroom.getDevDescription();
        for(Item item: storeroom.getInventory().getItems()) {
            if(item.getDevName().equals("masterkeys")) {
                storeroom.getInventory().remove(item);
                storeroom.updateDescription();
                break;
            }
        }
        Assert.assertNotEquals(currentDesc, storeroom.getDevDescription());
    }

    @Test
    public void updatingRoomNumTwoDescription() { ;
        String currentDesc = roomNumTwo.getDevDescription();
        for(Item item: roomNumTwo.getInventory().getItems()) {
            if(item.getDevName().equals("rope")) {
                roomNumTwo.getInventory().remove(item);
                roomNumTwo.updateDescription();
                break;
            }
        }
        Assert.assertNotEquals(currentDesc, roomNumTwo.getDevDescription());
    }
}
