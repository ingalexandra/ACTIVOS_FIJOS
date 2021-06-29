package com.group.asd.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.group.asd.dto.PersonDTO;
import com.group.asd.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	/**
	 * Convert a person entity to a person DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param personDTO
	 * @return Person
	 */
	Person personDTOToPerson(PersonDTO personDTO);
	
	/**
	 * Convert a person DTO to a person entity
	 * 
	 * @author ingalexandrasarmiento
	 * @param person
	 * @return PersonDTO
	 */
	PersonDTO personToPersonDTO(Person person);
	
	/**
	 * Convert a list of person entities to a list of person DTO
	 * 
	 * @author ingalexandrasarmiento
	 * @param personList List of person entities
	 * @return List<PersonDTO>
	 */
	List<PersonDTO> personListToPersonDTOList(List<Person> personList);

}
