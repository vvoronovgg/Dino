package world.ucode.game;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Heart {
    Group group;
    ImageView heart;
    Image heartImg = new Image("heart.png");
    public ArrayList<ImageView> heartList = new ArrayList<ImageView>();

    public Heart(Group group) {
        this.group = group;
        positonHeart();
    }

    public void hideHeart() {
        for(int i = 0;i < heartList.size(); i++) {
            heartList.get(i).setVisible(i == 0);
        }
    }

    public void heartCollision() {
        if (!heartList.get(1).isVisible() &&
                heartList.get(2).isVisible() &&
                !heartList.get(3).isVisible()){
            heartList.get(1).setVisible(true);
            heartList.get(2).setVisible(false);
        }
        if (!heartList.get(1).isVisible() &&
                !heartList.get(2).isVisible() &&
                heartList.get(3).isVisible()) {
            heartList.get(1).setVisible(true);
            heartList.get(3).setVisible(false);
        }
        if (heartList.get(1).isVisible() &&
                !heartList.get(2).isVisible() &&
                heartList.get(3).isVisible()) {
            heartList.get(2).setVisible(true);
            heartList.get(3).setVisible(false);
        }
    }
    private void positonHeart() {
        for (int i = 0; i < 4; i++) {
            heart = new ImageView();
            heart.setImage(heartImg);
            heart.setFitWidth(100);
            heart.setPreserveRatio(true);
            heart.setLayoutX(560 + (i * 23));
            heart.setLayoutY(50);
            heartList.add(heart);
        }
        group.getChildren().addAll(heartList);
    }
}
