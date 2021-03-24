package world.ucode.game;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Character {
    Group group;
    public ImageView dinoImg = new ImageView(new Image("Dino-stand.png"));

    public AnimationTimer animationTimer;
    private boolean status = true;
    PauseTransition wait = new PauseTransition(Duration.millis(25));


    public  Character(Group group) {
        this.group = group;
        dinoImg.setLayoutX(120);
        dinoImg.setLayoutY(520);
        this.animationRun();
        this.animationJump();
        this.group.getChildren().add(dinoImg);
    }

    private void animationRun() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        dinoImg.setImage(new Image("Dino-left-up.png"));
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        dinoImg.setImage(new Image("Dino-right-up.png"));
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    public AnimationTimer animationJump() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dinoImg.getLayoutY() >= 400 && status) {
                    dinoImg.setLayoutY(dinoImg.getLayoutY() - 8);
                    if (dinoImg.getLayoutY() <= 400) {
                        wait.setOnFinished(e -> status = false);
                        wait.play();
                    }
                }

                if (!status) {
                    dinoImg.setLayoutY(dinoImg.getLayoutY() + 6.5);
                    if (dinoImg.getLayoutY() >= 520) {
                        status = true;
                        animationTimer.stop();
                    }
                }
            }
        };
        return animationTimer;
    }

}
