package petsite.project.info.dao;

import java.util.List;
import java.util.Map;

import petsite.project.info.domain.InfoList;
import petsite.project.info.domain.InfoSave;
import petsite.project.info.domain.SearchParam;

public interface InfoDao {

	//글 작성
	public int insertWrite(InfoSave infoSave);
	
	//글 수정
	public int update(InfoSave infoSave);
	
	//글 삭제
	public int delete(int idx);
	
	//게시물 개수
	public int selectCount();
	
	//두개 받아서 자르자
	public List<InfoList> selectCountCut(Map<String,Object> search);
	
	//Title로 검색했을때 나오는 개수
	public int TitleCount(String title);
	
	//Title로 검색했을때 나오는 게시물
	public List<InfoList> selectTitle(Map<String,Object> search);
	
	//title로 검색했을때 나오는 게시물
	public List<InfoList> selectTitles(String title);
	
	//게시물 LIST
	public List<InfoList> AllList();
	
	//게시물 내용 idx받아서
	public InfoSave selectList(int idx);
}
