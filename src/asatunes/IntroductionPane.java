package asatunes;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class IntroductionPane extends Pane {

      private final Rectangle border;
      private final Text txtIntro;
      private final Text txtMembers;
      private final ClipPlayer clipPlayer;

      public IntroductionPane() {
            setPrefSize(1920, 1080);

            txtIntro = new Text("ASA Tunes");
            txtIntro.setFont(new Font("Century Gothic", 100));
            txtIntro.setTextAlignment(TextAlignment.CENTER);
            txtIntro.setFill(Color.WHITE);
            txtIntro.setLayoutX(1920 / 5);
            txtIntro.setLayoutY(1080 / 6);

            txtMembers = new Text("Adriano Cucci | Shoaib Hassan | Ahmed Faisal");
            txtMembers.setFont(new Font("Century Gothic", 18));
            txtMembers.setTextAlignment(TextAlignment.CENTER);
            txtMembers.setFill(Color.WHITE);
            txtMembers.setLayoutX(1920 / 4.5);
            txtMembers.setLayoutY(1080 / 2);

            border = new Rectangle(1920, 1080, Color.BLACK);

            getChildren().addAll(border, txtIntro, txtMembers);

            clipPlayer = new ClipPlayer();
            clipPlayer.introJingle();

            fadeIn();
      }

      private void fadeIn() {
            TranslateTransition translateIntro = new TranslateTransition(Duration.seconds(2), txtIntro);
            translateIntro.setToY(130);

            FillTransition fadeIntro = new FillTransition(Duration.seconds(3), txtIntro, Color.BLACK, Color.WHITE);

            TranslateTransition translateMembers = new TranslateTransition(Duration.seconds(2), txtMembers);
            translateMembers.setToY(-120);
            translateMembers.setInterpolator(Interpolator.EASE_BOTH);

            FillTransition fadeMembers = new FillTransition(Duration.seconds(3), txtMembers, Color.BLACK, Color.WHITE);

            ParallelTransition animationGroup = new ParallelTransition(translateIntro, translateMembers, fadeIntro, fadeMembers);
            animationGroup.setDelay(Duration.seconds(1.5));
            animationGroup.play();
            animationGroup.setOnFinished((event) -> {
                  fadeOut();
            });
      }

      private void fadeOut() {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), this);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.play();
            fadeOut.setOnFinished((event) -> {
                  setVisible(false);
            });
      }
}
