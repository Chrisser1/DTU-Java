import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import java.awt.*;

public class MouseDrawGUI extends Application {
    private ColorPicker colorPicker = new ColorPicker();
    private ChoiceBox<Integer> penSize = new ChoiceBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Drawing App");

        // Drawing area
        Canvas canvas = new Canvas(300, 250);
        canvas.setStyle("-fx-background-color: #000000;");
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // ColorPicker for choosing pen color
        colorPicker.setValue(Color.BLACK);

        // ChoiceBox for pen size
        penSize.getItems().addAll(2, 5, 10, 20, 30); // Pen size options
        penSize.setValue(5); // Default size

        // Top panel with controls
        HBox topPanel = new HBox(10);
        topPanel.getChildren().addAll(colorPicker, penSize);
        topPanel.setAlignment(Pos.TOP_CENTER);

        // Main layout
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(topPanel, canvas);

        // Set up the scene
        Scene scene = new Scene(mainLayout, 800, 600);

        // Handle mouse pressed to draw
        canvas.setOnMousePressed((MouseEvent event) -> {
            draw(event, canvas);
        });

        // Handle mouse drag to draw
        canvas.setOnMouseDragged((MouseEvent event) -> {
            draw(event, canvas);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Draw a circle at the current mouse position
    private void draw(MouseEvent event, GraphicsContext gc) {
        canvas.getGraphicsContext2D();
        Circle circle = new Circle(event.getX(), event.getY(), penSize.getValue(), colorPicker.getValue());
        canvas.set().add(circle);
    }
}
