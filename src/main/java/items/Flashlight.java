package items;

import app.Lang;
import app.Player;

public class Flashlight extends Item{
    public Flashlight(Lang l) {
        super(l);
        this.setName(l.getString("flashlight"));
        this.setDevName("flashlight");
        this.setMoveable(true);
        this.setAppliedTo("wall");
    }

    @Override
    public void use(Item item, Player p) {
        if(this.getAppliedTo().equals(item.getDevName())) {
            System.out.printf("%s\n", this.getL().getString("action_flashlight"));
        }
        else
            System.out.println(this.getL().getString("error_incorrect_use"));

        pressEnterKey(this.getL());
    }
}
