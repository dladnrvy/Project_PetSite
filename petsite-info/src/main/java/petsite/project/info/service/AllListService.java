package petsite.project.info.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsite.project.info.dao.InfoDao;
import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;

@Service("AllList")
public class AllListService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	final int COUNT = 16;
	
	//모든 리스트내역
	public List<InfoList> getAllList(){ 
		
		dao = template.getMapper(InfoDao.class);
		
		List<InfoList> list = dao.AllList();
		
		return list;
	}
}
