package asatunes;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SettingsPane extends GridPane {

      private boolean isHidden;
      private final ClipPlayer clipPlayer;

      public SettingsPane() {
            isHidden = true;
            clipPlayer = new ClipPlayer();

            setTranslateX(-600);
            setVisible(false);
            setVgap(80);
            setAlignment(Pos.CENTER);
            addSettings();
            getStylesheets().add("styles/settings.css");
      }

      private void addSettings() {
            add(title(), 0, 0);
            add(toggleUISound(), 0, 1);
      }

      private Text title() {
            Text txtTitle = new Text("Settings:");
            txtTitle.setFont(new Font("Century Gothic", 50));
            txtTitle.setUnderline(true);
            txtTitle.setFill(Color.valueOf("#F2AE72"));
            txtTitle.setStroke(Color.valueOf("#F2AE72"));
            txtTitle.setStrokeWidth(1.4);

            return txtTitle;
      }

      private CheckBox toggleUISound() {
            CheckBox chkEnableUISound = new CheckBox("Enable button sound effects");
            chkEnableUISound.setFont(new Font("Century Gothic", 26));
            chkEnableUISound.setTextFill(Color.valueOf("#F2AE72"));
            chkEnableUISound.setSelected(true);
            chkEnableUISound.setOnAction((event) -> {
                  ClipPlayer.toggleUISound();
                  clipPlayer.buttonPress();
            });
            chkEnableUISound.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });
            chkEnableUISound.setId("option");

            return chkEnableUISound;
      }
      
      public boolean getIsHidden() {
            return isHidden;
      }

      public void setIsHidden(boolean isHidden) {
            this.isHidden = isHidden;
      }
}
