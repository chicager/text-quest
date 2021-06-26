package items;

import app.Lang;

public class Paper extends Item{
    public Paper(Lang l) {
        super(l);
        this.setName(l.getString("paper"));
        this.setDevName("paper");
        this.setMoveable(true);
        this.setAppliedTo(null);
    }
}
