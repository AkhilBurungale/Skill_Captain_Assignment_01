package com.example.assignment;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
@RestController
public class GreetController {

	@GetMapping("/greet/{name}")
	public ResponseEntity<String> greetByName(@PathVariable String name) {
	    if (name == null || name.trim().isEmpty()) {
	        return new ResponseEntity<>("Name is missing or blank", HttpStatus.BAD_REQUEST);
	    }
	    return ResponseEntity.ok("Hello " + name + "!");
	}

	@GetMapping("/greet/{name}/{lang}")
	public ResponseEntity<String> greetByNameAndLanguage(@PathVariable String name, @PathVariable String lang) {
	    if (name == null || name.trim().isEmpty()) {
	        return new ResponseEntity<>("Name is missing or blank", HttpStatus.BAD_REQUEST);
	    }
	    if (lang.equalsIgnoreCase("es")) {
	        return ResponseEntity.ok("Hola " + name + "!");
	    } else {
	        return ResponseEntity.ok("Hello " + name + "!");
	    }
	}
	
	
	@PostMapping("/greet")
	public ResponseEntity<String> greetByJson(@RequestBody GreetingRequest request ){
		String name=request.getName();
		if(name==null||name.trim().isEmpty()) {
			return new ResponseEntity<>("Name is missing or blank",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Hello"+name+"!");
	}

	
}