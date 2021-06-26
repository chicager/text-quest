package items;

import app.Lang;
import app.Player;

public class MasterKeys  extends Item{
    public MasterKeys(Lang l) {
        super(l);
        this.setName(l.getString("masterkeys"));
        this.setDevName("masterkeys");
        this.setMoveable(true);
        this.setAppliedTo("chest");
    }


    @Override
    public void use(Item item, Player p) {
        if(this.getAppliedTo().equals(item.getDevName())) {
            for(Item aimItem: p.getLocation().getInventory().getItems()) {
                if(aimItem.getDevName().equals("key")) {
                    p.getInventory().add(aimItem);
                    p.getLocation().getInventory().remove(aimItem);
                    p.getLocation().getInventory().remove(item);
                    p.getLocation().updateDescription();
                    System.out.printf("%s %s...\n", this.getL().getString("action_masterkeys"), aimItem.getName());
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