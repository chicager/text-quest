package items;

import app.Lang;

public class Wall extends Item{
    public Wall(Lang l) {
        super(l);
        this.setName(l.getString("wall"));
        this.setDevName("wall");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }
}
