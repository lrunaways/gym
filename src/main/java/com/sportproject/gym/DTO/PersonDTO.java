package com.sportproject.gym.DTO;

import com.sportproject.gym.entity.Gymnastic;
import com.sportproject.gym.entity.Person;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Egor on 18.05.2020.
 */
@Data
public class PersonDTO {

    private String firstName;

    private String lastName;

    private int age;

    private String today;

    private Set<GymnasticDTO> gymnastics;

    public static List<PersonDTO> mappingPersonToDTO(List<Person> persons) {
        List<PersonDTO> resultDto = new ArrayList<>();
        for (Person person : persons) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setAge(person.getAge());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setToday(LocalDateTime.now().toString());

            Set<GymnasticDTO> gymnasticDTOS = new HashSet<>();

            for (Gymnastic gymnastic : person.getGymnastics()) {
                GymnasticDTO gymnasticDTO = new GymnasticDTO();
                gymnasticDTO.setDescription(gymnastic.getDescription());
                gymnasticDTO.setName(gymnastic.getName());
                Person fakePerson = new Person();
                fakePerson.setAge(1);
                fakePerson.setLastName("I");
                Set<Person> set = new HashSet<>();
                set.add(fakePerson);
                gymnasticDTO.setPersons(set);
                gymnasticDTOS.add(gymnasticDTO);
            }
            personDTO.setGymnastics(gymnasticDTOS);

            resultDto.add(personDTO);

        }
        return resultDto;
    }

}