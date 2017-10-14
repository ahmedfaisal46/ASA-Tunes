package asatunes;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ClipPlayer {

      private MediaPlayer buttonHover;
      private MediaPlayer buttonPress;
      private final MediaPlayer introJingle;
      private static boolean allowUISound;

      public ClipPlayer() {
            allowUISound = true;

            buttonHover = new MediaPlayer(new Media(new File("./src/audio/ui/buttonHover.wav").toURI().toASCIIString()));
            buttonPress = new MediaPlayer(new Media(new File("./src/audio/ui/buttonPress.wav").toURI().toASCIIString()));
            introJingle = new MediaPlayer(new Media(new File("./src/audio/ui/introJingle.wav").toURI().toASCIIString()));
      }

      public void buttonHover() {
            if (allowUISound) {
                  if (!TrackPlayer.getTrackIsPlaying()) {
                        buttonHover = new MediaPlayer(new Media(new File("./src/audio/ui/buttonHover.wav").toURI().toASCIIString()));
                        buttonHover.play();
                  }
            }
      }

      public void buttonPress() {
            if (allowUISound) {
                  if (!TrackPlayer.getTrackIsPlaying()) {
                        buttonPress = new MediaPlayer(new Media(new File("./src/audio/ui/buttonPress.wav").toURI().toASCIIString()));
                        buttonPress.play();
                  }
            }
      }

      public void introJingle() {
            introJingle.play();
      }

      public static void toggleUISound() {
            if (allowUISound) {
                  allowUISound = false;
            } else {
                  allowUISound = true;
            }
      }

      public static void enableUISound() {
            allowUISound = true;
      }

      public static void disableUISound() {
            allowUISound = false;
      }
}
