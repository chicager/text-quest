import app.Game;
import app.Lang;
import app.Menu;

public class Main {
    public static void main(String[] args) {
        Lang l = new Lang();
        l.setLang();

        Menu menu = new Menu();
        Game game = new Game(l, menu);

        menu.setGame(game);
        menu.showMenu(l);
    }
}
