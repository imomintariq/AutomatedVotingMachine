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

public class VotingPage implements Initializable {

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

        evm.retrieveCandidiates(evm.getCandidateArrayList());
        ArrayList<String> candidatesList = new ArrayList<String>();
        for(int i = 0; i < evm.getCandidateArrayList().size(); i++){
            candidatesList.add(evm.getCandidateArrayList().get(i).getId()+"       "+ evm.getCandidateArrayList().get(i).getFname()+" "+evm.getCandidateArrayList().get(i).getLname()+ "       "+ evm.getCandidateArrayList().get(i).getParty_name());
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
        evm.getCandidateArrayList().get(currentCandidate).setVotes(evm.getCandidateArrayList().get(currentCandidate).getVotes()+1);
        evm.updateVotes(evm.getCandidateArrayList().get(currentCandidate));





    }
}