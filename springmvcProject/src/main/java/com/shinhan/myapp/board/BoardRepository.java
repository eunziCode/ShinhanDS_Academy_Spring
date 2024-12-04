package com.shinhan.myapp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository {
	String namespace = "com.shinhan.board.";

	@Autowired
	SqlSession sql;
	
	public List<BoardDTO> findAll() {
		return sql.selectList(namespace + "selectAll");
	}
	
	public BoardDTO findById(Long bno) {
		return sql.selectOne(namespace + "selectById", bno);
	}
	
	public int insert(BoardDTO board) {
		return sql.insert(namespace + "insert", board);
	}
	
	public int update(BoardDTO board) {
		return sql.update(namespace + "update", board);
	}
	
	public int delete(Long bno) {
		return sql.delete(namespace + "delete", bno);
	}
	
}
