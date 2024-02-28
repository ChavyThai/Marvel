package dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class MovieDTO {


    private int id;
    private String title;
    private String image;
    private Integer calification;


    @JsonIgnore
    private List<CharacterDTO> characters = new ArrayList<>();
}