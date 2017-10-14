package asatunes;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class TrackPlayer {

      private static boolean trackIsPlaying; //When this is true, do not allow all UI sound effects to play.
      private static boolean trackIsSet;
      private static MediaPlayer player;

      public static void setTrack(String filePath) {
            if (trackIsPlaying) {
                  stop();
            }
            try {
                  player = new MediaPlayer(new Media(new File(filePath).toURI().toASCIIString()));
                  player.setVolume(AudioUI.getVolume());
                  play();
                  AudioUI.setNowPlaying(filePath);
                  AudioUI.setPauseIcon();
                  AlbumIcons.setAlbumIcon(filePath);
                  trackIsSet = true;
            } catch (Exception e) {
                  System.out.println("Error playing file: " + filePath);
            }
      }

      public static void play() {
            if (!trackIsPlaying) {
                  player.play();
                  trackIsPlaying = true;
            }
      }

      public static void pause() {
            if (trackIsPlaying) {
                  player.pause();
                  trackIsPlaying = false;
            }
      }

      public static void stop() {
            if (trackIsPlaying) {
                  player.stop();
                  trackIsPlaying = false;
                  trackIsSet = false;
                  AlbumIcons.setAlbumIcon("");
            }
      }

      public static void toggle() {
            if (trackIsPlaying) {
                  pause();
            } else {
                  play();
            }
      }

      public static boolean getTrackIsSet() {
            return trackIsSet;
      }

      public static boolean getTrackIsPlaying() {
            return trackIsPlaying;
      }

      public static void setTrackIsPlaying(boolean trackIsPlaying) {
            TrackPlayer.trackIsPlaying = trackIsPlaying;
      }

      public static void setVolume(double volume) {
            if (trackIsPlaying) {
                  player.setVolume(volume);
            }
      }
}
