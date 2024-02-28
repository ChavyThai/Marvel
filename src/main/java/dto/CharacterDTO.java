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


public class CharacterDTO {


    private Integer id;
    private String realName;
    private String characterName;
    private String history;


    @JsonIgnore
    private List<MovieDTO> movies = new ArrayList<>();


}