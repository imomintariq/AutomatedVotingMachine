package com.example.automatedvotingmachine;

public class Voter {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String cnic;
    private String votingStatus;



    public Voter(String username, String password, String fname, String lname, String cnic, String votingStatus) {
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.cnic = cnic;
        this.votingStatus = votingStatus;
    }

    public Voter() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(String votingStatus) {
        this.votingStatus = votingStatus;
    }
    public void registerVoter(){
        DBManager dbManager = new DBManager();
        dbManager.addVoter(this);
    }
    public boolean validateVoter(String username, String password){
        DBManager dbManager = new DBManager();
        boolean isPresent = dbManager.validateVoter(username, password);
        return isPresent;
    }
}
