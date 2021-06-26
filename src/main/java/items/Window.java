package items;

import app.Lang;

public class Window extends Item{
    public Window(Lang l) {
        super(l);
        this.setName(l.getString("window"));
        this.setDevName("window");
        this.setMoveable(false);
        this.setAppliedTo(null);
    }
}
