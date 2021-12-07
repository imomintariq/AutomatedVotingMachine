package com.example.automatedvotingmachine;

import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EVM {




    public EVM() {
    }



    public void retrieveCandidiates() {
        DBManager db =new DBManager();
        Data data = Data.getInstance();

        db.retrieveCandidates(data.getCandidateArrayList());
    }

    public void updateVotes(Candidate candidate) {
        DBManager  db = new DBManager();
        db.updateVotes(candidate);
    }

    public boolean validateVoter(String username, String password){
        DBManager dbManager = new DBManager();
        boolean isPresent = dbManager.validateVoter(username, password);
        return isPresent;
    }

    public boolean usernameAlreadyExists(String username){
        DBManager dbManager = new DBManager();
        boolean isPresent = dbManager.usernameAlreadyExists(username);
        return isPresent;
    }

    public boolean cnicAlreadyExists(String cnic){
        DBManager dbManager = new DBManager();
        boolean isPresent = dbManager.cnicAlreadyExists(cnic);
        return isPresent;
    }


    public void registerVoter(String fname, String lname, String cnic, String username, String password) {
        DBManager dbManager = new DBManager();
        Voter voter =  new Voter(username,password,fname,lname,cnic,"false");
        dbManager.addVoter(voter);
    }

    public boolean validateAdmin(String username, String password) {
        DBManager dbManager = new DBManager();
        boolean isPresent = dbManager.validateAdmin(username, password);
        return isPresent;
    }

    public void retriveParties() {
        DBManager db =new DBManager();
        Data data = Data.getInstance();

        db.retrieveParties(data.getPartiesArrayList());
    }
}
