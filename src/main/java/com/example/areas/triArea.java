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

public class triArea extends Application {
    static Stage triA = new Stage();
    @Override
    public void start(Stage stage) throws Exception {

        Button close_btn = new Button("Close");

        close_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Stage stage = (Stage) close_btn.getScene().getWindow();
                stage.close();
            }
        }));

        Text tri=new Text("Triangle");
        Text b=new Text("b");
        Text h=new Text("h");
        Text ans=new Text("Answer");

        TextField bTf=new TextField();
        TextField hTf=new TextField();
        TextField ansTf=new TextField();

        Button arBtn=new Button("Area");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,300);
        gridPane.setVgap(20);
        gridPane.setHgap(40);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(tri,2,1);
        gridPane.add(b,1,2);
        gridPane.add(h,1,3);
        gridPane.add(ans,3,2);

        gridPane.add(bTf,2,2);
        gridPane.add(hTf,2,3);
        gridPane.add(ansTf,4,2);

        gridPane.add(arBtn,1,4);
        gridPane.add(close_btn, 4, 6);

        //Area of triangle
        arBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if((bTf.getText()==null || bTf.getText().trim().isEmpty())|| (hTf.getText()==null || hTf.getText().trim().isEmpty())){
                    ansTf.setText("Incorrect inputs");
                }
                else{
                    double bRes=Double.parseDouble(bTf.getText());
                    double hRes=Double.parseDouble(hTf.getText());
                    double ans=(hRes*bRes)*1/2;
                    ansTf.setText(Double.toString(ans));
                    System.out.println("The area of the triangle is "+ans);
                }
            }
        }));

        //ensures decimal values only are accepted
        bTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String in = bTf.getText();
                if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    bTf.setText("");
                }
            }
        }));
        //ensures decimal values only are accepted
        hTf.setOnKeyReleased((new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String in = hTf.getText();
                if (!in.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    hTf.setText("");
                }
            }
        }));


        Scene scene = new Scene(gridPane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
}
