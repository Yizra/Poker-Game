package view;

import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import model.Player;
import javafx.scene.layout.VBox;



public abstract class PlayerArea {

    private Pane pane;
    private Player player;
    private Label chips;
    private CardView card1;
    private CardView card2;
    private Label outOfPlay;
    private Label name;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;

        card1 = new CardView();
        card2 = new CardView();
        name = new Label(player.toString());
        chips = new Label(Integer.toString(player.getMoney()));
        outOfPlay = new Label("Out of Play");

        VBox vBox = new VBox();
        vBox.getChildren().add(name);
        vBox.getChildren().add(chips);
        vBox.getChildren().add(outOfPlay);

        pane.getChildren().addAll(card1, card2, vBox);
    }
    /**
     * Returns the pane.
     * @return The pane
     */
    public Pane getPane() {
        return pane;
    }
    /**
     * Returns the player.
     * @return The player
     */
    public Player player() {
        return player;
    }
    /**
     * Returns the chips.
     * @return The chips
     */
    public Label getChips() {
        return chips;
    }
    /**
     * Returns the card1.
     * @return card1
     */
    public CardView getCard1() {
        return card1;
    }
    /**
     * Returns the card2.
     * @return card2
     */
    public CardView getCard2() {
        return card2;
    }
    /**
     * Returns the outofplay.
     * @return The outofplay
     */
    public Label getOutOfPlay() {
        return outOfPlay;
    }
    /**
     * Returns the Name.
     * @return The Name
     */
    public Label getName() {
        return name;
    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {

        chips.setText("Chips " + player.getMoney());
        if (player.getCard(0) != null) {
            card1.setCard(player.getCard(0));
        }
        if (player.getCard(1) != null) {
            card2.setCard(player.getCard(1));
        }

        if (!showDetails && !player.getOutOfPlay()) {
            card1.hideDetails();
            card2.hideDetails();
            outOfPlay.setVisible(false);
        } else if (player.getOutOfPlay()) {
            card1.hide();
            card2.hide();
            outOfPlay.setVisible(true);
        } else {
            card1.show();
            card2.show();
            outOfPlay.setVisible(false);
        }
    }

}