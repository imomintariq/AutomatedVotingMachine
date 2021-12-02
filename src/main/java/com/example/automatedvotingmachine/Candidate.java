package com.example.automatedvotingmachine;

public class Candidate {
    private int id;
    private String fname;
    private String lname;
    private int votes;
    private String party_name;

    public Candidate(int _id, String fname, String lname, int votes, String party_name) {
        this.id = _id;
        this.fname = fname;
        this.lname = lname;
        this.votes = votes;
        this.party_name = party_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }
}
