package com.github.luismoramedina.multipartdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileOutputStream;
import java.util.Date;

import static org.springframework.http.HttpStatus.OK;

@SpringBootApplication
public class MultipartDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipartDemoApplication.class, args);
	}

	@Controller
	public class MPController {

		@PostMapping("/")
		public ResponseEntity handleFileUpload(@RequestPart("file") MultipartFile file,
		                                       @RequestPart("metadata") Metadata metadata) throws Exception {

			byte[] bytes = file.getBytes();
			System.out.println("metadata = " + metadata);
			FileOutputStream fileOutputStream = new FileOutputStream(
					"/home/luis/Downloads/" + file.getOriginalFilename() + "." + new Date().toString());
			fileOutputStream.write(bytes);
			return new ResponseEntity(OK);
		}
	}
}
