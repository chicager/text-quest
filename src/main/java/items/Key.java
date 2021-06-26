package items;

import app.Lang;
import app.Player;

public class Key extends Item{
    public Key(Lang l) {
        super(l);
        this.setName(l.getString("key"));
        this.setDevName("key");
        this.setMoveable(true);
        this.setAppliedTo(null);
    }

    @Override
    public void use(Item item, Player p) {
        System.out.println(this.getL().getString("error_incorrect_use"));
        pressEnterKey(this.getL());
    }
}
