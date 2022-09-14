package fr.team.football.repositories;

import fr.team.football.models.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // Check if there is a team with the same name
    Boolean existsTeamByAcronyme(String acronyme);

    // Get a page of teams
    Page<Team> findByNameContainsOrderByNameAscAcronymeAscBudgetAsc(String name, Pageable pageable);
}
