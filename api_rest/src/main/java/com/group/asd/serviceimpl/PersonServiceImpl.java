package com.group.asd.serviceimpl;

import com.group.asd.dto.PersonDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.entity.Person;
import com.group.asd.mapper.PersonMapper;
import com.group.asd.repository.PersonRepository;
import com.group.asd.service.IPersonService;
import com.group.asd.util.ApiResponseCode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Returns all people
	 * 
	 * @author ingalexandrasarmiento
	 * @return  ResponseDTO<List<PersonDTO>>
	 */
	@Override
	public ResponseDTO<List<PersonDTO>> findAll() {
		List<Person> people = personRepository.findAll();
		if (!people.isEmpty()) {
			return new ResponseDTO<>(personMapper.personListToPersonDTOList(people), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}

		return new ResponseDTO<>(null, ApiResponseCode.LIST_EMPTY.getCode(), ApiResponseCode.LIST_EMPTY.getDescription(), ApiResponseCode.LIST_EMPTY.getStatus());
	}
	
}
