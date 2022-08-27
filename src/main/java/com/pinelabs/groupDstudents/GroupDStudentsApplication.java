package com.pinelabs.groupDstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class GroupDStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupDStudentsApplication.class, args);
	}


}
