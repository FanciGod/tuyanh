module com.controllerfx.projectv4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.controllerfx.projectv4 to javafx.fxml;
    exports com.controllerfx.projectv4;
    exports entity;
    opens entity to javafx.base, javafx.fxml;
}