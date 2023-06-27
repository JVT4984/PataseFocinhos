module com.example.semestralfd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.semestralfd to javafx.fxml;
    exports com.example.semestralfd;
}