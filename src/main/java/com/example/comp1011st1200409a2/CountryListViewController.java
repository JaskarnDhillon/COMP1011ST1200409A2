package com.example.comp1011st1200409a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CountryListViewController {

    @FXML
    private ListView<CountryInfo> countriesListView;

    @FXML
    private ImageView countryImage;

    @FXML
    private Label countryNameLabel;

    @FXML
    private VBox countryVBox;

    @FXML
    private Label resultsLabel;

    @FXML
    private TextField searchTextField;

    /**
     * method below populates a list view after the user types into the
     * search text field and clicks a button.
     * If the search is valid and does not throw an exception
     * the listview + all corresponding labels will be populated via updateLabels()
     * else a label will be populated with an error message
     * @param event
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    void searchCountry(ActionEvent event) throws IOException, InterruptedException {
        countryVBox.setVisible(false);
        String searchTerm = searchTextField.getText().trim();

        //try catch below implemented to display an error message when
        //an invalid search term is entered
        try {
            CountryInfo[] countryInfos = APIUtility.callAPI(searchTerm);
            countriesListView.getItems().clear();
            resultsLabel.setVisible(true);
            countriesListView.getItems().addAll(countryInfos);
            updateLabels();
        }catch (Exception e){
            countriesListView.getItems().clear();
            resultsLabel.setVisible(true);
            resultsLabel.setText("No countries found matching: "+searchTerm);
        }
    }

    /**
     * method directs the user to another scene via changeScenes(),
     * while storing a string value to help populate the next scene
     * @param event
     * @throws IOException
     */
    @FXML
    void getCountryDetails(ActionEvent event) throws IOException {
        CountryInfo countrySelected = countriesListView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes
                (event,"country-info-view.fxml", String.valueOf(countrySelected.getName()));
    }

    /**
     * method on initialization will set certain
     * members on the scene
     */
    @FXML
    public void initialize(){
        countryVBox.setVisible(false);
        resultsLabel.setVisible(false);

        countriesListView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, countrySelected) -> {
                    if (countrySelected!=null){
                        countryVBox.setVisible(true);
                        countryImage.setImage(new Image(countrySelected.getFlags().getPng()));
                        countryNameLabel.setText(String.valueOf(countrySelected.getName()));
                    }
                });
    }

    /**
     * method sets the text for resultsLabel
     */
    private void updateLabels(){
        resultsLabel.setText("Results: " + countriesListView.getItems().size() + " countries/country");
    }

}
