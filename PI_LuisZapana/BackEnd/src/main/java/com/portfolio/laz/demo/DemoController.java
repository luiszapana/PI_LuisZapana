package com.portfolio.laz.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
	
	@PostMapping(value ="demo")
	public String welcome() {
		return "welcome from secure end point // simulación de recurso protegido";
	}
	
}
