module basic.BasicFX {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens basic.BasicFX to javafx.fxml;
    exports basic.BasicFX;
}
