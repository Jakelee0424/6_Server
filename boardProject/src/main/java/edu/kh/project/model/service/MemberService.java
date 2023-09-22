package edu.kh.project.model.service;

import static edu.kh.project.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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


	public List<Member> searchUser(String query) throws Exception{
		
		List<Member> list = new ArrayList<Member>();
		
		Connection conn = getConnection();
		
		list = dao.searchUser(conn, query);
		
		close(conn);
		
		return list;
	}




}
