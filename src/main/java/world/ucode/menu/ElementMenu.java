package world.ucode.menu;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ElementMenu {
    Group group;
    Text textDino = new Text(50.0, 90.0,"Dino");
    Button startBtn = new Button();
    Button exitBtn = new Button();
    ImageView dinoImg = new ImageView(new Image("Dino-stand.png"));
    Font font = Font.font("Times New Roman", FontWeight.BOLD, 48);

    public ElementMenu(Group group) {
        this.group = group;
        this.init();
    }

    public ImageView getdinoImg() {
        dinoImg.setFitWidth(45);
        dinoImg.setFitHeight(45);
        dinoImg.setPreserveRatio(true);
        dinoImg.setLayoutX(300);
        dinoImg.setLayoutY(205);

        return dinoImg;
    }

    public Text getTextDino() {
        textDino.setFill(Color.rgb(81, 90, 90));
        textDino.setStroke(Color.rgb(23, 32, 42));
        textDino.setStrokeWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        textDino.setFont(theFont);

        textDino.setX(350);
        textDino.setY(100);
        return textDino;
    }

    public Parent setButton() {
        Group gb = new Group(startBtn,exitBtn);
        String strStart = "Start";
        Text textStart = new Text(30.0, 80.0,strStart);
        textStart.setFont(font);
        textStart.setFill(Color.rgb(81, 90, 90));
        textStart.setStrokeWidth(2);
        textStart.setStroke(Color.rgb(23, 32, 42));

        startBtn.setGraphic(textStart);
        startBtn.setLayoutX(350);
        startBtn.setLayoutY(200);
        startBtn.setStyle("-fx-background-color: transparent;");

        String strExit = "Exit";
        Text textExit = new Text(50.0, 90.0,strExit);
        textExit.setFont(font);
        textExit.setFill(Color.rgb(81, 90, 90));
        textExit.setStrokeWidth(2);
        textExit.setStroke(Color.rgb(23, 32, 42));

        exitBtn.setGraphic(textExit);
        exitBtn.setLayoutX(350);
        exitBtn.setLayoutY(250);
        exitBtn.setStyle("-fx-background-color: transparent;");

        return gb;
    }

    private void init() {
        group.getChildren().add(getTextDino());
        group.getChildren().add(setButton());
        group.getChildren().add(getdinoImg());
    }
}
