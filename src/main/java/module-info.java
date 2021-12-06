module com.example.ibranyilevente_masodfoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ibranyilevente_masodfoku to javafx.fxml;
    exports com.example.ibranyilevente_masodfoku;
}