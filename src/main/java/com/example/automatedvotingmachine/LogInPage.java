package com.example.automatedvotingmachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LogInPage {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("Voter Registered");
    }



    public void logInMouseClicked(MouseEvent mouseEvent) {
        System.out.println("Login button clicked!!!");
        EVM evm = new EVM();
        boolean isPresent = evm.validateVoter(username.getText(), password.getText());
        if(isPresent){
            EVMApplication EVMApplication = new EVMApplication();
            try {
                EVMApplication.changeScene("VotingPage.fxml");


            }
            catch(Exception e){
                System.out.println("Login page not loaded");


            }
        }


    }


    @FXML
    void registerANewButtonClicked(MouseEvent event) {
        System.out.println("Register a new New User Button Clicked!!!");
        EVMApplication EVMApplication = new EVMApplication();
        try {
            EVMApplication.changeScene("VoterRegistrationPage.fxml");


        }
        catch(Exception e){
            System.out.println("Login page not loaded");


        }
    }
    @FXML
    void AdminButtonClicked(MouseEvent event) {
        System.out.println("Admin button clicked!!!");
        EVMApplication EVMApplication = new EVMApplication();
        try {
            EVMApplication.changeScene("AdminLogIn.fxml");


        }
        catch(Exception e){
            System.out.println("Login page not loaded");


        }
    }

}