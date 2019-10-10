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

@Service("write")
public class WriteService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	
	public int write(InfoList infoList, HttpServletRequest request) {
		
		dao = template.getMapper(InfoDao.class);
		
		String path = "/uploadfile";
		
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		int rCnt = 0;
		String newFileName = "";
		
		InfoSave info = infoList.toInfoSave();
		
		try {
		if(infoList.getPhoto() != null) {
			newFileName = infoList.getPhoto().getOriginalFilename();
			infoList.getPhoto().transferTo(new File(dir,newFileName));
			info.setPhoto(newFileName);
				}
		rCnt = dao.insertWrite(info);
		
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				if(infoList.getPhoto() != null) {
					new File(dir,newFileName).delete();
				}
					
			}
		
		
		
		
		return rCnt;
	}
}
