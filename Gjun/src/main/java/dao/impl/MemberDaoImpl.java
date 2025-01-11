package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import util.DbConntecion;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		new MemberDaoImpl().addMember(new Member("ll","456","789789","789789","222","456456878"));
		//System.out.print(new MemberDaoImpl().findByUsernameAndPassword("99", "789789"));
		//System.out.print(new MemberDaoImpl().findByUsername("aaa"));
		

	}

	
	private static Connection conn=DbConntecion.getDb();
	
	@Override
	public void addMember(Member m) {
		/*
		 * 1.SQL語法
		 * 2.交給PreparedStatement
		 * 3.excuteUpdate
		 */
		String SQL="insert into member(name,username,password,address,phone,mobile) value(?,?,?,?,?,?)";
		//SQL如果有問題的話可以直接複製裡面內容再到mysql那邊直接做測試            
		try {
			PreparedStatement preparedStatment=conn.prepareStatement(SQL);
			preparedStatment.setString(1, m.getName());
			preparedStatment.setString(2, m.getUsername());
			preparedStatment.setString(3, m.getPassword());
			preparedStatment.setString(4, m.getAddress());
			preparedStatment.setString(5, m.getPhone());
			preparedStatment.setString(6, m.getMobile());
			preparedStatment.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Member findByUsernameAndPassword(String username, String password) {
		/*
		 * 1.SQL語法
		 * 2.PreparedStatement->execute	Query()
		 * 3.ResultSet
		 */
		String SQL="select * from member where username=? and password=?";
		Member member=null;
		
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				member=new Member();
				member.setId(resultSet.getInt("id"));
				member.setName(resultSet.getString("name"));
				member.setUsername(resultSet.getString("username"));
				member.setPassword(resultSet.getString("password"));
				member.setAddress(resultSet.getString("address"));
				member.setPhone(resultSet.getString("phone"));
				member.setMobile(resultSet.getString("mobile"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return member;
	}

	@Override
	public boolean findByUsername(String username) {
		/*
		 * 1.SQL語法,boolean變數
		 * 2.PreraredStatement->executeQuery
		 * 3.ResultSet->true/false
		 */
		String SQL="select * from member where username=?";
		boolean isUsernameBeenUse=false;
		try {
			PreparedStatement preparedStatement=conn.prepareStatement(SQL);
			preparedStatement.setString(1, username);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) isUsernameBeenUse=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return isUsernameBeenUse;
	}

}
