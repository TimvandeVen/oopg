package game.menus;

import engine.objects.TextObject;
import game.Pathfinder;

public abstract class Menu {

    public Menu(Pathfinder main) {
        // Create and add Title
        TextObject title = new TextObject("Pathfinder", 80);
        title.setForeColor(255, 255, 255, 255);
        main.addGameObject(title, 600, 40);
    }

    public abstract void loadButtons();

}
