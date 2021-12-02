package com.example.automatedvotingmachine;

import javafx.scene.control.ListView;

import java.util.ArrayList;

public class EVM {

    private ArrayList<Candidate> candidateArrayList;
    private ArrayList<Voter> voterArrayList;
    private ArrayList<Party> partiesArrayList;

    public EVM() {
        voterArrayList = new ArrayList<Voter>();
        candidateArrayList = new ArrayList<Candidate>();
        partiesArrayList = new ArrayList<Party>();
    }

    public EVM(ArrayList<Candidate> candidateArrayList, ArrayList<Voter> voterArrayList, ArrayList<Party> partiesArrayList) {
        this.candidateArrayList = candidateArrayList;
        this.voterArrayList = voterArrayList;
        this.partiesArrayList = partiesArrayList;
    }

    public ArrayList<Candidate> getCandidateArrayList() {
        return candidateArrayList;
    }

    public void setCandidateArrayList(ArrayList<Candidate> candidateArrayList) {
        this.candidateArrayList = candidateArrayList;
    }

    public ArrayList<Voter> getVoterArrayList() {
        return voterArrayList;
    }

    public void setVoterArrayList(ArrayList<Voter> voterArrayList) {
        this.voterArrayList = voterArrayList;
    }

    public ArrayList<Party> getPartiesArrayList() {
        return partiesArrayList;
    }

    public void setPartiesArrayList(ArrayList<Party> partiesArrayList) {
        this.partiesArrayList = partiesArrayList;
    }

    public void retrieveCandidiates(ArrayList<Candidate> list) {
        DBManager db =new DBManager();

        db.retrieveCandidates(list);
    }

    public void updateVotes(Candidate candidate) {
        DBManager  db = new DBManager();
        db.updateVotes(candidate);
    }
}
