package com.example.automatedvotingmachine;

import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public void addVoter( Voter voter){
        try{


            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn","scott", "tiger");
            System.out.println("Connection Established");
            String sql = "INSERT INTO SCOTT.REGISTERED_VOTERS (CNIC, VOTER_FNAME, VOTER_LNAME, HAS_VOTED, USERNAME, PASSWORD) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, voter.getCnic());
            statement.setString(2, voter.getFname());
            statement.setString(3, voter.getLname());
            statement.setString(4, voter.getVotingStatus());
            statement.setString(5, voter.getUsername());
            statement.setString(6, voter.getPassword());

            int rowInserted = statement.executeUpdate();
            if(rowInserted> 0){
                System.out.println("Inserted into Oracle");
            }
        }catch(Exception e){
            System.out.println("Exception Thrown");
        }
    }

    public boolean validateVoter(String username, String password) {
        boolean validation = false;
        try {
            System.out.println("USERNAME: "+username);
            System.out.println("PASSWORD: "+password);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scott.registered_voters");
            while(rs.next()){
                //int id = rs.getInt(1);
                String _username = rs.getNString("username");
                String _password = rs.getNString("password");
                if(username.equals(_username) ){
                    if(password.equals(_password))
                    {
                        System.out.println("log In Successful");
                        return true;

                    }
                    else{
                        System.out.println("password incorrect");
                    }
                }
                else{
                    System.out.println("Username or password incorrect");
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
        return false;
    }

    public void retrieveCandidates(ArrayList<Candidate> list) {
        boolean validation = false;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select candidates.id, candidates.votes, candidates.fname,candidates.lname, election_parties.party_name from scott.candidates, election_parties where candidates.party_id = election_parties.party_id");
            while(rs.next()){
                //int id = rs.getInt(1);
                int id = rs.getInt("id");
                int votes = rs.getInt("votes");
                String f_name = rs.getNString("fname");
                String l_name = rs.getNString("lname");
                String partyName = rs.getNString("party_name");
                Candidate c = new Candidate(id, f_name,l_name,votes,partyName );
                list.add(c);

            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }


    }

    public void updateVotes(Candidate candidate) {
        try{


            System.out.println("Candidate ID = " + candidate.getId() + "        Candidate Votes = "+ candidate.getVotes() );
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn","scott", "tiger");
            System.out.println("Connection Established");
            String sql = "UPDATE SCOTT.CANDIDATES SET VOTES = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, candidate.getVotes());
            statement.setInt(2, candidate.getId());

            int rowInserted = statement.executeUpdate();
            if(rowInserted> 0){
                System.out.println("Votes updated");
            }
        }catch(Exception e){
            System.out.println("Votes not Updated!!!");
        }
    }

    public boolean usernameAlreadyExists(String username) {
        boolean validation = false;
        try {
            System.out.println("USERNAME: "+username);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scott.registered_voters");
            while(rs.next()){
                //int id = rs.getInt(1);
                String _username = rs.getNString("username");
                if(username.equals(_username) ){
                    return true;

                }
                else{
                    return false;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
        return false;


    }

    public boolean cnicAlreadyExists(String cnic) {
        boolean validation = false;
        try {
            System.out.println("CNIC: "+cnic);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scott.registered_voters");
            while(rs.next()){
                //int id = rs.getInt(1);
                String _cnic = rs.getNString("cnic");
                if(_cnic.equals(cnic) ){
                    return true;

                }
                else{
                    return false;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
        return false;

    }

    public boolean validateAdmin(String username, String password) {

        boolean validation = false;
        try {
            System.out.println("USERNAME: "+username);
            System.out.println("PASSWORD: "+password);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scott.admin");
            while(rs.next()){
                //int id = rs.getInt(1);
                String _username = rs.getNString("username");
                String _password = rs.getNString("password");
                if(username.equals(_username) ){
                    if(password.equals(_password))
                    {
                        System.out.println("log In Successful");
                        return true;

                    }
                    else{
                        System.out.println("password incorrect");
                    }
                }
                else{
                    System.out.println("Username or password incorrect");
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
        return false;
    }

    public void retrieveParties(ArrayList<Party> partiesArrayList) {
        boolean validation = false;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:mominn", "scott", "tiger");
            System.out.println("Connection Established");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from scott.election_parties");
            while(rs.next()){

                String partyId = rs.getNString("party_id");
                String partyName = rs.getNString("party_name");
                String partySymbol = rs.getNString("party_symbol");
                Party party = new Party(partyId,partyName,partySymbol);
                partiesArrayList.add(party);
            }
        }
        catch (Exception e){
            System.out.println("Error Connecting to database");
        }
    }
}
