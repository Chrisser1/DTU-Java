import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class BinaryConverter extends Application {
    private TextField binaryInput = new TextField();
    private Button convertButton = new Button();
    private Text outPut = new Text("");

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Binary Converter");

        // Top panel with input and button
        HBox topPanel = new HBox(10);
        this.convertButton.setText("Click to start conversion");
        this.binaryInput.setPromptText("Input binary");
        topPanel.getChildren().addAll(this.binaryInput, this.convertButton);
        topPanel.setAlignment(Pos.TOP_CENTER);

        // Mid-panel for output display
        HBox midPanel = new HBox(10);
        this.outPut.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        midPanel.getChildren().add(this.outPut);
        midPanel.setAlignment(Pos.CENTER);

        // Combine panels in a VBox
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(topPanel, midPanel);

        // Set up the scene
        Scene scene = new Scene(mainLayout, 600, 200);

        // Button action to update output
        this.convertButton.setOnAction(e -> {
            this.outPut.setText(translateBinary(this.binaryInput.getText()));
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static String translateBinary(String input) {
        // Check if the input is valid
        if (!input.matches("[01]+")) {
            return "Error, please make sure input is only 0 and 1!";
        }
        String out = "";

        int number = 0;
        // Calculate the number
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                number += Math.pow(2,i);
            } else {
                continue;
            }
        }
        return String.valueOf(number);
    }
}
