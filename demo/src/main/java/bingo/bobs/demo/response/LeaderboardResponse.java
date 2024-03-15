package bingo.bobs.demo.response;

import bingo.bobs.demo.leaderboard.Leaderboard;
import bingo.bobs.demo.user.User;

public class LeaderboardResponse extends Response<Leaderboard>{

    public LeaderboardResponse(Leaderboard leaderboard) {
        super("success", leaderboard);
    }
}
