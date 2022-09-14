package fr.team.football.services;

import fr.team.football.exceptions.TeamException;
import fr.team.football.models.Team;
import fr.team.football.repositories.PlayerRepository;
import fr.team.football.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Override
    public Team saveTeam(Team team) throws TeamException {
        log.info("Saving a team : {}", team.getName());
        if(teamRepository.existsTeamByAcronyme(team.getAcronyme()))
            throw new TeamException("A team already exists with the same acronyme");

        log.info("Players team : {}", team.getPlayers());

        Team teamSaved = teamRepository.save(team);
        team.getPlayers().forEach( player -> {
            player.setTeam(teamSaved);
            playerRepository.save(player);
        });
        return teamSaved;
    }

    @Override
    public Page<Team> getTeams(String name, int page, int size) {
        log.info("Getting team list");
        return teamRepository.findByNameContainsOrderByNameAscAcronymeAscBudgetAsc(name, PageRequest.of(page, size));
    }

    @Override
    public boolean existsTeamByAcronyme(String acronyme) {
        return teamRepository.existsTeamByAcronyme(acronyme);
    }
}
