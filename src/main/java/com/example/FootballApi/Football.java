package com.example.FootballApi;

import java.util.ArrayList;
import java.util.List;

public class Football {
    private List<League> leagueList;
    public League clubArrayRef;

    public Football() {
        this.leagueList = new ArrayList<>();
        addMockData();
    }

    // ----- LEAGUES -----

    public void addLeague(League league) {
        leagueList.add(league);
    }

    public List<League> getLeague(String searchString) {
        if (searchString.equals(""))
            return leagueList;

        ArrayList<League> leagueMembers = new ArrayList<>();
        for (League leagueMember : leagueList) {
            if (leagueMember.getName().toLowerCase().contains(searchString.toLowerCase()))
                leagueMembers.add(leagueMember);
        }
        return leagueMembers;
    }

    public League getFootballLeagueById(String id) {

        return findLeagueByID(id);
    }

    private League findLeagueByID(String id) {
        for (League item : leagueList) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }

    public League deleteLeague(String leagueId) {
        for (League leagueToDelete: leagueList) {
            if (leagueToDelete.getId().equals(leagueId))
                leagueList.remove(leagueToDelete);
            return leagueToDelete;
        }
        return null;
    }

    // ----- CLUBS -----

    public Club getFootballClubById(String id) {

        return  findClubById(id);
    }

    public Club findClubById(String id) {

        for (League league : leagueList) {
            for (Club club : league.getClubs()) {
                if (club.getId().equals(id))
                    return club;
            }
        }
        return null;
    }

    public void addClubByLeagueId(String id, Club club) {
        for (League item : leagueList) {
            if (item.getId().equals(id))
                item.addClubsToArray(club);
               // clubList.add(club);
        }
    }

    public List<Club> getClub(String searchString) {

        ArrayList<Club> clubMembers = new ArrayList<>();
        for (League league : leagueList) {
            for (Club club : league.getClubs()) {
                if (club.getName().toLowerCase().contains(searchString.toLowerCase()))
                    clubMembers.add(club);
            }
        }
        return clubMembers;
    }

    public Club deleteClub(String clubId) {
        for (League league: leagueList) {
            for (Club clubToDelete: league.getClubs()) {
                if (clubToDelete.getId().equals(clubId))
                    league.deleteClub(clubToDelete);

                return clubToDelete;
            }
        }
        return null;
    }

    // ----- DATA SETUP WITH 3 PRE LEGUES -----

    private void addMockData() {
        League league1 = new League("1", "Premier League");
        League league2 = new League("2", "La Liga");
        League league3 = new League("3", "Bundesliga");

        leagueList.add(league1);
        leagueList.add(league2);
        leagueList.add(league3);
    }
}
