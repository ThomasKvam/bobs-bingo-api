package bingo.bobs.demo.leaderboard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Integer> {
}
