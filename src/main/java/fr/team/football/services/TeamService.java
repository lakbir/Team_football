package fr.team.football.services;

import fr.team.football.exceptions.TeamException;
import fr.team.football.models.Team;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TeamService {

    public Team saveTeam(Team team) throws TeamException;
    public Page<Team> getTeams(String name, int page, int size);
    public boolean existsTeamByAcronyme(String acronyme);
}
