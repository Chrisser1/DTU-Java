import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Vector;

public class Animation extends Application {
    private DirectionVector direction = new DirectionVector(4,12);

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the animation
        Pane pane = new Pane();

        // Create a Circle for animation
        Circle circle = new Circle(50, 100, 20);
        circle.setFill(Color.BLUE);

        // Add the circle to the pane
        pane.getChildren().add(circle);

        // Create a Timeline for the animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Create a KeyFrame
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.02),
                event -> {
                    // Update the circle's position
                    circle.setCenterX(circle.getCenterX() + direction.getX());
                    circle.setCenterY(circle.getCenterY() + direction.getY());

                    // Check for collision with the pane's boundaries
                    if (circle.getCenterX() - circle.getRadius() <= 0 || circle.getCenterX() + circle.getRadius() >= pane.getWidth()) {
                        direction.setX(-direction.getX()); // Reverse the horizontal direction
                    }

                    if (circle.getCenterY() - circle.getRadius() <= 0 || circle.getCenterY() + circle.getRadius() >= pane.getHeight()) {
                        direction.setY(-direction.getY()); // Reverse the vertical direction
                    }
                }
        );

        // Add the KeyFrame to the Timeline
        timeline.getKeyFrames().add(keyFrame);

        // Start the animation
        timeline.play();

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("JavaFX Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
