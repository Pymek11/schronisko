module com.example.schronisko {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.schronisko to javafx.fxml;
    exports com.example.schronisko;
}