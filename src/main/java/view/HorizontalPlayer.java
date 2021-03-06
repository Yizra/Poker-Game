package view;

import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import model.Player;


public class HorizontalPlayer extends PlayerArea {

    /**
     * Constructor for a HorizontalPlayer.
     * @param  player The Player object containing data about the Player to
     * be displayed
     */
    public HorizontalPlayer(Player player) {
        super(new HBox(20), player);
        ((HBox) playerPane()).setAlignment(Pos.CENTER);
    }

}