package com.example.FootballApi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FootballController {


    private  Football football = new Football();

    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    private List<League> getFootballLeague(@RequestParam(value = "searchId", defaultValue = "") String searchId) {

        return football.getLeague(searchId);
    }

    @RequestMapping(value = "/leagues/{id}", method = RequestMethod.GET)
    public League getFootballLeagueById(@PathVariable("id") String leagueId) {
        League league = football.getFootballLeague(leagueId);

        return league;
    }

    @RequestMapping(value = "/leagues", method = RequestMethod.POST)
    public League postFootballLeague(@RequestBody League league) {
        football.addLeague(league);

        return league;
    }

    @RequestMapping(value = "/leagues/{id}", method = RequestMethod.DELETE)
    public void deleteLeagueById(@PathVariable("id") String leagueId) {

        football.deleteLeague(leagueId);

    }

    @RequestMapping(value = "/clubs", method = RequestMethod.GET)
    public List<Club> getFootballClub(@RequestParam(value = "search", defaultValue = "") String searchString) {

        return football.getClub(searchString);
    }


    @RequestMapping(value = "/clubs/{id}", method = RequestMethod.GET)
    public Club getFootballClubById(@PathVariable("id") String clubId) {
        Club club = football.getFootballClub(clubId);

        return club;

    }

    @RequestMapping(value = "/clubs/{id}", method = RequestMethod.DELETE)
    public void deleteFootballClub(@PathVariable("id") String clubId) {

        football.deleteClub(clubId);

    }

    @RequestMapping(value = "/leagues/{id}/clubs", method = RequestMethod.POST)
    public Club postFootballClub(@PathVariable("id") String leagueId, @RequestBody Club club) {
        football.addClubByLeagueId(leagueId, club);

        return club;
    }


}
