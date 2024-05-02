module com.example.currencytranslator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.json;


    opens com.example.currencytranslator to javafx.fxml;
    exports com.example.currencytranslator;
}