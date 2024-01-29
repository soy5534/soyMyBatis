package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	private SqlSession conn;
	private NoticeDAO nDao;

	public NoticeService() {
		conn = SqlSessionTemplate.getSqlSession();
		nDao = new NoticeDAO();
	}

	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(conn, notice);
		if (result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}

	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(conn, notice);
		if(result > 0) {
			conn.commit();
		}else {
			conn.rollback();
		}
		conn.close();
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(conn, noticeNo);
		if (result > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}

	public List<Notice> selectAllNotice() {
		List<Notice> nList = nDao.selectAllNotice(conn);
		conn.close();
		return nList;
	}

	public Notice selectOneByNO(int noticeNo) {
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		conn.close();
		return notice;
	}

	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		conn.close();
		return notice;
	}

}
