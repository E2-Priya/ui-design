module FxmlTrail.FxmlTrail {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens FxmlTrail.FxmlTrail to javafx.fxml;
    exports FxmlTrail.FxmlTrail;
}
