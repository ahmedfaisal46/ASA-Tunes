package asatunes;

import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//---This is the bottom-pane that contains the buttons for the user to interact wiht the audio files---//
public class AudioPane extends StackPane {

      private final Rectangle border;
      AudioUI audioUI;

      public AudioPane() {
            setLayoutX(0);
            setLayoutY(600);
            setPrefSize(1276, 116);

            border = new Rectangle(300, 200, 1276, 116);
            border.setFill(Color.valueOf("#D96459"));
            border.setStroke(Color.valueOf("#F2AE72"));
            border.setStrokeWidth(4);
            
            audioUI = new AudioUI();

            getChildren().addAll(border, audioUI);

            addPaneAnimation();
      }

      private void addPaneAnimation() {
            FillTransition fillTransition = new FillTransition(Duration.seconds(6), border, Color.valueOf("#D96459"), Color.valueOf("#8C4646"));
            fillTransition.setAutoReverse(true);
            fillTransition.setCycleCount(Timeline.INDEFINITE);
            fillTransition.setInterpolator(Interpolator.LINEAR);
            fillTransition.play();
      }
}
