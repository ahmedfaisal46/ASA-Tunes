package asatunes;

import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//---This is the pane to the far left that provides options for the user to click on, which will then be displayed in ContentPane---//
public class SideBarPane extends Pane {

      private final Rectangle border;
      SidePaneOptions options = new SidePaneOptions();

      public SideBarPane() {
            setPrefSize(300, 718);
            
            border = new Rectangle(0, 0, 300, 718);
            border.setFill(Color.valueOf("#D96459"));
            border.setStroke(Color.valueOf("#F2AE72"));
            border.setStrokeWidth(8);

            getChildren().addAll(border, options);
            
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
