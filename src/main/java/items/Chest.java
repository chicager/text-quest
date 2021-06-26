package items;

import app.Lang;

public class Chest extends Item{
    public Chest(Lang l) {
        super(l);
        this.setName(l.getString("chest"));
        this.setDevName("chest");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }
}
