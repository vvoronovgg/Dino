package world.ucode.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Background {
    Group group;
    ImageView groundImgView = new ImageView(new Image("Ground.png"));
    ImageView groundImgView1 = new ImageView(new Image("Ground.png"));
    ImageView sunImgView = new ImageView(new Image("Sun.png"));
    ImageView explosion = new ImageView(new Image("explosion.gif"));

    public Background(Group group) {
        this.group = group;
        this.init();
    }

    public ImageView getSunImgView() {
        sunImgView.setLayoutX(50);
        sunImgView.setLayoutY(40);
        return sunImgView;
    }

    public ImageView getExplosion() {
        explosion.setFitHeight(75);
        explosion.setFitWidth(75);
        explosion.setLayoutX(280);
        explosion.setLayoutY(505);
        explosion.setVisible(false);
        return explosion;
    }

    public void animationGround() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(2000), new KeyValue(groundImgView.translateXProperty(), -800)),
                new KeyFrame(Duration.millis(2000), new KeyValue(groundImgView1.translateXProperty(), -800))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    public ImageView getGroundImgView() {
        groundImgView.setLayoutY(550);
        groundImgView.setLayoutX(0);
        groundImgView.setFitWidth(800);

        return groundImgView;
    }
    public ImageView getGroundImgView1() {
        groundImgView1.setLayoutY(550);
        groundImgView1.setLayoutX(800);
        groundImgView1.setFitWidth(800);

        return groundImgView1;
    }
    private void init() {
        this.group.getChildren().add(getGroundImgView());
        this.group.getChildren().add(getGroundImgView1());
        this.group.getChildren().add(getSunImgView());
        this.group.getChildren().add(getExplosion());
    }
}
