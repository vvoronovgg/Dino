package world.ucode.game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Score {
    Group group;
    Heart heart;
    Text score = new Text(600, 30, "Score: 00000");
    public int counter = 0;

    public Score(Group group,Heart heart) {
        this.group = group;
        this.heart = heart;
        this.score.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 16; -fx-text-fill: #535353;");
        group.getChildren().add(this.score);
    }

    public void time() {
        Timeline t = new Timeline(
                new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent t) {
                        counter++;
                        score.setText("Score: " + String.format("%05d", counter));
                        heartAdd(counter);
                    }
                })
        );
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    private void heartAdd(int counter) {
        for(int i = 1; i < heart.heartList.size();i++) {
            if (counter == 500 * i){
                heart.heartList.get(i).setVisible(true);
            }
            heart.heartCollision();
        }

    }
}