package com.nijanthan;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "/getHello", method = RequestMethod.GET)
	public String getHello() {
		//http://localhost:12345/test/getHello
		return "Hello";
	}

	@RequestMapping(value = "/getHelloPath/{world}", method = RequestMethod.GET)
	public String getHelloPath(@PathVariable
			("world") String world) {
		//http://localhost:12345/test/getHelloPath/nijanthanWorld
		return "Hello path " + world;
	}
	
	@RequestMapping(value = "/getHelloQuery", method = RequestMethod.GET)
	public String getHelloQuery(@RequestParam("world") String world) {
		//http://localhost:12345/test/getHelloQuery?world=nijanthanWorld
		return "Hello query " + world;
	}
	
	@RequestMapping(value = "/getHelloBody/{mark}", method = RequestMethod.POST)
	public TestDto getHelloBody(@RequestParam("name") String name,@PathVariable("mark") long mark) {
		//http://localhost:12345/test/getHelloBody/12?name=Nijanthan
		TestDto dto=new TestDto();
		dto.setName(name);
		dto.setMark(mark);
		return dto;
	}
	
	@RequestMapping(value = "/getHelloRequestBody/{mark}", method = RequestMethod.POST)
	public TestDto getHelloBody(@RequestBody TestDto requestDto,@PathVariable("mark") long mark) {
		//http://localhost:12345/test/getHelloRequestBody/12
		//{	    "name": "Nijanthan",	    "mark": 12	}
		TestDto dto=new TestDto();
		dto.setName(requestDto.getName());
		dto.setMark(requestDto.getMark()+mark);
		return dto;
	}
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value = "/insertStudent/{mark}", method = RequestMethod.POST)
	public Student insertStudent(@RequestParam("name") String name,@PathVariable("mark") long mark) {
		//http://localhost:12345/test/insertStudent/12?name=Nijanthan
		Student dto=new Student();
		dto.setName(name);
		dto.setMark(mark);
		studentRepository.save(dto);
		return dto;
	}
	
	
	@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		//http://localhost:12345/test/getAllStudents
		return (List<Student>) studentRepository.findAll();
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
	public List<Student> findByName(@PathVariable("name") String name ) {
		//http://localhost:12345/test/findByName/Nijanthan
		return (List<Student>) studentRepository.findByName(name);
	}

}
