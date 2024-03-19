package bingo.bobs.demo.leaderboard;

import bingo.bobs.demo.response.ErrorResponse;
import bingo.bobs.demo.response.LeaderboardListResponse;
import bingo.bobs.demo.response.LeaderboardResponse;
import bingo.bobs.demo.response.Response;
import bingo.bobs.demo.user.User;
import bingo.bobs.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return new ResponseEntity<>(new LeaderboardListResponse(this.leaderboardRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getScore (@PathVariable int id) {
        Leaderboard leaderboard = this.leaderboardRepository
                .findById(id)
                .orElse(null);
        if (leaderboard == null) {
            return new ResponseEntity<>(new ErrorResponse(new Error("Leaderboard not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new LeaderboardResponse(leaderboard), HttpStatus.OK);
    }

    @PostMapping("{userId}")
    public ResponseEntity<Response> createLeaderboard (@PathVariable int userId, @RequestBody Leaderboard leaderboard) {
        User user = this.userRepository
                .findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found"));

        leaderboard.setUser(user);
        this.leaderboardRepository.save(leaderboard);
        return new ResponseEntity<>(new LeaderboardResponse(leaderboard), HttpStatus.CREATED);
    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Response> deleteUser (@PathVariable int id) {
//        User deleted = this.userRepository
//                .findById(id)
//                .orElse(null);
//
//        if (deleted == null) {
//            return new ResponseEntity<>(new ErrorResponse(new Error("Customer not found")), HttpStatus.NOT_FOUND);
//        }
//        this.userRepository.delete(deleted);
//        return new ResponseEntity<>(new UserResponse(deleted), HttpStatus.OK);
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Response> updateLeaderboard (@PathVariable int id, @RequestBody Leaderboard leaderboard) {

        Leaderboard scoreToUpdate = this.leaderboardRepository
                .findById(id)
                .orElse(null);
        if(scoreToUpdate == null) {
            return new ResponseEntity<>(new ErrorResponse(new Error("User not found")), HttpStatus.NOT_FOUND);
        }

        scoreToUpdate.setScore(leaderboard.getScore());
        this.leaderboardRepository.save(scoreToUpdate);
        return new ResponseEntity<>(new LeaderboardResponse(scoreToUpdate), HttpStatus.OK);
    }

}
