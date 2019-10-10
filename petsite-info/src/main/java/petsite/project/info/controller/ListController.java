package petsite.project.info.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.service.AllListService;
import petsite.project.info.service.TextDeleteService;
import petsite.project.info.service.TextListService;
import petsite.project.info.service.TextUpdateService;
import petsite.project.info.service.WriteService;

@RestController
@CrossOrigin
@RequestMapping("/infoMain")
public class ListController {

	@Autowired
	private AllListService listService;
	
	@Autowired
	private WriteService writeService;
	
	@Autowired
	private TextListService selectService;
	
	@Autowired
	private TextUpdateService updateService;
	
	@Autowired
	private TextDeleteService deleteService;
	
	@GetMapping
	public ResponseEntity<List<InfoList>> allList(){
		
		List<InfoList> list = listService.getAllList();
		
		System.out.println(list);
		
		ResponseEntity<List<InfoList>> allList = new ResponseEntity<List<InfoList>>(list, HttpStatus.OK);
		
		return allList;
	}
	
	@GetMapping("/{idx}")
	public ResponseEntity<InfoSave> selectList(
			@PathVariable("idx") int idx
			){
		
		InfoSave cnt = null;
		cnt = selectService.selectList(idx);
	
		return new ResponseEntity<InfoSave>(cnt,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> Write(
			InfoList infolist,
			MultipartHttpServletRequest request) {
		
		System.out.println(request.getFile("photo").getOriginalFilename());
		
		System.out.println(infolist.toString());
		
		int rCnt = writeService.write(infolist,request);
		
		System.out.println(rCnt);
		
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}

	
	@PutMapping("/{idx}")
	public ResponseEntity<String> Update(
			@PathVariable("idx") int idx,
			@RequestBody InfoList infolist
			){
		infolist.setIdx(idx);
		
		System.out.println("글수정"+infolist.toString());
		
		int cnt = updateService.updateText(infolist);
		
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> delete(
			@PathVariable("idx") int idx
			){
	
		int cnt = deleteService.TextDelete(idx);
		
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
		
	}
	
	
}
