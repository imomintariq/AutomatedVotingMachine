package com.example.automatedvotingmachine;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminLogIn {

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField password;

    @FXML
    private Button registerAsAdminButton;

    @FXML
    private TextField username;

    @FXML
    void loginButtonClicked(MouseEvent event) {
        System.out.println("Login button clicked!!!");
        EVM evm = new EVM();
        boolean isPresent = evm.validateAdmin(username.getText(), password.getText());
        if(isPresent){
            EVMApplication EVMApplication = new EVMApplication();
            try {
                EVMApplication.changeScene("AdminHome.fxml");


            }
            catch(Exception e){
                System.out.println("Login page not loaded");


            }
        }

    }

    @FXML
    void registerAsAdminButtonPressed(MouseEvent event) {

    }
    @FXML
    void backButtonClicked(MouseEvent event) {
        EVMApplication EVMApplication = new EVMApplication();
        try {
            EVMApplication.changeScene("hello-view.fxml");


        }
        catch(Exception e){
            System.out.println("Login page not loaded");


        }
    }
}
