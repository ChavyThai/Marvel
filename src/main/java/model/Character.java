package model;


import jakarta.persistence.*;


import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Entity(name = "Characters")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Character {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String realName;
    private String characterName;
    private String history;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "character_movie",
                joinColumns = @JoinColumn(name = "character_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id")
    )


    private List<Movie> movies = new ArrayList<>();


    public void addMovie (Movie movie){
        movies.add(movie);
    }
}