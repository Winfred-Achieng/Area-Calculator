package com.example.areas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Text txt_lbl=new Text("Click to calculate the area of the following");

        Button tri_btn = new Button("Triangle");
        Button rect_btn = new Button("Rectangle");
        Button circ_btn = new Button("Circle");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,300);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

//triangle button window
        tri_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                triArea  triA = new triArea();
                try {
                    triA.start(triArea.triA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
//rectangle button window
        rect_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                rectArea  rectA = new rectArea();
                try {
                    rectA.start(rectArea.rectA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));
//circle button window
        circ_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                circArea  circA = new circArea();
                try {
                    circA.start(circArea.circA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));

        gridPane.add(tri_btn, 2, 3);
        gridPane.add(rect_btn, 3, 3);
        gridPane.add(circ_btn, 4, 3);

        gridPane.add(txt_lbl, 1, 1);


        Scene scene = new Scene(gridPane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}