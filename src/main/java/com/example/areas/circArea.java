package com.example.areas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class circArea extends Application {
    static Stage circA=new Stage();
    @Override
    public void start(Stage stage) throws Exception {

        Button close_btn = new Button("Close");


        close_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Stage stage = (Stage) close_btn.getScene().getWindow();
                stage.close();
            }
        }));

        Text cir=new Text("Circle");
        Text r=new Text("r");
        Text ans=new Text("Answer");

        TextField rTf=new TextField();
        TextField ansTf=new TextField();

        Button arBtn=new Button("Area");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,300);
        gridPane.setVgap(20);
        gridPane.setHgap(40);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(cir,1,1);
        gridPane.add(r,1,2);
        gridPane.add(ans,3,2);

        gridPane.add(rTf,2,2);
        gridPane.add(ansTf,4,2);

        gridPane.add(arBtn,2,4);
        gridPane.add(close_btn, 4, 6);

        //Area of triangle
        arBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if ((rTf.getText() == null || rTf.getText().trim().isEmpty())) {
                    ansTf.setText("Incorrect inputs");
                } else {
                    double rRes = Double.parseDouble(rTf.getText());
                    double ans =Math.PI*rRes*rRes ;
                    ansTf.setText(Double.toString(ans));
                    System.out.println("The area of the circle is "+ans);
                }
            }
        }));
        // ensures decimal values only are accepted
        rTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String in = rTf.getText();
                if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    rTf.setText("");
                }
            }
        }));

        Scene scene = new Scene(gridPane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}
