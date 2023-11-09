module com.example.comp1011st1200409a2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1011st1200409a2 to javafx.fxml;
    exports com.example.comp1011st1200409a2;
}