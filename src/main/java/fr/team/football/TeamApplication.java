package fr.team.football;

import fr.team.football.models.Team;
import fr.team.football.services.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamApplication.class, args);
	}

	@Bean
	CommandLineRunner start(TeamService teamService){
		return args -> {
/*			teamService.saveTeam(new Team( null,"Paris Saint-Germain Football Club","PSG", 2000000000,null));
			teamService.saveTeam(new Team( null,"Olympique de Marseille","OM", 300000000,null));
			teamService.saveTeam(new Team( null,"Olympique lyonnais","OL", 20098700,null));
			teamService.saveTeam(new Team( null,"Stade Brestois 29","SB29", 20000000,null));
			teamService.saveTeam(new Team( null,"Racing Club de Lens","RCL", 18000000,null));*/
		};
	}

}
