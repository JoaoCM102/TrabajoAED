module com.mycompany.trucable {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.trucable to javafx.fxml;
    exports com.mycompany.trucable;
}
