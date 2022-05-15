module com.example.areas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.areas to javafx.fxml;
    exports com.example.areas;
}