package view;

import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;



public class StartScreen extends StackPane {
    private Scene scene;
    private StackPane pane;
    private static PokerGame cont;

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";


    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {
        this.cont = cont;

        ImageView imageView = new ImageView("File:./src/main/res"
            + "/poker-game-background.png");
        imageView.setFitHeight(500);
        imageView.setFitWidth(500);
        pane = new StackPane();
        Button button = new Button("Start");

        pane.getChildren().add(imageView);
        pane.getChildren().add(button);
        button.setOnAction(e -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("New Game");
                dialog.setHeaderText("Confirmation");
                dialog.setContentText("Please enter your name:");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    TextInputDialog chipsAmount = new TextInputDialog();
                    chipsAmount.setTitle("Chips");
                    chipsAmount.setHeaderText("Amount of Chips");
                    chipsAmount.setContentText("Set starting amount of chips:");
                    Optional<String> amount = chipsAmount.showAndWait();
                    if (amount.isPresent()) {
                        cont.startGame(result.get(),
                            Integer.parseInt(amount.get()));
                    }
                }
            });
    }



    /**
     * Returns the pane.
     * @return The pane
     */
    public StackPane getPane() {
        return pane;
    }


}