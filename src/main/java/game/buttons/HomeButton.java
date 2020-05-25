package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;
import game.menus.StartMenu;

public class HomeButton extends Button {

    // Reference to main engine class
    private final Pathfinder main;

    public HomeButton(Pathfinder main, Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
        this.main = main;
    }

    @Override
    protected void buttonAction() {
        main.deleteAllGameOBjects();
        new StartMenu(main).loadButtons();
    }

    @Override
    public void update() {

    }
}
