package com.trafficLight;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Main extends Application {
    //two variables to carry the dimensions of the scene
    private double paneWidth = 300;
    private double paneHeight = 300;

    // Override the getPane() method in the super class
    @Override
    public void start(Stage primaryStage) {
        //pane to contain the trafficLight
        StackPane pane = new StackPane();
        // a black rectangle to be the background for the TrafficLightsCopy
        Rectangle rectangle = new Rectangle(125, 250, 125, 300);
        //add the rectangle to the pane
        pane.getChildren().add(rectangle);
        //the the rectangle to black
        rectangle.setFill(Color.BLACK);
        rectangle.setStroke(Color.BLACK);
        //a GridPane to contain the 3 traffic lights
        GridPane pane1 = new GridPane();
        //make the alignment of it's components to center
        pane1.setAlignment(Pos.CENTER);
        //set padding around the components
        pane1.setPadding(new Insets(5, 5, 5, 5));
        pane1.setHgap(5);
        pane1.setVgap(5);
        //add the pane1 to pane
        pane.getChildren().add(pane1);

        //create 3 gray circles for traffic lights
        Circle circle = new Circle(paneWidth / 2, 60, 40);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.GREY);
        pane1.add(circle, 1, 1);

        Circle circle1 = new Circle(paneWidth / 2, 60, 40);
        circle1.setStroke(Color.BLACK);
        circle1.setFill(Color.GREY);
        pane1.add(circle1, 1, 2);

        Circle circle2 = new Circle(paneWidth / 2, 60, 40);
        circle2.setStroke(Color.BLACK);
        circle2.setFill(Color.GREY);
        pane1.add(circle2, 1, 3);
        //3 RadioButtons for each state of the light
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        //create a toggle group for the select state
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        //create a hbox to set all the 3 RadioButtons in one row
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(rbRed, rbYellow, rbGreen);
        hBox.setAlignment(Pos.CENTER);
        //set the layout
        BorderPane borderPane = new BorderPane();
        //add the trafficLights in the the center
        borderPane.setCenter(pane);
        //add the sellect mode to the button
        borderPane.setBottom(hBox);
        //a scene to show the gui
        Scene scene = new Scene(borderPane, paneWidth, paneHeight + 40);
        // set the program title
        primaryStage.setTitle("RadioButtonDemo");
        //add the scene to the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();

        //this happens when rbRed is selected
        rbRed.setOnAction(e -> {
            // set the first circle to red and gray the other 2 circles
            circle.setFill(Color.RED);
            circle1.setFill(Color.GREY);
            circle2.setFill(Color.GREY);
        });

        //this happens when rbYellow is selected
        rbYellow.setOnAction(e -> {
            // set the second circle to YELLOW and gray the other 2 circles
            circle.setFill(Color.GREY);
            circle1.setFill(Color.YELLOW);
            circle2.setFill(Color.GREY);
        });

        //this happens when rbGreen is selected
        rbGreen.setOnAction(e -> {
            // set the third circle to GREEN and gray the other 2 circles
            circle.setFill(Color.GREY);
            circle1.setFill(Color.GREY);
            circle2.setFill(Color.GREEN);
        });

    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}