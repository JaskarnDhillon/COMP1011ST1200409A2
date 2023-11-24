module com.example.comp1011st1200409a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;



    opens com.example.comp1011st1200409a2 to javafx.fxml, com.google.gson;
    exports com.example.comp1011st1200409a2;
}