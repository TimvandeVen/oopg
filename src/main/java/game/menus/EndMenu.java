package game.menus;

import engine.objects.Sprite;
import game.Pathfinder;
import game.buttons.HomeButton;
import game.buttons.LevelButton;
import game.buttons.RetryButton;

public class EndMenu extends Menu {

    // Reference to main engine class
    private final Pathfinder main;

    public EndMenu(Pathfinder main) {
        super(main);
        this.main = main;
    }

    public void loadState() {
        if (main.levelComplete) {
            System.out.println("Win");
        } else if (main.levelFailed) {
            System.out.println("Loss");
        }
    }

    @Override
    public void loadButtons() {
        main.addGameObject(new HomeButton(main, new Sprite(Pathfinder.MEDIA_URL.concat("homeButton.png")), 2), 390, 500);
        main.addGameObject(new RetryButton(main, new Sprite(Pathfinder.MEDIA_URL.concat("retryButton.png")), 2), 830, 500);
    }
}
