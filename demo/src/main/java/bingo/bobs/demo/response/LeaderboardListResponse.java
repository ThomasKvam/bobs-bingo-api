package bingo.bobs.demo.response;

import bingo.bobs.demo.leaderboard.Leaderboard;


import java.util.List;

public class LeaderboardListResponse extends Response<List<Leaderboard>> {

    public LeaderboardListResponse(List<Leaderboard> data) {
        super("success", data);
    }
}