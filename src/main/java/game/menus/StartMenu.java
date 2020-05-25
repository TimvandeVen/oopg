package game.menus;

import engine.objects.Sprite;
import engine.objects.TextObject;
import game.Pathfinder;
import game.buttons.LevelButton;

public class StartMenu extends Menu {

    // Reference to main engine class
    private final Pathfinder main;

    public StartMenu(Pathfinder main) {
        super(main);
        this.main = main;

        loadButtons();
    }

    @Override
    protected void loadButtons() {
        String[] buttonText = {"easy", "medium", "hard"};
        for (int i = 0; i < buttonText.length; i++) {
            Sprite buttonSprite = new Sprite(Pathfinder.MEDIA_URL.concat(buttonText[i]).concat("Button.png"));
            main.addGameObject(new LevelButton(main, buttonSprite, 2, i), 630, 250 + (185 * i));
        }
    }
}