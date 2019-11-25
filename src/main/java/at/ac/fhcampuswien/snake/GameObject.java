package at.ac.fhcampuswien.snake;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;


public class GameObject {
    private final Rectangle food = new Rectangle(20, 20); //public um X/Y Koordinaten zu bekommen
    private double redPart, greenPart, bluePart;
    private Bounds fbound;

    public GameObject() {

    }

    double[] getColor() { // returned ein double Array mit den Farben für den Schwanz der Schlange, wird nacher von eat aufgerufen
        double[] colors = new double[3];
        colors[0] = redPart;
        colors[1] = greenPart;
        colors[2] = bluePart;
        return colors;

    }


    void setFood(Group g, Stage stage) {
        g.getChildren().remove(food);//um vorheriges Food verschwinden zu lassen
        Random rand = new Random();

        food.setFill(Color.color(redPart = rand.nextDouble(), greenPart = rand.nextDouble(), bluePart = rand.nextDouble())); // hier werden zufällige Farben für das Food (und damit auch den Tail) übergeben
        food.relocate(rand.nextInt((int) stage.getWidth() - 50), rand.nextInt((int) stage.getHeight() - 50)); // Random Location mit Abstand vom Rand jeweils 40
        g.getChildren().add(food);
        fbound = food.getBoundsInParent();

    }

    Bounds getBound() {
        return fbound;
    }


}
