package items;

import app.Lang;

public class Intelligence extends Item{
    public Intelligence(Lang l) {
        super(l);
        this.setName(l.getString("intelligence"));
        this.setDevName("intelligence");
        this.setMoveable(true);
        this.setAppliedTo(null);
    }
}
