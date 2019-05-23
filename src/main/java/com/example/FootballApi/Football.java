package com.example.FootballApi;

import java.util.ArrayList;
import java.util.List;

public class Football {
    private List<League> leagueList;
    private List<Club> clubList;
    public League clubArrayRef;

    public Football() {
        this.leagueList = new ArrayList<>();
        this.clubList = new ArrayList<>();
        addMockData();
    }

    public List<League> getLeague(String searchId) {
        if (searchId.equals(""))
            return leagueList;

        ArrayList<League> leagueMembers = new ArrayList<>();
        for (League leagueMember : leagueList) {
            if (leagueMember.getName().toLowerCase().contains(searchId.toLowerCase()))
                leagueMembers.add(leagueMember);
        }
        return leagueMembers;
    }

    public League getFootballLeague(String id) {

        return findLeagueByID(id);
    }

    public Club getFootballClub(String id) {

        return  findClubById(id);
    }

    public Club findClubById(String id) {
        /*for (Club item : clubList) {
            if (item.getId().equals(id))
                return item;*/

        ArrayList<Club> clubMember = new ArrayList<>();
        for (League league : leagueList) {
            for (Club club : league.getClubs()) {
                if (club.getId().equals(id));
                    clubMember.add(club);
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

    public void addLeague(League league) {
        leagueList.add(league);
    }

    public void addClub(Club club) {
        clubList.add(club);
    }

    public List<Club> getClub(String searchString) {
        if (searchString.equals(""))
            return clubArrayRef.getClubs();

        ArrayList<Club> clubMembers = new ArrayList<>();
        for (League league : leagueList) {
            for (Club club : league.getClubs()) {
                if (club.getName().toLowerCase().contains(searchString.toLowerCase()))
                    clubMembers.add(club);
            }
        }
        return clubMembers;
    }

    private void addMockData() {
        League league1 = new League("1", "Premier League");
        League league2 = new League("2", "La Liga");
        League league3 = new League("3", "Bundesliga");

        leagueList.add(league1);
        leagueList.add(league2);
        leagueList.add(league3);
    }
}
