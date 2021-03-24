package world.ucode.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Cactus {
    Group group;
    ImageView cactus;
    Image cactusOne = new Image("Cactus-1.png");
    Image cactusTwo = new Image("Cactus-2.png");
    Image cactusTree = new Image("Cactus-3.png");
    Image cactusFore = new Image("Cactus-4.png");
    Image cactusFive = new Image("Cactus-5.png");
    ArrayList<Image> listImage = new ArrayList<>();
    ArrayList<ImageView> listImageView = new ArrayList<>();


    public Cactus(Group group) {
        this.group = group;
        this.setListImage();
        this.setPositionImg();
        this.animation().start();
    }


    public void setListImage() {
        listImage.add(cactusOne);
        listImage.add(cactusTwo);
        listImage.add(cactusTree);
        listImage.add(cactusFore);
        listImage.add(cactusFive);
    }

    public ArrayList<ImageView> getListImageView() {
        return listImageView;
    }

    public void setPositionImg() {
        for (int i = 0; i < listImage.size(); i++) {
            cactus = new ImageView();
            cactus.setImage(listImage.get(i));
            if(i == 0)
                cactus.setLayoutY(515);
            if(i == 1)
                cactus.setLayoutY(515);
            if(i == 2)
                cactus.setLayoutY(515);
            if(i == 3)
                cactus.setLayoutY(530);
            if(i == 4)
                cactus.setLayoutY(530);
            cactus.setLayoutX(random());
            listImageView.add(cactus);
        }
        group.getChildren().addAll(listImageView);
    }

    private double random() {
        double result = 800 + (int) (Math.random() * 15) * 100;

        for (ImageView y : listImageView) {
            if (Math.abs(result - y.getLayoutX()) < 250)
                result = -50;
        }
        return result;
    }


    public AnimationTimer animation() {
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (ImageView i : listImageView) {
                    i.setLayoutX(i.getLayoutX() - 6.65);
                    //6.65
                    if (i.getLayoutX() < -50) {
                        i.setLayoutX(random());
                    }
                }
            }
        };
        return animation;
    }
}
