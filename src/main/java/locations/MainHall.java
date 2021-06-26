package locations;

import app.Direction;
import app.Game;
import app.Player;
import items.Flashlight;
import items.Hammer;
import app.Lang;
import items.Item;
import items.Window;

public class MainHall extends Location {
    public MainHall(Lang l, Player player, Game game) {
        super(l, player, game);
        this.setName(l.getString("hall"));
        this.setDevName("hall");
        this.setLocked(false);
        this.getInventory().add(new Hammer(l));
        this.getInventory().add(new Flashlight(l));
        this.getInventory().add(new Window(l));
        this.updateDescription();
    }

    public void setDirections() {
        this.getDirections().put(Direction.STRAIGHT, this.getGame().getRoomNumTwo());
        this.getDirections().put(Direction.LEFT, this.getGame().getBigroom());
        this.getDirections().put(Direction.RIGHT, this.getGame().getStoreroom());
    }

    @Override
    public void updateDescription() {
        int size = this.getInventory().getItems().size();
        if(size == 3) {
            this.setDescription(this.getL().getString("hall_desc_1"));
            this.setDevDescription("hall_desc_1");
        }
        else if(size == 2) {
            for (Item item: this.getInventory().getItems()) {
                if(item.getDevName() == "hammer") {
                    this.setDescription(this.getL().getString("hall_desc_2"));
                    this.setDevDescription("hall_desc_2");
                    break;
                }
                else {
                    this.setDescription(this.getL().getString("hall_desc_3"));
                    this.setDevDescription("hall_desc_3");
                    break;
                }
            }
        }
        else {
            this.setDescription(this.getL().getString("hall_desc_4"));
            this.setDevDescription("hall_desc_4");
        }
    }
}
