package model;


import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Entity(name = "Movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String image;
    private Integer calification;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )


    private List<Character> characters = new ArrayList<>();


    public void addCharacter (Character character){
        characters.add(character);
    }
}