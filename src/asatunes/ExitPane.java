package asatunes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ExitPane extends GridPane {

      private final ClipPlayer clipPlayer;

      public ExitPane() {
            clipPlayer = new ClipPlayer();

            setVisible(false);

            setTranslateX(1920 / 6.5);
            setTranslateY(1080 / 4.5);
            setAlignment(Pos.CENTER);
            setVgap(40);

            Text txtMessage = new Text("Are you sure you want to exit?");
            txtMessage.setFont(new Font("Century Gothic", 30));
            txtMessage.setFill(Color.valueOf("#588C7E"));
            txtMessage.setStroke(Color.valueOf("#588C7E"));
            txtMessage.setStrokeWidth(1.4);

            Button btnYes = new Button("Yes");
            btnYes.setFont(new Font("Century Gothic", 24));
            btnYes.setPrefSize(100, 30);
            btnYes.setId("button");
            btnYes.setTranslateX(100);

            btnYes.setOnAction((event) -> {
                  clipPlayer.buttonPress();
                  System.exit(0);
            });
            btnYes.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            Button btnNo = new Button("No");
            btnNo.setFont(new Font("Century Gothic", 24));
            btnNo.setPrefSize(100, 30);
            btnNo.setId("button");
            btnNo.setTranslateX(-100);

            btnNo.setOnAction((event) -> {
                  clipPlayer.buttonPress();
                  setVisible(false);
                  MainWindow.enable();
            });
            btnNo.setOnMouseEntered((event) -> {
                  clipPlayer.buttonHover();
            });

            add(txtMessage, 1, 0);
            add(btnYes, 0, 1);
            add(btnNo, 2, 1);
            setId("border");
            getStylesheets().add("styles/exitPane.css");
      }
}
