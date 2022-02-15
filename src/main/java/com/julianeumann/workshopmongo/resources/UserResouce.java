package com.julianeumann.workshopmongo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianeumann.workshopmongo.domain.User;
import com.julianeumann.workshopmongo.dto.UserDTO;
import com.julianeumann.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResouce {

	@Autowired UserService service;
	
	//@RequestMapping(method=RequestMethod.GET)O
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		/*List<UserDTO> listDto = new ArrayList<>();
		for (User x : list) {
			listDto.add(new UserDTO(x));
		}*/
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}