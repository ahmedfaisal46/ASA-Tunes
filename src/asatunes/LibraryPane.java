package asatunes;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LibraryPane extends GridPane {

      private boolean isHidden;
      private final ClipPlayer clipPlayer;

      public LibraryPane() {
            isHidden = true;
            clipPlayer = new ClipPlayer();

            setAlignment(Pos.CENTER_LEFT);
            setHgap(8);
            setVgap(8);
            addSongs();
            getStylesheets().add("styles/categories.css");
      }

      private void addSongs() {
            add(song("./src/audio/tracks/rock/-Blur-Tracy Jacks.mp3"), 0, 0);
            add(song("./src/audio/tracks/rock/-What we're all about-Sum 41.mp3"), 0, 1);
            add(song("./src/audio/tracks/rock/-Wonderwall-Oasis.mp3"), 0, 2);
            add(song("./src/audio/tracks/rap/-Ain't nothin to f wit-Wu Tang.mp3"), 0, 3);
            add(song("./src/audio/tracks/rap/-Hit 'em Up Dirty-Tupac.mp3"), 0, 4);
            add(song("./src/audio/tracks/foreign/-Laila Main Laila-Ram Sampath.mp3"), 0, 5);
            add(song("./src/audio/tracks/rap/-Over-Drake.mp3"), 1, 0);
            add(song("./src/audio/tracks/pop/-I Knew You Were Trouble-Taylor Swift.mp3"), 1, 1);
            add(song("./src/audio/tracks/pop/-Just Dance-Lady Gaga.mp3"), 1, 2);
            add(song("./src/audio/tracks/pop/-What You Got-Colby O' Donis feat. Akon.mp3"), 1, 3);
            add(song("./src/audio/tracks/foreign/-PONPONPON-Kyary Pamyu Pamyu.mp3"), 1, 4);
            add(song("./src/audio/tracks/foreign/-That's Amore-Rocco Granata.mp3"), 1, 5);
      }

      private GridPane song(String filePath) {

            Image iconPath = new Image("/images/play.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setScaleX(0.8);
            iconImage.setScaleY(0.8);

            String[] label = getSongAndArtist(filePath);
            Text optionText = new Text(label[1] + " - '" + label[0] + "'");
            optionText.setFont(new Font("Century Gothic", 18));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.4);

            GridPane optionPane = new GridPane();
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setHgap(20);
            optionPane.setId("button");

            optionPane.add(iconImage, 0, 0);
            optionPane.add(optionText, 1, 0);

            optionPane.setOnMouseClicked((event) -> {
                  optionAction(filePath);
            });
            optionPane.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return optionPane;
      }

      private void optionAction(String filePath) {
            TrackPlayer.setTrack(filePath);
            clipPlayer.buttonPress();
      }

      /*
      This method will return a two-sized String array after reading the directory of a song.
      String[0] will be the song name.
      String[1] will be the song artist.
       */
      private String[] getSongAndArtist(String file) {
            File songPath = new File(file);

            String[] fileSplit = songPath.toString().split("-");
            String songName = fileSplit[1];
            String songArtist = fileSplit[2].substring(0, (fileSplit[2].length() - 4));

            fileSplit[0] = songName;
            fileSplit[1] = songArtist;

            return fileSplit;
      }

      public boolean getIsHidden() {
            return isHidden;
      }

      public void setIsHidden(boolean isHidden) {
            this.isHidden = isHidden;
      }
}
