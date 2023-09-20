package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;
import static edu.kh.jsp.common.JDBCTemplate.*;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	
	public List<Student> selectAll() throws Exception{
		
		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		List<Student> stdList = dao.selectAll(conn);
		
		close(conn);
		
		return stdList;
	}

	public List<Student> archSelect() throws Exception{
		
		Connection conn = getConnection();
		
		List<Student> archStd = dao.archSelect(conn);
		
		close(conn);
		
		return archStd;
	}

	public List<Student> deptSelect(String dept) throws Exception {

		Connection conn = getConnection();
		
		List<Student> list = dao.deptSelect(conn, dept);
		
		close(conn);
		
		return list;
	}

}
