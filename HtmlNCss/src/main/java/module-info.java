module HtmlNCss.HtmlNCss {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.web;
	requires jdk.jsobject;
	requires java.base;
	requires javafx.graphics;

    opens HtmlNCss.HtmlNCss to javafx.fxml;
    exports HtmlNCss.HtmlNCss;
}
