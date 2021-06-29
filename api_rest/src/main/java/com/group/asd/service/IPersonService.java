package com.group.asd.service;

import java.util.List;

import com.group.asd.dto.PersonDTO;
import com.group.asd.dto.ResponseDTO;

public interface IPersonService {
	
	ResponseDTO<List<PersonDTO>> findAll();
	
}
