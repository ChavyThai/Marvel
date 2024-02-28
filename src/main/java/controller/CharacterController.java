package controller;


import dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CharacterService;


@RestController
@RequestMapping("/characters")


public class CharacterController {


    @Autowired
    CharacterService characterService;


    @PostMapping
    public CharacterDTO createCharacter(@RequestBody CharacterDTO character){
        return characterService.createCharacter(character);
    }


    @GetMapping("/{characterId}")
    public CharacterDTO getCharacterById(@PathVariable Integer characterId){
        return characterService.getCharacterById(characterId);
    }


    @PutMapping("/{characterId}")
    public CharacterDTO updateCharacter(@RequestBody CharacterDTO character,
                                        @PathVariable Integer characterId){
        return characterService.updateCharacter(character, characterId);
    }


    @DeleteMapping("/{characterId}")
    public void deleteCharacterById(@PathVariable Integer characterId){
        characterService.deletePersonajeById(characterId);
    }
}