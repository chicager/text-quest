package items;

import app.Lang;
import app.Player;

public class Rope extends Item{
    public Rope(Lang l) {
        super(l);
        this.setName(l.getString("rope"));
        this.setDevName("rope");
        this.setMoveable(true);
        this.setAppliedTo("window");
    }

    @Override
    public void use(Item item, Player p) {
        if(this.getAppliedTo().equals(item.getDevName())) {
            if(p.getLocation().getGame().isIntelligenceSent()) {
                System.out.println(this.getL().getString("end_game"));
                pressEnterKey(this.getL());
                System.exit(0);
            }
            else {
                System.out.println(this.getL().getString("action_rope_fail"));
            }
        }
        else
            System.out.println(this.getL().getString("error_incorrect_use"));

        pressEnterKey(this.getL());
    }
}
