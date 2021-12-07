package com.example.automatedvotingmachine;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddingACandidatePage implements Initializable {
    @FXML
    private Button addCandidateButton;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private ListView<String> listView;
    private int currentParty=0;
    private Party selectedParty;
    private EVM evm;

    @FXML
    void initialize() {
        listView = new ListView<String>();
        assert addCandidateButton != null : "fx:id=\"addCandidateButton\" was not injected: check your FXML file 'AddingACandidatePage.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'AddingACandidatePage.fxml'.";
    }


    @FXML
    void addCandidateButtonClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        evm = new EVM();
        ArrayList<String> list = new ArrayList<String>();

        Data data = Data.getInstance();
        evm.retriveParties();
        ArrayList<String> partyList = new ArrayList<>();
        for(int i = 0; i < data.getPartiesArrayList().size(); i++){
            partyList.add(data.getPartiesArrayList().get(i).getPartyName());
        }
        listView = new ListView<>();
        listView.getItems().addAll(partyList);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentParty=listView.getSelectionModel().getSelectedIndex();//getting current selection

                System.out.println(currentParty);

            }
        });


    }
}
