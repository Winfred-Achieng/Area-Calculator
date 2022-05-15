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

public class rectArea  extends Application {
    static Stage rectA = new Stage();
    @Override
    public void start(Stage stage) throws Exception {

        Button close_btn = new Button("Close");


        close_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Stage stage = (Stage) close_btn.getScene().getWindow();
                stage.close();
            }
        }));

        Text rect=new Text("Rectangle");
        Text w=new Text("w");
        Text l=new Text("l");
        Text ans=new Text("Answer");

        TextField wTf=new TextField();
        TextField lTf=new TextField();
        TextField ansTf=new TextField();

        Button arBtn=new Button("Area");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,300);
        gridPane.setVgap(20);
        gridPane.setHgap(40);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(rect,1,1);
        gridPane.add(w,1,2);
        gridPane.add(l,1,3);
        gridPane.add(ans,3,2);

        gridPane.add(wTf,2,2);
        gridPane.add(lTf,2,3);
        gridPane.add(ansTf,4,2);

        gridPane.add(arBtn,2,5);
        gridPane.add(close_btn, 4, 6);

        //Area of rectangle
        arBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if ((wTf.getText() == null || wTf.getText().trim().isEmpty()) || (lTf.getText() == null || lTf.getText().trim().isEmpty())) {
                    ansTf.setText("Incorrect inputs");
                } else {
                    double bRes = Double.parseDouble(wTf.getText());
                    double hRes = Double.parseDouble(lTf.getText());
                    double ans = (hRes * bRes);
                    ansTf.setText(Double.toString(ans));
                    System.out.println("The area of the rectangle is "+ans);
                }
            }
        }));

        //ensures decimal values only are accepted
        lTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String in = lTf.getText();
                if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    lTf.setText("");
                }
            }
        }));
        //ensures decimal values only are accepted
        wTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String in = wTf.getText();
                if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    wTf.setText("");
                }
            }
        }));

        Scene scene = new Scene(gridPane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    }

