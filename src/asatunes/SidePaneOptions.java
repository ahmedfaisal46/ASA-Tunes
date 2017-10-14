package asatunes;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SidePaneOptions extends Pane {

      private final ClipPlayer clipPlayer;
      static ExitPane exitPane;

      public SidePaneOptions() {
            clipPlayer = new ClipPlayer();

            addBanner();
            addLibraryOption();
            addCategoryOption();
            addSettingsOption();
            addExitOption();
      }

      private void addBanner() {
            Rectangle border = new Rectangle(287, 95);
            border.setFill(Color.valueOf("#F2AE72"));
            border.setStroke(Color.valueOf("#8C4646"));
            border.setStrokeWidth(4);

            Text heading = new Text("ASA Tunes");
            heading.setFont(new Font("Century Gothic", 50));
            heading.setTextAlignment(TextAlignment.CENTER);
            heading.setFill(Color.valueOf("#588C7E"));
            heading.setStroke(Color.BLACK);
            heading.setStrokeWidth(2);
            heading.setUnderline(true);

            StackPane headerPane = new StackPane(border, heading);
            headerPane.setLayoutX(4.5);
            headerPane.setLayoutY(5);

            getChildren().add(headerPane);
      }

      private void addLibraryOption() {
            Text optionText = new Text("Library");
            optionText.setFont(new Font("Century Gothic", 40));
            optionText.setStroke(Color.BLACK);
            optionText.setTextAlignment(TextAlignment.CENTER);

            StackPane optionPane = new StackPane(optionText);
            optionPane.setLayoutX(20);
            optionPane.setLayoutY(120);
            optionPane.setPrefSize(260, 70);

            optionPane.setId("option");
            optionPane.getStylesheets().add("styles/buttonStyle.css");

            getChildren().addAll(optionPane);

            optionPane.setOnMouseClicked((event) -> {
                  optionAction(0);
            });
            optionPane.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });
      }

      private void addCategoryOption() {
            Text optionText = new Text("Categories");
            optionText.setFont(new Font("Century Gothic", 40));
            optionText.setStroke(Color.BLACK);
            optionText.setTextAlignment(TextAlignment.CENTER);

            StackPane optionPane = new StackPane(optionText);
            optionPane.setLayoutX(20);
            optionPane.setLayoutY(220);
            optionPane.setPrefSize(260, 70);

            optionPane.setId("option");
            optionPane.getStylesheets().add("styles/buttonStyle.css");

            getChildren().addAll(optionPane);

            optionPane.setOnMouseClicked((event) -> {
                  optionAction(1);
            });
            optionPane.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });
      }

      private void addSettingsOption() {
            Text optionText = new Text("Settings");
            optionText.setFont(new Font("Century Gothic", 40));
            optionText.setStroke(Color.BLACK);
            optionText.setTextAlignment(TextAlignment.CENTER);

            StackPane optionPane = new StackPane(optionText);
            optionPane.setLayoutX(20);
            optionPane.setLayoutY(320);
            optionPane.setPrefSize(260, 70);

            optionPane.setId("option");
            optionPane.getStylesheets().add("styles/buttonStyle.css");

            getChildren().addAll(optionPane);

            optionPane.setOnMouseClicked((event) -> {
                  optionAction(2);
            });
            optionPane.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });
      }

      private void addExitOption() {
            Text optionText = new Text("Exit");
            optionText.setFont(new Font("Century Gothic", 40));
            optionText.setStroke(Color.BLACK);
            optionText.setTextAlignment(TextAlignment.CENTER);

            StackPane optionPane = new StackPane(optionText);
            optionPane.setLayoutX(20);
            optionPane.setLayoutY(420);
            optionPane.setPrefSize(260, 70);

            optionPane.setId("option");
            optionPane.getStylesheets().add("styles/buttonStyle.css");

            getChildren().addAll(optionPane);

            optionPane.setOnMouseClicked((event) -> {
                  optionAction(3);
            });
            optionPane.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });
      }

      private void optionAction(int optionID) {
            clipPlayer.buttonPress();

            switch (optionID) {
                  case 0:
                        if (libraryIsHidden()) {
                              hideAllCategories();
                              hideSettings();
                              ContentPane.showLeft(ContentPane.libraryPane);
                        }
                        break;
                  case 1:
                        if (categoryIsHidden()) {
                              hideLibrary();
                              hideSettings();
                              ContentPane.showLeft(ContentPane.categories);
                        }
                        break;
                  case 2:
                        if (settingsIsHiddn()) {
                              hideLibrary();
                              hideAllCategories();
                              ContentPane.showLeft(ContentPane.settingsPane);
                        }
                        break;
                  case 3:
                        MainWindow.exitPane.setVisible(true);
                        MainWindow.disable();
                        break;
            }
      }

      private boolean libraryIsHidden() {
            return ContentPane.libraryPane.getIsHidden();
      }

      private boolean categoryIsHidden() {
            return ContentPane.rockCategory.getIsHidden()
             && ContentPane.rapCategory.getIsHidden()
             && ContentPane.popCategory.getIsHidden()
             && ContentPane.foreignCategory.getIsHidden();
      }

      private boolean settingsIsHiddn() {
            return ContentPane.settingsPane.getIsHidden();
      }

      private void hideLibrary() {
            ContentPane.hideLeft(ContentPane.libraryPane);
      }

      private void hideAllCategories() {
            ContentPane.hideRight(ContentPane.rockCategory);
            ContentPane.rockCategory.setIsHidden(true);

            ContentPane.hideRight(ContentPane.rapCategory);
            ContentPane.rapCategory.setIsHidden(true);

            ContentPane.hideRight(ContentPane.popCategory);
            ContentPane.popCategory.setIsHidden(true);

            ContentPane.hideRight(ContentPane.foreignCategory);
            ContentPane.foreignCategory.setIsHidden(true);

            ContentPane.hideLeft(ContentPane.categories);
            ContentPane.categories.setIsHidden(true);
      }

      private void hideSettings() {
            ContentPane.hideLeft(ContentPane.settingsPane);
      }
}
