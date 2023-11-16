module com.mycompany.trucable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires jakarta.persistence;

    opens com.mycompany.trucable.vistas to javafx.fxml;
    exports com.mycompany.trucable;
}
