package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.dto.Student;

import static edu.kh.jsp.common.JDBCTemplate.*;


public class StudentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	// 기본 생성자로 객체 생성 시, sql이 작성된 xml 파일 읽어와 prop에 저장
	public StudentDAO(){
	
		try {
			
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}


	
	public List<Student> selectAll(Connection conn) throws Exception{
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			
			// 2. sql 작성
			String sql = prop.getProperty("selectAll");
			
			// 3. Statement 객체 생성 
			stmt = conn.createStatement();
			
			// 4. sql 수행 후 반환
			rs = stmt.executeQuery(sql);
			
			// 5. rs에 값 저장
			while(rs.next()) {
				
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studenAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				
				Student student = new Student(studentNo, studentName, studenAddress, departmentName);
				
				stdList.add(student);
			}
			
		}finally {
			// 6. 사용한 자원 반환
			close(rs);
			close(stmt);
		}
		
		// 7. 리턴
		return stdList;
	}



	public List<Student> archSelect(Connection conn) throws Exception{
		
		List<Student> archStd = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("archSelect");

			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studenAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				
				Student student = new Student(studentNo, studentName, studenAddress, departmentName);
				
				archStd.add(student);
			}
		
		} finally {
			close(rs);
			close(stmt);
			
		}
		return archStd;
	}



	public List<Student> deptSelect(Connection conn, String dept) throws Exception {

		List<Student> list = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("deptSelect");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studenAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				Student student = new Student(studentNo, studentName, studenAddress, departmentName);
				
				list.add(student);
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return list;
	}
	
	
	
	
}
