package com.example.FootballApi;

import java.util.List;

public class Club {

    private String id;
    private String name;
   // private League league;

    public  Club() {

    }

    public Club(String id, String name) {
        this.id = id;
        this.name = name;
       // this.league = league;
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


}