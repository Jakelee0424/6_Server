package edu.kh.todo.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static edu.kh.todo.common.JDBCTemplate.*;


import edu.kh.member.model.dao.MemberDAO;
import edu.kh.todo.model.dto.Todo;


public class TodoDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public TodoDAO(){
		
		try {
			
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/todo/sql/todo-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/** 투두리스트 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Todo> select(Connection conn, int memberNo) throws Exception{
		List<Todo> list = new ArrayList<Todo>();
		
		try {
			
			String sql = prop.getProperty("select");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int todoNo = rs.getInt("TODO_NO");
				String todoTitle = rs.getString("TODO_TITLE");
				String todoMemo = rs.getString("TODO_MEMO");
				String todoDate = rs.getString("TODO_DATE");
				String todoDelFlag = rs.getString("TODO_DEL_FL");

				list.add( new Todo(todoNo, todoTitle, todoMemo, todoDate, todoDelFlag, memberNo ));
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	
	
}