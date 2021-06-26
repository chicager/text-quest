package items;

import app.Lang;

public class Vase extends Item{
    public Vase(Lang l) {
        super(l);
        this.setName(l.getString("vase"));
        this.setDevName("vase");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }
}
