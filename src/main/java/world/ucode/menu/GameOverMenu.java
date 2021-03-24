package world.ucode.menu;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import world.ucode.createScene;
import world.ucode.game.Game;


public class GameOverMenu {
    public Stage primaryStage;
    public Group group = new Group();

    public GameOverMenu(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.init();
    }

    public void start() {
        primaryStage.setScene(new createScene(group).create());
        primaryStage.centerOnScreen();
        group.setStyle("-fx-background-color: linear-gradient(to bottom, #C0C0C0, #ffffff);");
    }

    public Parent startBtn() {
        Text gameOver = new Text(50.0, 90.0,"Game Over");

        gameOver.setFill(Color.rgb(81, 90, 90));
        gameOver.setStroke(Color.rgb(23, 32, 42));
        gameOver.setStrokeWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gameOver.setFont(theFont);

        gameOver.setX(300);
        gameOver.setY(100);

        ImageView retryIm = new ImageView(new Image("Game_restart.png"));
        Button retryBtn = new Button();
        Group group = new Group(retryBtn,retryIm,gameOver);
        Text textRetry = new Text(30.0, 80.0,"Retry");
        Font fontRetry = Font.font("Times New Roman", FontWeight.BOLD, 48);
        textRetry.setFont(fontRetry);
        textRetry.setFill(Color.rgb(81, 90, 90));
        textRetry.setStrokeWidth(2);
        textRetry.setStroke(Color.rgb(23, 32, 42));

        retryBtn.setGraphic(textRetry);
        retryBtn.setLayoutX(350);
        retryBtn.setLayoutY(200);
        retryBtn.setStyle("-fx-background-color: transparent;");

        retryIm.setLayoutX(280);
        retryIm.setLayoutY(190);

        retryBtn.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.ENTER) {
                    retryBtn.setVisible(false);
                    retryIm.setVisible(false);
                    gameOver.setVisible(false);
                    new Game(primaryStage);
                }
            }
        });

        return group;
    }

    public void init() {
        this.group.getChildren().add(this.startBtn());
    }
}
