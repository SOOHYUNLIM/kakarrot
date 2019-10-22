package org.kakarrot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kakarrot.domain.BoardVO;
import org.kakarrot.domain.Paging;
import org.kakarrot.util.SessionFactory;

public class BoardDAOImpl implements BoardDAO {
	

	@Override
	public boolean insert(BoardVO vo) {
		SqlSession session = SessionFactory.getSession();
		int result = session.insert("org.kakarrot.dao.boardMapper.insert",vo);
		session.commit();	
		session.close();
		return result == -1 ? false : true;
	}

	@Override
	public BoardVO selectOne(Long key) {
		SqlSession session = SessionFactory.getSession();
		BoardVO vo = session.selectOne("org.kakarrot.dao.boardMapper.selectOne",key);
		return vo;
	}

	@Override
	public List<BoardVO> selectList(Paging p) {
		SqlSession session = SessionFactory.getSession();
		List<BoardVO> list = session.selectList("org.kakarrot.dao.boardMapper.selectList",p);
		return list;
	}

}
