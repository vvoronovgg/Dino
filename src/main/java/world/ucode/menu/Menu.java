package world.ucode.menu;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import world.ucode.game.*;


public class Menu {
    Stage stage;
    Group group;

    public Menu(Group group, Stage stage) {
        new Cloud(group);
        this.group = group;
        this.stage = stage;
        this.start();
    }

    public void start() {
        Heart heart = new Heart(group);
        new Score(group,heart);
        ElementMenu elementMenu = new ElementMenu(group);
        Background background = new Background(group);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(elementMenu.dinoImg);
        translateTransition.setByY(315);

        PauseTransition wait = new PauseTransition(Duration.millis(1300));
        translateTransition.setAutoReverse(false);

        stage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key)  {
                if (key.getCode() == KeyCode.ESCAPE)
                    stage.close();
                if (elementMenu.textDino.isVisible() && elementMenu.startBtn.isVisible() || elementMenu.exitBtn.isVisible()) {
                    if (elementMenu.dinoImg.getLayoutY() == 205) {
                        if (key.getCode() == KeyCode.ENTER) {
                            elementMenu.startBtn.setVisible(false);
                            elementMenu.exitBtn.setVisible(false);
                            elementMenu.textDino.setVisible(false);
                            translateTransition.setOnFinished(event -> background.getExplosion().setVisible(true));
                            translateTransition.play();

                            wait.setOnFinished((e) -> {
                                background.getExplosion().setVisible(false);
                                heart.hideHeart();
                                elementMenu.dinoImg.setVisible(false);
                                new Game(stage);
                            });
                            wait.play();
                        }
                        if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP) {
                            elementMenu.dinoImg.setLayoutY(255);
                        }
                    } else if (elementMenu.dinoImg.getLayoutY() == 255) {
                        if (key.getCode() == KeyCode.ENTER) {
                            Stage stage = (Stage) elementMenu.exitBtn.getScene().getWindow();
                            stage.close();
                        }
                        if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP) {
                            elementMenu.dinoImg.setLayoutY(205);
                        }
                    }
                }
            }
        });
        stage.show();
    }
}

