package asatunes;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Categories extends GridPane {

      private boolean isHidden;
      private final ClipPlayer clipPlayer;

      public Categories() {
            isHidden = true;
            clipPlayer = new ClipPlayer();

            setTranslateX(-600);
            setVisible(false);
            setAlignment(Pos.CENTER_LEFT);
            setVgap(20);

            addCategories();
            getStylesheets().add("styles/categories.css");
      }

      private void addCategories() {
            add(rockCategory(), 0, 0);
            add(rapCategory(), 0, 1);
            add(popCategory(), 0, 2);
            add(foreignCategory(), 0, 3);
      }

      private GridPane rockCategory() {
            Image iconPath = new Image("/images/guitar.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setScaleX(1.2);
            iconImage.setScaleY(1.2);

            Text optionText = new Text("Rock");
            optionText.setFont(new Font("Century Gothic", 60));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.6);

            GridPane optionPane = new GridPane();
            optionPane.setPrefSize(300, 80);
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setPrefWidth(500);
            optionPane.setHgap(100);
            optionPane.setId("option");

            optionPane.add(iconImage, 0, 0);
            optionPane.add(optionText, 1, 0);

            Image chevronPath = new Image("/images/chevrons.png");
            ImageView chevronImage = new ImageView(chevronPath);

            GridPane optionGroup = new GridPane();
            optionGroup.setAlignment(Pos.CENTER_LEFT);
            optionGroup.setHgap(60);
            optionGroup.setId("group");

            optionGroup.add(optionPane, 0, 0);
            optionGroup.add(chevronImage, 1, 0);

            optionGroup.setOnMouseClicked((event) -> {
                  optionAction(0);
            });
            optionGroup.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return optionGroup;
      }

      private GridPane rapCategory() {
            Image iconPath = new Image("/images/microphone.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setScaleX(1.2);
            iconImage.setScaleY(1.2);

            Text optionText = new Text("Rap");
            optionText.setFont(new Font("Century Gothic", 60));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.6);

            GridPane optionPane = new GridPane();
            optionPane.setPrefSize(300, 80);
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setPrefWidth(500);
            optionPane.setHgap(100);
            optionPane.setId("option");

            optionPane.add(iconImage, 0, 0);
            optionPane.add(optionText, 1, 0);

            Image chevronPath = new Image("/images/chevrons.png");
            ImageView chevronImage = new ImageView(chevronPath);

            GridPane optionGroup = new GridPane();
            optionGroup.setAlignment(Pos.CENTER_LEFT);
            optionGroup.setHgap(60);
            optionGroup.setId("group");

            optionGroup.add(optionPane, 0, 0);
            optionGroup.add(chevronImage, 1, 0);

            optionGroup.setOnMouseClicked((event) -> {
                  optionAction(1);
            });
            optionGroup.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return optionGroup;
      }

      private GridPane popCategory() {
            Image iconPath = new Image("/images/record.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setScaleX(1.2);
            iconImage.setScaleY(1.2);

            Text optionText = new Text("Pop");
            optionText.setFont(new Font("Century Gothic", 60));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.6);

            GridPane optionPane = new GridPane();
            optionPane.setPrefSize(300, 80);
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setPrefWidth(500);
            optionPane.setHgap(100);
            optionPane.setId("option");

            optionPane.add(iconImage, 0, 0);
            optionPane.add(optionText, 1, 0);

            Image chevronPath = new Image("/images/chevrons.png");
            ImageView chevronImage = new ImageView(chevronPath);

            GridPane optionGroup = new GridPane();
            optionGroup.setAlignment(Pos.CENTER_LEFT);
            optionGroup.setHgap(60);
            optionGroup.setId("group");

            optionGroup.add(optionPane, 0, 0);
            optionGroup.add(chevronImage, 1, 0);

            optionGroup.setOnMouseClicked((event) -> {
                  optionAction(2);
            });
            optionGroup.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return optionGroup;
      }

      private GridPane foreignCategory() {
            Image iconPath = new Image("/images/globe.png");
            ImageView iconImage = new ImageView(iconPath);
            iconImage.setScaleX(1.2);
            iconImage.setScaleY(1.2);

            Text optionText = new Text("Foreign");
            optionText.setFont(new Font("Century Gothic", 60));
            optionText.setStroke(Color.valueOf("#8C4646"));
            optionText.setStrokeWidth(1.6);

            GridPane optionPane = new GridPane();
            optionPane.setPrefSize(300, 80);
            optionPane.setAlignment(Pos.CENTER_LEFT);
            optionPane.setPrefWidth(500);
            optionPane.setHgap(100);
            optionPane.setId("option");

            optionPane.add(iconImage, 0, 0);
            optionPane.add(optionText, 1, 0);

            Image chevronPath = new Image("/images/chevrons.png");
            ImageView chevronImage = new ImageView(chevronPath);

            GridPane optionGroup = new GridPane();
            optionGroup.setAlignment(Pos.CENTER_LEFT);
            optionGroup.setHgap(60);
            optionGroup.setId("group");

            optionGroup.add(optionPane, 0, 0);
            optionGroup.add(chevronImage, 1, 0);

            optionGroup.setOnMouseClicked((event) -> {
                  optionAction(3);
            });
            optionGroup.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            return optionGroup;
      }

      private void optionAction(int optionID) {
            clipPlayer.buttonPress();

            switch (optionID) {
                  case 0:
                        ContentPane.hideLeft(ContentPane.categories);
                        ContentPane.showRight(ContentPane.rockCategory);
                        ContentPane.rockCategory.setIsHidden(false);
                        break;
                  case 1:
                        ContentPane.hideLeft(ContentPane.categories);
                        ContentPane.showRight(ContentPane.rapCategory);
                        ContentPane.rapCategory.setIsHidden(false);
                        break;
                  case 2:
                        ContentPane.hideLeft(ContentPane.categories);
                        ContentPane.showRight(ContentPane.popCategory);
                        ContentPane.popCategory.setIsHidden(false);
                        break;
                  case 3:
                        ContentPane.hideLeft(ContentPane.categories);
                        ContentPane.showRight(ContentPane.foreignCategory);
                        ContentPane.foreignCategory.setIsHidden(false);
                        break;
            }
            isHidden = true;
      }

      public boolean getIsHidden() {
            return isHidden;
      }

      public void setIsHidden(boolean isHidden) {
            this.isHidden = isHidden;
      }
}
