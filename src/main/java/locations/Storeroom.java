package locations;

import app.Direction;
import app.Game;
import app.Lang;
import app.Player;
import items.*;

public class Storeroom extends Location{
    public Storeroom(Lang l, Player player, Game game) {
        super(l, player, game);
        this.setName(l.getString("storeroom"));
        this.setDevName("storeroom");
        this.setLocked(false);
        this.getInventory().add(new RadioTransmitter(l));
        this.getInventory().add(new MasterKeys(l));
        this.updateDescription();
    }

    public void setDirections() {
        this.getDirections().put(Direction.BACK, this.getGame().getMainHall());
    }

    @Override
    public void updateDescription() {
        int size = this.getInventory().getItems().size();
        if(size == 2) {
            this.setDescription(this.getL().getString("storeroom_desc_1"));
            this.setDevDescription("storeroom_desc_1");
        }
        else if(size == 1) {
            this.setDescription(this.getL().getString("storeroom_desc_2"));
            this.setDevDescription("storeroom_desc_2");
        }
        else {
            this.setDescription(this.getL().getString("storeroom_desc_3"));
            this.setDevDescription("storeroom_desc_3");
        }
    }
}
