package notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession conn, Notice notice) {
		int result = conn.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectAllNotice(SqlSession conn, int currentPage) {
		/*
		 * RowBounds(offset, limit); offset: 시작값 limit: 한 페이지당 보여주는 게시물의 갯수
		 */
		int limit = 10;
		int offset = (currentPage - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = conn.selectList("NoticeMapper.selectAllNotice", null, rowBounds); // *rowBounds 자리는 3번째.
		return nList;
	}

	public Notice selectOneByNo(SqlSession conn, int noticeNo) {
		Notice notice = conn.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int deleteNotice(SqlSession conn, int noticeNo) {
		int result = conn.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public int updateNotice(SqlSession conn, Notice notice) {
		int result = conn.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	public String generateNavi(SqlSession conn, int currentPage) { // Connection conn 이었는데 mybatis에선 SqlSession 사용 !
		int totalCount = this.getTotalCount(conn);
		int recordCountPerPage = 10; // 페이지당 출력 수
		int totalNaviCount; // 범위의 총갯수 지정
		int naviCountPerPage = 10; // 한 페이지당 보여줄 범위의 수
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount / recordCountPerPage + 1;
		}else {
			totalNaviCount = totalCount / recordCountPerPage;
		}
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
		int endNavi = startNavi + recordCountPerPage -1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}		
		StringBuffer result = new StringBuffer(); // StringBuffer ?
//		boolean needPrev = true;
//		boolean needNext = true;
//		if(startNavi == 1) {
//			needPrev = false;
//		}
		if(startNavi != 1) {
			result.append("<a href='/notice/list.do?page="+(startNavi-1)+"'>[이전]</a>");
		}
		for(int i = startNavi ; i <= endNavi; i++) {
			result.append("<a href='/notice/list.do?page="+i+"'>"+i+"</a> ");					
		}
		if(endNavi != totalNaviCount) {
			result.append(" <a href='/notice/list.do?page="+(endNavi+1)+"'>[다음]</a>");	
		}
		return result.toString();
		
	}

	// 게시물의 총 갯수
	private int getTotalCount(SqlSession conn) {
		int result = conn.selectOne("NoticeMapper.getTotalCount");
			System.out.println(result);
		return result;
	}
	
}