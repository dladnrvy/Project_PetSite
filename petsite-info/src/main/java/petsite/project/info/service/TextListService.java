package petsite.project.info.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsite.project.info.dao.InfoDao;
import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.domain.ListView;
import petsite.project.info.domain.SearchParam;

@Service("selectList")
public class TextListService {

	@Autowired
	private SqlSessionTemplate template;
	
	private InfoDao dao;
	
	//자를 숫자
	final int COUNT = 8;
	
	//전체검색
	public InfoSave selectList(int idx) {
		
		dao = template.getMapper(InfoDao.class);
		
		InfoSave infolist = null;
		
		infolist = dao.selectList(idx);
		
	return infolist;	
	}
	
	public int selectCount(int num) {
		dao = template.getMapper(InfoDao.class);
		
		
		int infolist = dao.selectCount();
		InfoSave info = null;
		info.setNum(infolist);
		
		System.out.println("num을 위한 출력"+info.toString());
		System.out.println(infolist);
		
		return infolist;
	}
	
	//카운팅
	public ListView countList(int pageNum) {
		
		dao = template.getMapper(InfoDao.class);
		
		ListView list = new ListView();
		
		//현재 페이지 번호
		list.setPageNum(pageNum);
		
		System.out.println("전 페이지 넘" + pageNum);
		
		//전체게시물의 개수
		int total = dao.selectCount();
		
		System.out.println("전 전체게시물 개수" + total);
		
		//전체 페이지 개수
		int Pagetotalcount = 0;
		
		if(total > 0) {
			Pagetotalcount = total/COUNT;
			if(total % COUNT >0) {
				Pagetotalcount++;
			}
		}
		list.setPageTotalCount(Pagetotalcount);
		
		int index = pageNum*COUNT;
		
		System.out.println("전 인덱스 값" + index);
		
		 List<InfoList> infoList = null;
		 Map<String,Object> search = new HashMap<String, Object>();
		search.put("index",index);
		search.put("count",COUNT);
			
		infoList = dao.selectCountCut(search);

		int no = 1;
		no = total - index; 
		list.setCount(no);
		list.setPageTotalCount(total);
		list.setInfoList(infoList); 
		
		return list;
	}
	
	//제목으로 검색했을때 카운팅
	public ListView titleCount(int pageNum, String title) {
		
		dao = template.getMapper(InfoDao.class);
		
		ListView list = new ListView();
		
		list.setTitle(title);
		list.setPageNum(pageNum);
		
		System.out.println("페이지 넘" + pageNum);
		System.out.println("들어온 타이틀" + title);
		
		//제목으로 검색했을때 나오는 개수
		int titleCnt = dao.TitleCount(title);
		
		System.out.println("제목으로 검색 개수" + titleCnt);
		
		//현재 페이지 번호
		list.setPageNum(pageNum);
	
		//전체 페이지 개수
		int Pagetotalcount = 0;
		
		if(titleCnt > 0) {
			Pagetotalcount = titleCnt/COUNT;
			if(titleCnt % COUNT >0) {
				Pagetotalcount++;
			}
		}
		list.setPageTotalCount(Pagetotalcount);
		
		int index = pageNum*COUNT;
		
		System.out.println("인덱스 값" + index);
		
		 List<InfoList> infoList = null;
		 Map<String,Object> search = new HashMap<String, Object>();
		search.put("text",title);
		search.put("index",index);
		search.put("count",COUNT);
			
		infoList = dao.selectCountCut(search);
		
		list.setInfoList(infoList); 
		int no = 1;
		no = titleCnt - index; 
		list.setCount(no);
		list.setPageTotalCount(titleCnt);
		
		
		
		return list;
	}
	
	//제목으로 검색한 결과
	public List<InfoList> titleinfo(String title) {
		
		dao = template.getMapper(InfoDao.class);
		
		List<InfoList> titl = dao.selectTitles(title);
		
		return titl;
	}
}
