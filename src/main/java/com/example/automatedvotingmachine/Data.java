package com.example.automatedvotingmachine;

import java.util.ArrayList;

public class Data {
    private static Data dataInstance = null;

    private ArrayList<Candidate> candidateArrayList;
    private ArrayList<Voter> voterArrayList;
    private ArrayList<Party> partiesArrayList;
    private Voter currentVoter;

    private Data(){

        candidateArrayList = new ArrayList<>();
        voterArrayList = new ArrayList<>();
        partiesArrayList = new ArrayList<>();
    }

    public static Data getInstance()
    {
        if (dataInstance == null)
            dataInstance = new Data();

        return dataInstance;
    }

    public Voter getCurrentVoter() {
        return currentVoter;
    }

    public void setCurrentVoter(Voter currentVoter) {
        this.currentVoter = currentVoter;
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
}
