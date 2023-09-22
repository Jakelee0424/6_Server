package edu.kh.project.model.dao;

import static edu.kh.project.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.project.model.dto.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MemberDAO(){
		
		try {
			
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/project/sql/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	public Member login(Connection conn, String inputEmail, String inputPw) throws Exception {
		
		Member member = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputEmail);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				member = new Member();
				
				int memberNo = rs.getInt("MEMBER_NO");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberTel = rs.getString("MEMBER_TEL");
				String memberAddress  = rs.getString("MEMBER_ADDR"); 
				String profileImage = rs.getString("PROFILE_IMG");
				int authority = rs.getInt("AUTHORITY");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				member.setMemberNo(memberNo);
				member.setMemberEmail(inputEmail);
				member.setMemberPassword(inputPw);
				member.setMemberNickname(memberNickname);
				member.setMemberTel(memberTel);
				member.setMemberAddress(memberAddress);
				member.setProfileImage(profileImage);
				member.setAuthority(authority);
				member.setEnrollDate(enrollDate);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
		
		
	}


	public List<Member> searchUser(Connection conn, String query) throws Exception{
		List<Member> list = new ArrayList<Member>();
		
		try {
			
			String sql = prop.getProperty("searchUser");
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, query);
						
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String memberEmail = rs.getString("MEMBER_EMAIL");
				String memberTel = rs.getString("MEMBER_TEL");
				
				list.add( new Member(memberNickname, memberEmail, memberTel));
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	
	
}
