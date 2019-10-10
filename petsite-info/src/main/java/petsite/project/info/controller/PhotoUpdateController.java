package petsite.project.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import petsite.project.info.domain.InfoList;
import petsite.project.info.service.TextUpdateService;

@RestController
@CrossOrigin
@RequestMapping("/photoUpdate")
public class PhotoUpdateController {

	@Autowired
	private TextUpdateService updateService;
	
	@PostMapping("/{idx}")
	public ResponseEntity<String> updatePhoto(
			@PathVariable("idx") int idx,
			InfoList infolist,
			MultipartHttpServletRequest request) {
		
		infolist.setIdx(idx);
		
		System.out.println(request.getFile("photo").getOriginalFilename());
		
		System.out.println("사진수정"+infolist.toString());
		
		int rCnt = updateService.updatePhoto(infolist, "", request);
		
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
}
