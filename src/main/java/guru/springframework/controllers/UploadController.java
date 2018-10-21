package guru.springframework.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import guru.springframework.domain.GoodsSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
@Api(value = "file upload", description = "Operations pertaining to file upload in QiLaile")
public class UploadController {

	private static String UPLOAD_FOLDER = "temp//";
	private static String ACCESS_PATH;

	@Value("${upload.path}")
	public void setUPLOAD_FOLDER(String uPLOAD_FOLDER) {
		UPLOAD_FOLDER = uPLOAD_FOLDER;
	}

	@Value("${upload.access-path}")
	public  void setACCESS_PATH(String aCCESS_PATH) {
		ACCESS_PATH = aCCESS_PATH;
	}

	@PostMapping("/upload")
	@ApiOperation(value = "upload a file with an name ,for js use 'fileObjName',access url is returned", response = GoodsSource.class)
	public ResponseEntity singleFileUpload(@RequestParam() MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			return new ResponseEntity("empty file", HttpStatus.BAD_REQUEST);
		}
		String url = "";
		try {

			byte[] bytes = file.getBytes();
			url = ACCESS_PATH + file.getOriginalFilename();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		} catch (IOException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(url, HttpStatus.OK);
	}

}