package com.group.asd.serviceimpl;

import com.group.asd.dto.AreaDTO;
import com.group.asd.dto.ResponseDTO;
import com.group.asd.entity.Area;
import com.group.asd.mapper.AreaMapper;
import com.group.asd.repository.AreaRepository;
import com.group.asd.service.IAreaService;
import com.group.asd.util.ApiResponseCode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private AreaMapper areaMapper;
	@Autowired
	private AreaRepository areaRepository;
	
	/**
	 * Returns all areas
	 * 
	 * @author ingalexandrasarmiento
	 * @return ResponseDTO<List<AreaDTO>>
	 */
	@Override
	public ResponseDTO<List<AreaDTO>> findAll() {
		List<Area> areas = areaRepository.findAll();
		if (!areas.isEmpty()) {
			return new ResponseDTO<>(areaMapper.areaListToAreaDTOList(areas), ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getDescription(), ApiResponseCode.SUCCESS.getStatus());
		}

		return new ResponseDTO<>(null, ApiResponseCode.LIST_EMPTY.getCode(), ApiResponseCode.LIST_EMPTY.getDescription(), ApiResponseCode.LIST_EMPTY.getStatus());
	}
	
}
