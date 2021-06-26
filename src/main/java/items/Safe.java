package items;

import app.Lang;
import app.Player;
import java.util.Scanner;

public class Safe extends Item{
    public Safe(Lang l) {
        super(l);
        this.setName(l.getString("safe"));
        this.setDevName("safe");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }

    @Override
    public void use(Item item, Player p) {
        System.out.printf("%s ", this.getL().getString("action_safe"));
        Scanner scanner = new Scanner(System.in);
        try {
            String pass = scanner.nextLine();
            if(Integer.parseInt(pass) == 1236) {
                for(Item i: p.getInventory().getItems()) {
                    if(i.getDevName().equals("paper")) {
                        p.getInventory().remove(i);
                        break;
                    }
                }
                System.out.printf("%s\n", this.getL().getString("action_safe_open"));
                for(Item i: p.getLocation().getInventory().getItems()) {
                    if(i.getDevName().equals("intelligence")) {
                        System.out.printf("%s %s...\n", this.getL().getString("took_msg"), i.getName());
                        p.getInventory().add(i);
                        p.getLocation().getInventory().remove(i);
                        break;
                    }
                }
                p.getLocation().getInventory().remove(this);
                p.getLocation().updateDescription();
                pressEnterKey(this.getL());
                return;
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.printf("%s\n", this.getL().getString("error_safe_pass"));
            pressEnterKey(this.getL());
        }
    }
}
