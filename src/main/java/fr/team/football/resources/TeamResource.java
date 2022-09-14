package fr.team.football.resources;

import fr.team.football.exceptions.TeamException;
import fr.team.football.models.Team;
import fr.team.football.responseHttp.Response;
import fr.team.football.services.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class TeamResource {

    private final TeamService teamService;


    @GetMapping("/teams")
    public ResponseEntity<Page<Team>> getTeams (
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Team> teams = teamService.getTeams(name, page, size);

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @PostMapping("/teams")
    public ResponseEntity<Response> saveTeam(@RequestBody Team team) throws TeamException {
        if(teamService.existsTeamByAcronyme(team.getAcronyme())){
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(LocalDateTime.now())
                            .message("Team not created : A team already exists with the same acronyme")
                            .status(HttpStatus.CREATED)
                            .statusCode(HttpStatus.CREATED.value())
                            .build()
            );
        }
        Team teamSaved = teamService.saveTeam(team);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Collections.singletonMap("team", teamSaved))
                        .message("Team created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
