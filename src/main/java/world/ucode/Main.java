package world.ucode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import world.ucode.menu.Menu;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        stage.setTitle("Dino");
        stage.getIcons().add(new Image("Dino-stand.png"));
        stage.setScene(new createScene(group).create());
        stage.setResizable(false);
        new Menu(group,stage);
    }
}