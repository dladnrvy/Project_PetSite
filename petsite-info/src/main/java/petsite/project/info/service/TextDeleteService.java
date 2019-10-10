package petsite.project.info.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsite.project.info.dao.InfoDao;

@Service("deleteService")
public class TextDeleteService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	
	public int TextDelete(int idx) {
	
		int cnt = 0;
		
		dao = template.getMapper(InfoDao.class);
		
		cnt = dao.delete(idx);
		
		return cnt;
	}
}
