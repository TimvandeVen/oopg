package game.menus;

import game.Pathfinder;

public class EndMenu extends Menu {

    // Reference to main engine class
    private final Pathfinder main;

    public EndMenu(Pathfinder main) {
        super(main);
        this.main = main;

        loadButtons();
    }

    @Override
    protected void loadButtons() {
        if (main.levelComplete) {
            System.out.println("Win");
        } else {
            System.out.println("Loss");
        }
    }
}
