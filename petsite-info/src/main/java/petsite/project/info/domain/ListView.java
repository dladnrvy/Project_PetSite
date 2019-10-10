package petsite.project.info.domain;

import java.util.List;

public class ListView {

	private List<InfoList> infoList;
	//자르는 숫자
	private int count;
	//현재 페이지 번호
	private int pageNum;
	//전체게시물 개수
	private int pageTotal;
	//총 페이지 숫자
	private int pageTotalCount;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<InfoList> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<InfoList> infoList) {
		this.infoList = infoList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	
	
}
