package asatunes;

import java.io.File;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AudioUI extends GridPane {

      private static final Rectangle2D[] VIEW = new Rectangle2D[3];
      private final ClipPlayer clipPlayer;
      private static String[] label;
      private static Text txtNowPlaying;
      private static ImageView iconImage;
      private static Slider volumeSlider;

      public AudioUI() {
            VIEW[0] = new Rectangle2D(0, 0, 60, 60);
            VIEW[1] = new Rectangle2D(76.4, 0, 60, 60);
            VIEW[2] = new Rectangle2D(76.4 * 2, 0, 60, 60);
            clipPlayer = new ClipPlayer();
            volumeSlider = new Slider(0, 1, 0.5);

            setTranslateX(20);
            setAlignment(Pos.CENTER_LEFT);
            setHgap(40);
            setVgap(6);
            addUI();
            getStylesheets().add("styles/audioButtons.css");
      }

      private void addUI() {
            add(stop(), 0, 0);
            add(playPause(), 1, 0);
            add(configureNowPlaying(), 2, 0);
            add(volumeLabel(), 0, 1);
            add(volumeSlider(), 1, 1);
      }

      private Label stop() {
            Image iconPath = new Image("/images/audioButtons.png");
            iconImage = new ImageView(iconPath);
            iconImage.setViewport(VIEW[2]);

            Label button = new Label("", iconImage);
            button.setId("playPause");

            button.setOnMouseClicked((event) -> {
                  TrackPlayer.stop();
                  setPlayIcon();
                  txtNowPlaying.setText("");
                  clipPlayer.buttonPress();
            });
            button.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return button;
      }

      private Label playPause() {
            Image iconPath = new Image("/images/audioButtons.png");
            iconImage = new ImageView(iconPath);
            iconImage.setViewport(VIEW[1]);

            Label button = new Label("", iconImage);
            button.setId("playPause");

            button.setOnMouseClicked((event) -> {
                  if (TrackPlayer.getTrackIsSet()) {
                        TrackPlayer.toggle();
                        togglePlayPause();
                  }
                  clipPlayer.buttonPress();
            });
            button.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return button;
      }

      private Text volumeLabel() {
            Text txtVolume = new Text("Volume:");
            txtVolume.setFont(new Font("Century Gothic", 24));
            txtVolume.setFill(Color.valueOf("#F2AE72"));
            txtVolume.setStroke(Color.valueOf("#F2AE72"));

            return txtVolume;
      }

      private Slider volumeSlider() {
            volumeSlider.setOnMouseDragged((event) -> {
                  TrackPlayer.setVolume(volumeSlider.getValue());
            });
            volumeSlider.setOnMousePressed((event) -> {
                  TrackPlayer.setVolume(volumeSlider.getValue());
            });
            volumeSlider.setId("slider");

            return volumeSlider;
      }

      public static double getVolume() {
            return volumeSlider.getValue();
      }

      public static void enableSlider() {
            volumeSlider.setDisable(false);
      }

      public static void disableSlider() {
            volumeSlider.setDisable(true);
      }

      private Text configureNowPlaying() {
            txtNowPlaying = new Text("");
            txtNowPlaying.setFont(new Font("Century Gothic", 24));
            txtNowPlaying.setStroke(Color.valueOf("#F2AE72"));
            txtNowPlaying.setStrokeWidth(1.4);

            return txtNowPlaying;
      }

      public static void setNowPlaying(String filePath) {
            label = getSongAndArtist(filePath);
            txtNowPlaying.setText("Now Playing: '" + label[0] + "', by: " + label[1]);
      }

      /*
      This method will return a two-sized String array after reading the directory of a song.
      String[0] will be the song name.
      String[1] will be the song artist.
       */
      private static String[] getSongAndArtist(String file) {
            File songPath = new File(file);

            String[] fileSplit = songPath.toString().split("-");
            String songName = fileSplit[1];
            String songArtist = fileSplit[2].substring(0, (fileSplit[2].length() - 4));

            fileSplit[0] = songName;
            fileSplit[1] = songArtist;

            return fileSplit;
      }

      public static void setPlayIcon() {
            iconImage.setViewport(VIEW[1]);
      }

      public static void setPauseIcon() {
            iconImage.setViewport(VIEW[0]);
      }

      public static void togglePlayPause() {
            if (iconImage.getViewport() == VIEW[0]) {
                  iconImage.setViewport(VIEW[1]);
            } else {
                  iconImage.setViewport(VIEW[0]);
            }
      }
}
