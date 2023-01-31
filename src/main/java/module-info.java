module edu.uwi.projects {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.uwi.projects to javafx.fxml;
    exports edu.uwi.projects;
}
