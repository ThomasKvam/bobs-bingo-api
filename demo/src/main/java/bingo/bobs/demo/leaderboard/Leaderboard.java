package bingo.bobs.demo.leaderboard;

import bingo.bobs.demo.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable= false)
    private User user;

    @Column
    private int score;

    public Leaderboard(int score) {
        this.score = score;
    }
}
