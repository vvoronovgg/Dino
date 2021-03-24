package world.ucode.game;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Cloud {
    Group group;
    Image cloudLilImg = new Image("Cloud.png");
    Image cloudBigImg = new Image("Cloud-min.png");
    ImageView cloudImageViewOne = new ImageView(this.cloudLilImg);
    ImageView cloudImageViewTwo = new ImageView(this.cloudLilImg);
    ImageView cloudImageViewTree = new ImageView(this.cloudBigImg);
    ImageView cloudImageViewFour = new ImageView(this.cloudLilImg);
    ImageView cloudImageVieFive = new ImageView(this.cloudBigImg);
    ImageView cloudImageVieSix = new ImageView(this.cloudLilImg);

    public Cloud(Group group) {
        this.group = group;
        this.setCloudLayoute();
        this.setAnimation();
        this.setImage();

    }
    public void setCloudLayoute() {
        cloudImageViewOne.setLayoutX(700);
        cloudImageViewOne.setLayoutY(200);

        cloudImageViewTwo.setLayoutX(1400);
        cloudImageViewTwo.setLayoutY(130);

        cloudImageViewTree.setLayoutX(1000);
        cloudImageViewTree.setLayoutY(160);

        cloudImageViewFour.setLayoutX(2200);
        cloudImageViewFour.setLayoutY(200);

        cloudImageVieFive.setLayoutX(2500);
        cloudImageVieFive.setLayoutY(160);

        cloudImageVieSix.setLayoutX(3000);
        cloudImageVieSix.setLayoutY(130);
    }

    public void setAnimation() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageViewOne.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageViewTwo.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageViewTree.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageViewFour.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageVieFive.translateXProperty(), -1500)),
                new KeyFrame(Duration.seconds(20), new KeyValue(cloudImageVieSix.translateXProperty(), -1500))
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    protected void setImage() {
        group.getChildren().add(cloudImageViewOne);
        group.getChildren().add(cloudImageViewTwo);
        group.getChildren().add(cloudImageViewTree);
        group.getChildren().add(cloudImageViewFour);
        group.getChildren().add(cloudImageVieFive);
        group.getChildren().add(cloudImageVieSix);
    }
}
