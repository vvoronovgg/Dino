package world.ucode;

import javafx.scene.Group;
import javafx.scene.Scene;

public class createScene {
    Group group = new Group();

    public createScene(Group group) {
        this.group = group;
    }

    public Scene create() {
        return new Scene(this.group, 800, 600);
    }
}
