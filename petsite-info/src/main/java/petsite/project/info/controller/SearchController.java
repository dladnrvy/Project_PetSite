package petsite.project.info.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.domain.ListView;
import petsite.project.info.service.TextListService;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private TextListService listsevice;
	
	@GetMapping("/{title}")
	public ResponseEntity<List<InfoList>> search(
			@PathVariable("title") String title		
			){
		List<InfoList> list = null;
		list = listsevice.titleinfo(title);
		
		System.out.println("들어온값 : " + title);
		System.out.println("검색 :" + list);
		
		ResponseEntity<List<InfoList>> selectList = new ResponseEntity<List<InfoList>>(list,HttpStatus.OK);
		
		return selectList;
	}
	
	/*
	 * @GetMapping("/{title}/{num}") public ResponseEntity<ListView> pagenum(
	 * 
	 * @PathVariable("title") String title,
	 * 
	 * @PathVariable("num") int num ){ ListView list = null; if(title == "") { list
	 * = listsevice.countList(num); }else { list = listsevice.titleCount(num,
	 * title); }
	 * 
	 * System.out.println("들어온값 : " + title); System.out.println("검색 :" + list);
	 * 
	 * 
	 * ResponseEntity<ListView> selectList = new
	 * ResponseEntity<ListView>(list,HttpStatus.OK);
	 * 
	 * 
	 * return selectList; }
	 */
}
