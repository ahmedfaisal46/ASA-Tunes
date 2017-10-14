package asatunes;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Categories_Pop extends GridPane {

      private boolean isHidden;
      private final ClipPlayer clipPlayer;

      public Categories_Pop() {
            isHidden = true;
            clipPlayer = new ClipPlayer();

            setTranslateX(1000);
            setVisible(false);
            setAlignment(Pos.CENTER_LEFT);
            setVgap(5);
            addSongs();
            getStylesheets().add("styles/categories.css");
      }

      private void addSongs() {
            add(backButton(), 0, 0);
            add(song("./src/audio/tracks/pop/-I Knew You Were Trouble-Taylor Swift.mp3"), 0, 1);
            add(song("./src/audio/tracks/pop/-Just Dance-Lady Gaga.mp3"), 0, 2);
            add(song("./src/audio/tracks/pop/-What You Got-Colby O' Donis feat. Akon.mp3"), 0, 3);
      }

      private Button backButton() {
            Image iconPath = new Image("/images/chevrons.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setRotate(180);

            Button backButton = new Button("", iconImage);
            backButton.setId("button");

            backButton.setOnMouseClicked((event) -> {
                  clipPlayer.buttonPress();
                  hideThisCategory();
            });
            backButton.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return backButton;
      }

      private GridPane song(String filePath) {
            Image iconPath = new Image("/images/play.png");
            ImageView iconImage = new ImageView(iconPath);

            String[] label = getSongAndArtist(filePath);
            Text optionText = new Text(label[1] + " - '" + label[0] + "'");
            optionText.setFont(new Font("Century Gothic", 30));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.4);

            GridPane optionPane = new GridPane();
            optionPane.setPrefSize(400, 60);
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setPrefWidth(500);
            optionPane.setHgap(60);
            optionPane.setId("button");
            optionPane.setStyle("-fx-padding: 5px");

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

      private void hideThisCategory() {
            ContentPane.hideRight(ContentPane.popCategory);
            ContentPane.showLeft(ContentPane.categories);
            ContentPane.categories.setIsHidden(false);
            isHidden = true;
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
