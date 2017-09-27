package view;

import javafx.scene.layout.BorderPane;
import viewcontroller.PokerGameController;



public class GameScreen extends BorderPane {


    private PlayerArea top;
    private PlayerArea bottom;
    private PlayerArea left;
    private PlayerArea right;
    private BoardArea boardArea;
    /**
     * GameScreen's constructor
     * @param controller The PokerGameController to interact with
     */
    public GameScreen(PokerGameController controller) {

        right = new VerticalPlayer(controller.getRightPlayer());
        left = new VerticalPlayer(controller.getLeftPlayer());
        bottom = new HorizontalPlayer(controller.getBottomPlayer());
        top = new HorizontalPlayer(controller.getTopPlayer());

        boardArea = new BoardArea(controller.getBoard());

        this.setTop(top.playerPane());
        this.setBottom(bottom.playerPane());
        this.setRight(right.playerPane());
        this.setLeft(left.playerPane());
        this.setCenter(boardArea.getPane());
        this.updatesMade();
    }
    /**
     * This method is called whenever normal updates to the UI need to be made.
     */
    public void updatesMade() {

        top.update(false);
        bottom.update(true);
        left.update(false);
        right.update(false);
        boardArea.update();
    }

    /**
     * This method is called whenever a round of poker ends
     */
    public void endOfRound() {

        top.update(true);
        bottom.update(true);
        left.update(true);
        right.update(true);
        boardArea.update();

    }

}