package notice.model.vo;

import java.util.List;

public class PageData {
	private List<Notice> nList;
	private String pageNavi;

	
	
	
	// 빈 생성자
	public PageData() {}

	// 생성자
	public PageData(List<Notice> nList, String pageNavi) {
		super();
		this.nList = nList;
		this.pageNavi = pageNavi;
	}

	// getters, setters
	public List<Notice> getnList() {
		return nList;
	}

	public void setnList(List<Notice> nList) {
		this.nList = nList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	// toString
	@Override
	public String toString() {
		return "PageData [nList=" + nList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
	
	
	
}
