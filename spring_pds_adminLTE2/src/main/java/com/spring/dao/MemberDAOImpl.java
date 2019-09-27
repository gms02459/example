package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList = session.selectList("Member.selectMemberList",null);
		return memberList;
	}

	@Override
	public MemberVO selectMemberByID(String id) throws SQLException {
		MemberVO member = session.selectOne("Member.selectMemberByID",id);
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		session.update("Member.insertMember",member);
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		session.update("Member.updateMember",member);
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		session.update("Member.deleteMember",id);
	}

}
