package com.example.comp1011st1200409a2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Arrays;

public class CountryInfoViewController implements LoadData{

    @FXML
    private Label areaLabel;

    @FXML
    private Label capitalLabel;

    @FXML
    private ImageView countryImageView;

    @FXML
    private Label countryNameLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label populationLabel;

    @FXML
    private Label regionLabel;

    @FXML
    private Label subregionLabel;

    /**
     * method below references the SceneChanger class
     * and will take the user to another view
     * when a button in the view is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    void goBack(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "country-list-view.fxml");
    }

    /**
     * method below is inherited from the LoadData interface,
     * the method accepts a param and will generate information
     * for a new scene
     * @param countryName
     */
    public void loadData(String countryName){
        try {
            /**
             * all controls had to updated via a steam because json object
             * was wrapped in an array in the api response, thus took a bit
             * of extra work to access the class method and return them as Strings
             */
            CountryInfo[] countryInfos = APIUtility.callAPI(countryName);
            countryNameLabel.setText(Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getName())
                    .toList().toString().replaceAll("\\[|\\]", ""));
            countryImageView.setImage(new Image(Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getFlags())
                    .toList().toString().replaceAll("\\[|\\]", "")));
            nameLabel.setText("Common Name: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getName().getCommon())
                    .toList().toString().replaceAll("\\[|\\]", ""));
            regionLabel.setText("Region: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getRegion())
                    .toList().toString().replaceAll("\\[|\\]", ""));
            subregionLabel.setText("Subregion: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getSubregion())
                    .toList().toString().replaceAll("\\[|\\]", ""));
            capitalLabel.setText("Capital: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getCapital())
                    .toList().toString().replaceAll("\\[|\\]", ""));
            areaLabel.setText("Area: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getArea())
                    .toList().toString().replaceAll("\\[|\\]", "")+"km\u00B2");
            populationLabel.setText("Population: "+Arrays.stream(countryInfos)
                    .map(countryInfo -> countryInfo.getPopulation())
                    .toList().toString().replaceAll("\\[|\\]", ""));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
