package asatunes;

import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

//---This is the large pane in the center-right that displays all the main content to the user---//
//---All main content UI should be placed in this pane---//
public class ContentPane extends StackPane {

      private final Rectangle border;

      protected static LibraryPane libraryPane;

      protected static Categories categories;
      protected static Categories_Rock rockCategory;
      protected static Categories_Rap rapCategory;
      protected static Categories_Pop popCategory;
      protected static Categories_Foreign foreignCategory;
      
      protected static SettingsPane settingsPane;

      public ContentPane() {
            setLayoutX(300);
            setLayoutY(0);
            setPrefSize(976, 600);

            border = new Rectangle(300, 200, 976, 600);
            border.setFill(Color.valueOf("#8C4646"));
            border.setStroke(Color.valueOf("#F2AE72"));
            border.setStrokeWidth(4);

            libraryPane = new LibraryPane();

            categories = new Categories();
            rockCategory = new Categories_Rock();
            rapCategory = new Categories_Rap();
            popCategory = new Categories_Pop();
            foreignCategory = new Categories_Foreign();
            
            settingsPane = new SettingsPane();

            getChildren().addAll(border, libraryPane, categories, rockCategory, rapCategory, popCategory, foreignCategory, settingsPane);

            addPaneAnimation();
      }

      public static void showLeft(Region option) {
            option.setDisable(false);
            option.setVisible(true);
            TranslateTransition translate = new TranslateTransition(Duration.millis(80), option);
            translate.setToX(0);
            translate.play();
      }

      public static void hideLeft(Region option) {
            option.setDisable(true);
            TranslateTransition translate = new TranslateTransition(Duration.millis(80), option);
            translate.setToX(-600);
            translate.play();
            translate.setOnFinished((event) -> {
                  option.setVisible(false);
            });
      }

      public static void showRight(Region option) {
            option.setDisable(false);
            option.setVisible(true);
            TranslateTransition translate = new TranslateTransition(Duration.millis(80), option);
            translate.setToX(0);
            translate.play();
      }

      public static void hideRight(Region option) {
            option.setDisable(true);
            TranslateTransition translate = new TranslateTransition(Duration.millis(80), option);
            translate.setToX(1000);
            translate.play();
            translate.setOnFinished((event) -> {
                  option.setVisible(false);
            });
      }

      private void addPaneAnimation() {
            FillTransition fillTransition = new FillTransition(Duration.seconds(6), border, Color.valueOf("#8C4646"), Color.valueOf("#D96459"));
            fillTransition.setAutoReverse(true);
            fillTransition.setCycleCount(Timeline.INDEFINITE);
            fillTransition.setInterpolator(Interpolator.LINEAR);
            fillTransition.play();
      }
}
