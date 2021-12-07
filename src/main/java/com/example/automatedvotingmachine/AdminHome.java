package com.example.automatedvotingmachine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdminHome {
    @FXML
    private Button addACandidateButton;

    @FXML
    private Button addAPartyButton;

    @FXML
    private Button backButton;

    @FXML
    private Button showCandidateResultsButton;

    @FXML
    private Button showPartyResultsButton;

    @FXML
    void addACandidateButtonClicked(MouseEvent event) {
        EVMApplication EVMApplication = new EVMApplication();
        try {
            EVMApplication.changeScene("AddingACandidatePage.fxml");


        }
        catch(Exception e){
            System.out.println("Login page not loaded");


        }

    }

    @FXML
    void addAPartyButtonClicked(MouseEvent event) {

    }

    @FXML
    void backButtonClicked(MouseEvent event) {

    }

    @FXML
    void showCandidateResultsButtonClicked(MouseEvent event) {

    }

    @FXML
    void showPartyResultsButtonPressed(MouseEvent event) {

    }
}
