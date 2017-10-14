package asatunes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class AlbumIcons extends StackPane {

      private static final ImageView[] icon = new ImageView[13];
      private int iconID;

      public AlbumIcons() {
            iconID = -1;
            setLayoutX(1175);
            setLayoutY(615);
            addIcons();
            
            icon[0].setVisible(true);
      }

      private void addIcons() {
            getChildren().add(Icon("/images/albums/defaultAlbum.png"));
            getChildren().add(Icon("/images/albums/colbyAlbum.jpg"));
            getChildren().add(Icon("/images/albums/drakeAlbum.jpg"));
            getChildren().add(Icon("/images/albums/granataAlbum.jpg"));
            getChildren().add(Icon("/images/albums/ladygagaAlbum.jpg"));
            getChildren().add(Icon("/images/albums/lailaAlbum.png"));
            getChildren().add(Icon("/images/albums/pamyuAlbum.jpg"));
            getChildren().add(Icon("/images/albums/sum41Album.jpg"));
            getChildren().add(Icon("/images/albums/taylorswiftAlbum.png"));
            getChildren().add(Icon("/images/albums/tupacAlbum.png"));
            getChildren().add(Icon("/images/albums/wutangAlbum.jpg"));
            getChildren().add(Icon("/images/albums/tracyjacksAlbum.png"));
            getChildren().add(Icon("/images/albums/oasisAlbum.png"));
      }

      private ImageView Icon(String filePath) {
            iconID++;

            icon[iconID] = new ImageView(new Image(filePath));
            icon[iconID].setFitWidth(90);
            icon[iconID].setFitHeight(90);
            icon[iconID].setVisible(false);

            return icon[iconID];
      }

      public static void setAlbumIcon(String filepath) {
            for (int i = 0; i < icon.length; i++) {
                  icon[i].setVisible(false);
            }

            switch (filepath) {
                  case "./src/audio/tracks/pop/-What You Got-Colby O' Donis feat. Akon.mp3":
                        icon[1].setVisible(true);
                        break;
                  case "./src/audio/tracks/rap/-Over-Drake.mp3":
                        icon[2].setVisible(true);
                        break;
                  case "./src/audio/tracks/foreign/-That's Amore-Rocco Granata.mp3":
                        icon[3].setVisible(true);
                        break;
                  case "./src/audio/tracks/pop/-Just Dance-Lady Gaga.mp3":
                        icon[4].setVisible(true);
                        break;
                  case "./src/audio/tracks/foreign/-Laila Main Laila-Ram Sampath.mp3":
                        icon[5].setVisible(true);
                        break;
                  case "./src/audio/tracks/foreign/-PONPONPON-Kyary Pamyu Pamyu.mp3":
                        icon[6].setVisible(true);
                        break;
                  case "./src/audio/tracks/rock/-What we're all about-Sum 41.mp3":
                        icon[7].setVisible(true);
                        break;
                  case "./src/audio/tracks/pop/-I Knew You Were Trouble-Taylor Swift.mp3":
                        icon[8].setVisible(true);
                        break;
                  case "./src/audio/tracks/rap/-Hit 'em Up Dirty-Tupac.mp3":
                        icon[9].setVisible(true);
                        break;
                  case "./src/audio/tracks/rap/-Ain't nothin to f wit-Wu Tang.mp3":
                        icon[10].setVisible(true);
                        break;
                  case "./src/audio/tracks/rock/-Blur-Tracy Jacks.mp3":
                        icon[11].setVisible(true);
                        break;
                  case "./src/audio/tracks/rock/-Wonderwall-Oasis.mp3":
                        icon[12].setVisible(true);
                        break;
                  default:
                        icon[0].setVisible(true);
            }
      }
}
