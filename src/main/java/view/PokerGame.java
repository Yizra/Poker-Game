package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import viewcontroller.PokerGameController;
import javafx.scene.layout.VBox;
import viewcontroller.GameState;





public class PokerGame extends Application {

    private static Stage primaryStage;
    private PokerGameController controller;
    private GameScreen gameScreen;
    private ControlPane controlPane;
    private Console console;
    private VBox vBox;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    public void start(Stage ps) {
        primaryStage = ps;

        StartScreen startScreen = new StartScreen(this);
        Scene scene = new Scene(startScreen.getPane(), 500, 500);
        primaryStage.setTitle("Start Screen");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    /**
     * Returns the primary stage.
     * @return The primary stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * Returns the controller.
     * @return The controller
     */
    public PokerGameController getController() {
        return controller;
    }
    /**
     * Returns the game screen.
     * @return The game screen
     */
    public GameScreen getGameScreen() {
        return gameScreen;
    }
    /**
     * Returns the control pane.
     * @return The control pane
     */
    public ControlPane getControlPane() {
        return controlPane;
    }
    /**
     * Returns the console.
     * @return The console
     */
    public Console getConsole() {
        return console;
    }
    /**
     * Returns the vbox.
     * @return The vbox
     */
    public VBox getVbox() {
        return vBox;
    }
    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     * @param startAmount the starting amount of chips
     */
    public void startGame(String name, int startAmount) {

        controller = new PokerGameController(this, name, startAmount);
        gameScreen = new GameScreen(controller);
        controlPane = new ControlPane(controller);
        console = new Console();
        vBox = new VBox();
        vBox.getChildren().addAll(gameScreen, controlPane, console);
        // vBox.getChildren().add(gameScreen);



        primaryStage.getScene().setRoot(vBox);
        primaryStage.show();
        controller.start();

        // Scene gameScene = new Scene(gameScreen, 500, 500);
        // primaryStage.setScene(gameScene);
        // primaryStage.show();

    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {

        if (controller.getState() == GameState.DONE) {
            gameScreen.endOfRound();
            controlPane.endOfRound();
            // console.clear();

        }
        if (controller.getState() == GameState.AI_BET) {
            gameScreen.updatesMade();
            controlPane.getRaise().setDisable(true);
            controlPane.getFold().setDisable(true);
            controlPane.getCall().setDisable(true);


        }
        if (controller.getState() == GameState.HUMAN_BET) {
            gameScreen.updatesMade();
            controlPane.playerTurn();

        }
    }

    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}