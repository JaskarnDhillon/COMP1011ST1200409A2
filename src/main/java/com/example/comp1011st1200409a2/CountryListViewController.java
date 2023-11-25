package com.example.comp1011st1200409a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CountryListViewController {

    @FXML
    private ListView<?> countriesListView;

    @FXML
    private ImageView countryImage;

    @FXML
    private Label countryNameLabel;

    @FXML
    private Label resultsLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    void getCountryDetails(ActionEvent event) {

    }

}
