package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping(value = "/building/")
	public List<BuildingDTO>  getBuilding(@RequestParam (name = "name") String name) {
		List<BuildingDTO> buildingDTOs = buildingService.findAll(name);
		return buildingDTOs;
	}
	
	@PostMapping(value = "/building/")
	public BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
		vaidateAttribute(buildingDTO);
		System.out.println(buildingDTO.getName() + buildingDTO.getStreet() + buildingDTO.getNumOFStage());
		return buildingDTO;
	}
	
//	@GetMapping(value = "/building/")
//	public void getBuilding(@RequestParam Map<String, String> buildingDTO) {
//		buildingDTO.get("name");
//		System.out.println(buildingDTO.get("name") + buildingDTO.get("street") + buildingDTO.get("numOfStage"));
//	}

	@DeleteMapping("/building/{id}")
	public void deleteBuilding(@PathVariable String id) {
		//delete building has ID = {id} on database 
		System.out.println("Has deleted building has id = " + id);
	}
	
	public void vaidateAttribute(BuildingDTO buildingDTO) {
		if (buildingDTO.getNumOFStage() == null || buildingDTO.getStreet() == null) {
			throw new FieldRequiredException("The attribute of building are null!");
		}
	}
}
