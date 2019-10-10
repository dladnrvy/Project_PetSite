package petsite.project.info.domain;

public class SearchParam {
	
	private String title;
	

	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "SearchParam [title=" + title + "]";
	}
	
	public InfoList toInfoList() {
		InfoList info = new InfoList();
		
		info.setTitle(title);
		return info;
	}
	
	

}
