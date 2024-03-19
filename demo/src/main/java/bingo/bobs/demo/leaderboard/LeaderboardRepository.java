package bingo.bobs.demo.leaderboard;

import bingo.bobs.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
    Leaderboard findByUser(User user);

}
