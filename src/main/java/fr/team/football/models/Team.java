package fr.team.football.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotEmpty(message = "Team name may not be empty")
    private String name;

    @NotEmpty(message = "Team acronyme may not be empty")
    @Column(unique = true)
    private String acronyme;

    @NotNull(message = "Team budget may not be null")
    private double budget;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Collection<Player> players;
}
