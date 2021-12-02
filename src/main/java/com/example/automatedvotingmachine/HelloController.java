package com.example.automatedvotingmachine;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
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
        Voter voter = new Voter();
        boolean isPresent = voter.validateVoter(username.getText(), password.getText());
        if(isPresent){
            HelloApplication  helloApplication = new HelloApplication();
            try {
                helloApplication.changeScene("VotingPage.fxml");
            }
            catch(Exception e){
                System.out.println("Login page not loaded");


            }
        }


    }

    public void registerANewButtonClicked(ActionEvent actionEvent) {
        System.out.println("Register a new New User Button Clicked!!!");
    }

    public void LogInAsAdminButtonClicked(ActionEvent actionEvent) {
        System.out.println("Log In As New Admin Button Clicked!!!");
    }
}