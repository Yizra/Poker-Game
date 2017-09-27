package view;

import javafx.scene.layout.HBox;
import viewcontroller.PokerGameController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;




public class ControlPane extends HBox {

    private PokerGameController cont;
    private TextField textField;
    private Button raise;
    private Button call;
    private Button fold;
    private Button startNew;
    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        this.cont = cont;

        textField = new TextField();
        raise = new Button("Raise");
        call = new Button("Call");
        fold = new Button("Fold");
        startNew = new Button("Start New Round");
        startNew.setVisible(false);

        String sound = "src/main/res/Ting-sound-effect.mp3";
        Media noise = new Media(new File(sound).toURI().toString());


        textField.setTranslateX(450);
        raise.setTranslateX(460);
        call.setTranslateX(470);
        fold.setTranslateX(480);
        startNew.setTranslateX(490);

        raise.setOnAction(e -> {
                if (!(textField.getText().length() == 0)) {
                    MediaPlayer media = new MediaPlayer(noise);
                    MediaPlayer.Status status = media.getStatus();
                    int amount = Integer.parseInt(textField.getText());
                    cont.humanBet(amount);
                    if (status != MediaPlayer.Status.PLAYING) {
                        media.play();
                    }
                }
            });
        raise.setDisable(true);

        fold.setOnAction(e -> {
                MediaPlayer media = new MediaPlayer(noise);
                MediaPlayer.Status status = media.getStatus();
                cont.humanFold();
                if (status != MediaPlayer.Status.PLAYING) {
                    media.play();
                }
            });

        fold.setDisable(true);


        startNew.setOnAction(e -> {
                MediaPlayer media = new MediaPlayer(noise);
                MediaPlayer.Status status = media.getStatus();
                cont.startNewPokerHand();
                Console.clearLog();
                startNew.setVisible(false);

                if (status != MediaPlayer.Status.PLAYING) {
                    media.play();
                }
            });

        call.setOnAction(e -> {
                MediaPlayer media = new MediaPlayer(noise);
                MediaPlayer.Status status = media.getStatus();
                cont.humanCall();
                if (status != MediaPlayer.Status.PLAYING) {
                    media.play();
                }

            });

        call.setDisable(true);



        getChildren().addAll(textField, raise, call, fold, startNew);
    }
    /**
     * Returns the raise.
     * @return The raise
     */
    public Button getRaise() {
        return raise;
    }
    /**
     * Returns the fold.
     * @return The fold
     */
    public Button getFold() {
        return fold;
    }
    /**
     * Returns the call.
     * @return The call
     */
    public Button getCall() {
        return call;
    }
    /**
     * Returns the startnew.
     * @return The startnew
     */
    public Button getStartNew() {
        return startNew;
    }
    /**
     * Returns the cont.
     * @return The cont
     */
    public PokerGameController getController() {
        return cont;
    }
    /**
     * Returns the textField.
     * @return The textField
     */
    public TextField getTextField() {
        return textField;
    }

    /**
     * Called whenever it becomes the player's turn again
     */
    public void playerTurn() {

        raise.setDisable(false);
        call.setDisable(false);
        fold.setDisable(false);
        // startNew.setVisible(false);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {
        startNew.setVisible(true);
    }

}
