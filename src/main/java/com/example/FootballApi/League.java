package com.example.FootballApi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class League {

    private String id;
    private String name;
    private ArrayList<Club> clubs;


    public League(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public void deleteClub(Club club) {
        clubs.remove(club);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Club> getClubs() {

        if(clubs == null) {
            clubs = new ArrayList<>();
        }
        return clubs;
    }

    public void addClubsToArray(Club club) {
        clubs.add(club);
    }

    public void setClubs(ArrayList<Club> clubs) {
        this.clubs = clubs;
    }
}
