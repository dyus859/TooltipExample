module com.example.tooltipexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tooltipexample to javafx.fxml;
    exports com.example.tooltipexample;
}