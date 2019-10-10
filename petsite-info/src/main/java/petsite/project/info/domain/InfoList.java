package petsite.project.info.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class InfoList {

	private int idx;
	private String uId;
	private String title;
	private String text;
	private MultipartFile photo;
	private String date;
	private int num;

	public InfoList() {}
	


	public InfoList(int idx, String uId, String title, String text, MultipartFile photo, String date, int num) {
		this.idx = idx;
		this.uId = uId;
		this.title = title;
		this.text = text;
		this.photo = photo;
		this.date = date;
		this.num = num;
	}


	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
	}



	public String getuId() {
		return uId;
	}



	public void setuId(String uId) {
		this.uId = uId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public MultipartFile getPhoto() {
		return photo;
	}



	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "InfoList [idx=" + idx + ", uId=" + uId + ", title=" + title + ", text=" + text + ", photo=" + photo
				+ ", date=" + date + ", num=" + num + "]";
	}



	public InfoSave toInfoSave() {
		
		InfoSave info = new InfoSave();
		info.setIdx(idx);
		info.setuId(uId);
		info.setTitle(title);
		info.setText(text);
		info.setNum(num);
		
		return info;
	}
	
	
		
	

}
