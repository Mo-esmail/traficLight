module com.example.trafficLight {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.trafficLight;
    opens com.trafficLight to javafx.fxml;
}