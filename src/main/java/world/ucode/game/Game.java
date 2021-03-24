package world.ucode.game;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import world.ucode.createScene;
import world.ucode.menu.GameOverMenu;

public class Game {
    public Stage primaryStage;
    Group group = new Group();
    Background background = new Background(group);
    Heart heart = new Heart(group);
    Score score = new Score(group,heart);
    Cactus cactus = new Cactus(group);
    Character dino = new Character(group);
    boolean one = true;

    public Game(Stage primaryStage) {
        new Cloud(group);
        this.primaryStage = primaryStage;
        this.init();
    }

    private void init() {
        background.getExplosion().setVisible(false);
        heart.hideHeart();
        start();
        background.animationGround();
        score.time();
        collision(cactus,dino,heart);
        primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent key) {
                if (key.getCode() == KeyCode.UP)
                    dino.animationTimer.start();
            }
        });
    }

    private void collision(Cactus cactus,Character dino,Heart heart) {
        int i =0;
        int x = 4;
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.3), evt -> dino.dinoImg.setVisible(false)),
                new KeyFrame(Duration.seconds( 0.7), evt -> dino.dinoImg.setVisible(true)));
        timeline.setCycleCount(3);
        PauseTransition wait = new PauseTransition(Duration.seconds(1));
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        for (ImageView i : cactus.getListImageView()) {
                            if (dino.dinoImg.getBoundsInParent().intersects(i.getLayoutX() + 0, i.getLayoutY() + 0,
                                    i.getBoundsInParent().getWidth() - 16,
                                    i.getBoundsInParent().getHeight() - 16) && one && heart.heartList.get(0).isVisible()) {
                                if (heart.heartList.get(1).isVisible() &&
                                        heart.heartList.get(2).isVisible() &&
                                        heart.heartList.get(3).isVisible()) {
                                    timeline.play();
                                    heart.heartList.get(3).setVisible(false);
                                }
                                if (timeline.getStatus() == Animation.Status.STOPPED) {
                                    if (heart.heartList.get(1).isVisible() &&
                                            heart.heartList.get(2).isVisible() &&
                                            !heart.heartList.get(3).isVisible()) {
                                        timeline.play();
                                        heart.heartList.get(2).setVisible(false);
                                    }
                                }
                                if (timeline.getStatus() == Animation.Status.STOPPED) {
                                    if (heart.heartList.get(1).isVisible() &&
                                            !heart.heartList.get(2).isVisible() &&
                                            !heart.heartList.get(3).isVisible()) {
                                        timeline.play();
                                        heart.heartList.get(1).setVisible(false);
                                    }
                                }
                                if (timeline.getStatus() == Animation.Status.STOPPED) {
                                    if (heart.heartList.get(0).isVisible() &&
                                            !heart.heartList.get(1).isVisible() &&
                                            !heart.heartList.get(2).isVisible() &&
                                            !heart.heartList.get(3).isVisible()) {
                                        one = false;
                                        new GameOverMenu(primaryStage).start();
                                    }
                                }
                            }
                        }
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
    private void start() {
        primaryStage.setScene(new createScene(group).create());
        primaryStage.centerOnScreen();
    }
}
