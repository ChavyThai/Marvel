package service;


import dto.CharacterDTO;
import model.Character;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CharacterRepository;


import java.util.List;


@Service
public class CharacterService {


    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    private ModelMapper modelMapper;


    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }


    public CharacterDTO createCharacter(CharacterDTO characterDTO){
        Character character = modelMapper.map(characterDTO, Character.class);
        character = characterRepository.saveAndFlush(character);
        return modelMapper.map(character, CharacterDTO.class);
    }


    public CharacterDTO getCharacterById(Integer characterId){
        Character character = characterRepository.findById(characterId).orElseThrow();
        return modelMapper.map(character, CharacterDTO.class);
    }


    public CharacterDTO updateCharacter(CharacterDTO character, Integer characterId){
        Character oldCharacter = characterRepository.findById(characterId).orElseThrow();
        oldCharacter.setRealName(character.getRealName());
        oldCharacter.setCharacterName(character.getCharacterName());
        oldCharacter.setHistory(character.getHistory());
        oldCharacter = characterRepository.saveAndFlush(oldCharacter);
        return modelMapper.map(oldCharacter, CharacterDTO.class);
    }


    public void deletePersonajeById(Integer characterId){
        characterRepository.deleteById(characterId);
    }
}