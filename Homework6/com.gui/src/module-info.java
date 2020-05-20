module com.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.providers;
    requires com.services;

    opens gui to javafx.fxml;
    exports gui;
}