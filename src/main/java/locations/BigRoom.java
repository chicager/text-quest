package locations;

import app.Direction;
import app.Game;
import app.Lang;
import app.Player;
import items.*;


public class BigRoom extends Location {
    public BigRoom(Lang l, Player player, Game game) {
        super(l, player, game);
        this.setName(l.getString("big_room"));
        this.setDevName("big_room");
        this.setLocked(false);
        this.getInventory().add(new Vase(l));
        this.getInventory().add(new Chest(l));
        this.getInventory().add(new Paper(l));
        this.getInventory().add(new Key(l));
        this.updateDescription();
    }

    public void setDirections() {
        this.getDirections().put(Direction.BACK, this.getGame().getMainHall());
    }

    @Override
    public void updateDescription() {
        int size = this.getInventory().getItems().size();
        if(size == 4) {
            this.setDescription(this.getL().getString("bigroom_desc_1"));
            this.setDevDescription("bigroom_desc_1");
        }
        else if(size == 2) {
            for (Item item: this.getInventory().getItems()) {
                if(item.getDevName() == "chest") {
                    this.setDescription(this.getL().getString("bigroom_desc_2"));
                    this.setDevDescription("bigroom_desc_2");
                    break;
                }
                else {
                    this.setDescription(this.getL().getString("bigroom_desc_3"));
                    this.setDevDescription("bigroom_desc_3");
                    break;
                }
            }
        }
        else {
            this.setDescription(this.getL().getString("bigroom_desc_4"));
            this.setDevDescription("bigroom_desc_4");
        }
    }
}
