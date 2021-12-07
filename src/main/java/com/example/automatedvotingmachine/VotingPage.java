package com.example.automatedvotingmachine;

import java.net.URL;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class VotingPage implements Initializable {


    @FXML
    private Button backButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button castVote;

    @FXML
    private ListView<String> listView;

    private int currentCandidate=0;
    private Candidate selectedCandidate;
    private EVM evm;

    @FXML
    void initialize() {
        listView = new ListView<String>();
        assert castVote != null : "fx:id=\"castVote\" was not injected: check your FXML file 'VotingPage.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'VotingPage.fxml'.";

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        evm = new EVM();
        ArrayList<String> list = new ArrayList<String>();

        Data data = Data.getInstance();
        evm.retrieveCandidiates();
        ArrayList<String> candidatesList = new ArrayList<>();
        for(int i = 0; i < data.getCandidateArrayList().size(); i++){
            candidatesList.add(data.getCandidateArrayList().get(i).getId()+"       "+ data.getCandidateArrayList().get(i).getFname()+" "+data.getCandidateArrayList().get(i).getLname()+ "       "+ data.getCandidateArrayList().get(i).getParty_name());
        }
        listView.getItems().addAll(candidatesList);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentCandidate=listView.getSelectionModel().getSelectedIndex();//getting current selection

                System.out.println(currentCandidate);

            }
        });

    }

    public void onCastVote(ActionEvent actionEvent) {
        EVM evm = new EVM();
        Data data = Data.getInstance();
        data.getCandidateArrayList().get(currentCandidate).setVotes(data.getCandidateArrayList().get(currentCandidate).getVotes()+1);
        evm.updateVotes(data.getCandidateArrayList().get(currentCandidate));
    }


    @FXML
    void backButtonPressed(MouseEvent event) {
        EVMApplication EVMApplication = new EVMApplication();
        try {
            EVMApplication.changeScene("hello-view.fxml");


        }
        catch(Exception e){
            System.out.println("Login page not loaded");


        }
    }
}