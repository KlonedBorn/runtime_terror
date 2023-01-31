module edu.uwi.projects {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens edu.uwi.projects to javafx.fxml;
    exports edu.uwi.projects;
}