package edu.kh.project.model.service;

import static edu.kh.project.common.JDBCTemplate.*;
import java.sql.Connection;

import edu.kh.project.model.dao.MemberDAO;
import edu.kh.project.model.dto.Member;


public class MemberService {

	private MemberDAO dao = new MemberDAO(); 
	
	
	public Member login(String inputEmail, String inputPw) throws Exception {
		
		Connection conn = getConnection();
		
		Member member = dao.login(conn, inputEmail, inputPw);
		
		close(conn);		
		
		return member;
		
		
	}

}
