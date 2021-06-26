package items;

import app.Lang;
import app.Player;
import java.util.Scanner;

public class RadioTransmitter extends Item{
    public RadioTransmitter(Lang l) {
        super(l);
        this.setName(l.getString("radiotransmitter"));
        this.setDevName("radiotransmitter");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }

    @Override
    public void use(Item item, Player p) {
        if(p.getLocation().getGame().isIntelligenceSent()) {
            System.out.printf("%s\n", this.getL().getString("action_already_sent"));
            pressEnterKey(this.getL());
            return;
        }
        System.out.printf("%s ", this.getL().getString("action_radiotransmitter_on"));
        Scanner scanner = new Scanner(System.in);
        try {
            String pass = scanner.nextLine();
            if(Integer.parseInt(pass) == 42) {
                for(Item i: p.getInventory().getItems()) {
                    if(i.getDevName().equals("intelligence")) {
                        System.out.printf("%s\n", this.getL().getString("action_sent"));
                        p.getLocation().getGame().setIntelligenceSent(true);
                        p.getInventory().remove(i);
                        for(Item j: p.getInventory().getItems()) {
                            if(j.getDevName().equals("flashlight"))
                                p.getInventory().remove(j);
                            break;
                        }
                        pressEnterKey(this.getL());
                        return;
                    }
                }
                System.out.printf("%s\n", this.getL().getString("error_no_intelligence"));
                pressEnterKey(this.getL());
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.printf("%s\n", this.getL().getString("error_pass"));
            pressEnterKey(this.getL());
        }
    }
}
