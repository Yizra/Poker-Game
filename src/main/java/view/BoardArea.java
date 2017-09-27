package view;

import javafx.scene.layout.HBox;
import model.Board;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import model.Card;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;



public class BoardArea {

    private HBox pane;
    private Board board;
    private Label pot;
    private CardView card1;
    private CardView card2;
    private CardView card3;
    private CardView card4;
    private CardView card5;

    /**
     * Constructor for the board's display
     * @param  board The Board object that contains data associated with the
     * board
     */
    public BoardArea(Board board) {
        this.board = board;
        card1 = new CardView();
        card2 = new CardView();
        card3 = new CardView();
        card4 = new CardView();
        card5 = new CardView();

        pot = new Label("            Pot: " + board.getPot());
        pane = new HBox(30);
        pane.getChildren().addAll(card1, card2, card3, card4, card5, pot);
        pane.setAlignment(Pos.CENTER);

    }

    /**
     * Getter for the HBox that all UI elements are on
     * @return the HBox that all Board UI elements are on
     */
    public HBox getPane() {
        return pane;
    }

    /**
     * Updates UI elements
     */
    public void update() {

        pot.setText("            Pot: " + board.getPot());

        CardView[] cardViews = new CardView[5];
        cardViews[0] = card1;
        cardViews[1] = card2;
        cardViews[2] = card3;
        cardViews[3] = card4;
        cardViews[4] = card5;

        card1.hide();
        card2.hide();
        card3.hide();
        card4.hide();
        card5.hide();

        Card[] cards = new Card[5];

        for (int i = 0; i < board.getNumCards(); i++) {
            cards[i] = board.getTableCard(i);
        }


        for (int i = 0; i < board.getNumCards(); i++) {
            cardViews[i].setCard(cards[i]);
            cardViews[i].show();
        }
      
    }

}
