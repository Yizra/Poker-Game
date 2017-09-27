package view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;



public class Console extends ScrollPane {

    private static Console instance;
    private Label console;

    /**
     * Console's constructor. Set's the static instance variable.
     */
    public Console() {
        instance = this;
        console = new Label();
        console.setWrapText(true);
        instance.setContent(console);
        instance.setPrefViewportHeight(1000);
        instance.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }

    /**
     * Add's text to the top of the console. (Doesn't get rid of
     * text that is already there!)
     * @param newText is the text to add to the top of the console
     */
    public void addText(String newText) {

        this.console.setText(newText + "\n" + console.getText());
    }

    /**
     * Clears the console of any text
     */
    public void clear() {
        console.setText("");
    }

    /**
     * Static method that adds a message into the current
     * {@value  instance}
     * @param message The message to add
     */
    public static void putMessage(String message) {
        instance.addText(message);
    }

    /**
     * Clears the console of the current {@value instance}
     */
    public static void clearLog() {
        instance.clear();
    }
}