package locations;

import app.Direction;
import app.Game;
import app.Lang;
import app.Player;
import items.*;

public class RoomNumTwo extends Location{
    public RoomNumTwo(Lang l, Player player, Game game) {
        super(l, player, game);
        this.setName(l.getString("room_two"));
        this.setDevName("room_two");
        this.setLocked(true);
        this.getInventory().add(new Safe(l));
        this.getInventory().add(new Rope(l));
        this.getInventory().add(new Wall(l));
        this.getInventory().add(new Intelligence(l));
        this.updateDescription();
    }

    public void setDirections() {
        this.getDirections().put(Direction.BACK, this.getGame().getMainHall());
    }

    @Override
    public void updateDescription() {
        int size = this.getInventory().getItems().size();
        if(size == 4) {
            this.setDescription(this.getL().getString("room_two_desc_1"));
            this.setDevDescription("room_two_desc_1");
        }
        else if(size < 4 && size > 1) {
            for (Item item: this.getInventory().getItems()) {
                if(item.getDevName() == "rope") {
                    this.setDescription(this.getL().getString("room_two_desc_2"));
                    this.setDevDescription("room_two_desc_2");
                    break;
                }
                else {
                    this.setDescription(this.getL().getString("room_two_desc_3"));
                    this.setDevDescription("room_two_desc_3");
                    break;
                }
            }
        }
        else {
            this.setDescription(this.getL().getString("room_two_desc_4"));
            this.setDevDescription("room_two_desc_4");
        }
    }
}
