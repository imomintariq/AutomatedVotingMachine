package com.example.automatedvotingmachine;

public class Party {

    private String partyID;
    private String partyName;
    private String partySymbol;

    public Party(String partyID, String partyName, String partySymbol) {
        this.partyID = partyID;
        this.partyName = partyName;
        this.partySymbol = partySymbol;
    }

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public void setPartySymbol(String partySymbol) {
        this.partySymbol = partySymbol;
    }
}
