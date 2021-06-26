package items;

import app.Lang;
import app.Player;

public class Hammer extends Item {
    public Hammer(Lang l) {
        super(l);
        this.setName(l.getString("hammer"));
        this.setDevName("hammer");
        this.setMoveable(true);
        this.setAppliedTo("vase");
    }

    @Override
    public void use(Item item, Player p) {
        if(this.getAppliedTo().equals(item.getDevName())) {
            for(Item aimItem: p.getLocation().getInventory().getItems()) {
                if(aimItem.getDevName().equals("paper")) {
                    p.getInventory().add(aimItem);
                    p.getLocation().getInventory().remove(aimItem);
                    p.getLocation().getInventory().remove(item);
                    p.getLocation().updateDescription();
                    System.out.printf("%s %s...\n", this.getL().getString("action_hammer"), aimItem.getName());
                    System.out.printf("%s %s...\n", this.getL().getString("took_msg"), aimItem.getName());
                    pressEnterKey(this.getL());
                    p.getInventory().remove(this);
                    return;
                }
            }
        }
        else
            System.out.println(this.getL().getString("error_incorrect_use"));

        pressEnterKey(this.getL());
    }
}
