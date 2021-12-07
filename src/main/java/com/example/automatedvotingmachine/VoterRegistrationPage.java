package com.example.automatedvotingmachine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VoterRegistrationPage {

    @FXML
    private TextField cnic;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private PasswordField password;

    @FXML
    private Button register;

    @FXML
    private TextField username;

    @FXML
    private Button backButton;


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


    @FXML
    void registerButtonClicked(MouseEvent event) {
        EVM evm = new EVM();
        boolean usernameIsCorrect = false;
        boolean cnicIsCorrect = false;
        if(cnic.getText().length() == 13){

            System.out.println("VALID CNIC");
            if(evm.usernameAlreadyExists(username.getText())){
                System.out.println("Username Already Exists");

            }
            else{
                System.out.println("Username doesn't exist");
                usernameIsCorrect = true;
            }

            if(evm.cnicAlreadyExists(cnic.getText())){
                System.out.println("CNIC Already Exists");

            }
            else{
                System.out.println("CNIC doesn't exist");
                cnicIsCorrect = true;
            }

            if(cnicIsCorrect == true && usernameIsCorrect == true){
                System.out.println("You CAN Register");
                evm.registerVoter(firstName.getText(),lastName.getText(),cnic.getText(),username.getText(),password.getText());
                EVMApplication EVMApplication = new EVMApplication();
                try {
                    EVMApplication.changeScene("hello-view.fxml");


                }
                catch(Exception e){
                    System.out.println("Login page not loaded");


                }


            }
            else{
                System.out.println("You CANNOT Register");
            }


        }
        else{
            System.out.println("INVALID CNIC");
        }





    }
}
