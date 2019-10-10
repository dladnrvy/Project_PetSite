package petsite.project.info.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsite.project.info.dao.InfoDao;
import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;

@Service("updateService")
public class TextUpdateService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	public int updatePhoto(InfoList infolist, String oldFileName, HttpServletRequest request) {
		
		dao = template.getMapper(InfoDao.class);
		
		InfoSave infosave = infolist.toInfoSave();
		
		int Cnt = 0;
		
		String path = "/uploadfile";
		String dir = request.getSession().getServletContext().getRealPath(path);
	
		if(infolist.getPhoto() != null && !infolist.getPhoto().isEmpty()) {
			String newFileName = infolist.getPhoto().getOriginalFilename();
		
		try {
			infolist.getPhoto().transferTo(new File(dir,newFileName));
			infosave.setPhoto(newFileName);
			new File(dir, oldFileName).delete();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			}
		}else {
			infosave.setPhoto(oldFileName);
		}
		
		Cnt = dao.update(infosave);
		
		return Cnt;
	}
	
	public int updateText(InfoList infolist) {
		dao = template.getMapper(InfoDao.class);
		
		int cnt = 0;
		
		InfoSave infosave = infolist.toInfoSave();
		
		cnt = dao.update(infosave);
		
		return cnt;
	}
}
