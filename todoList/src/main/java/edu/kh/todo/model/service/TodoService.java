package edu.kh.todo.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static edu.kh.todo.common.JDBCTemplate.*;

import edu.kh.todo.model.dao.TodoDAO;
import edu.kh.todo.model.dto.Todo;


public class TodoService {
	
	TodoDAO dao = new TodoDAO();

	/** 회원별 투두 리스트 조회 서비스
	 * @param memberNo
	 * @return
	 */
	public List<Todo> select(int memberNo) throws Exception{
		
		List<Todo> list = new ArrayList<Todo>();
		
		Connection conn = getConnection();
		
		list = dao.select(conn, memberNo);
		
		close(conn);		
		
		return list;
	}

}
