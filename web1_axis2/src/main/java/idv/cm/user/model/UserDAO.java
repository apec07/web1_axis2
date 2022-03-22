package idv.cm.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.catalina.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import idv.cm.utli.ReadXmlDomParser;

public class UserDAO implements UserImp{
	
	private static DataSource ds = null;
	static Logger LOGGER = LogManager.getLogger(UserDAO.class);
	public static StringBuffer str = new StringBuffer();
	static {
		ReadXmlDomParser readerXml = new ReadXmlDomParser();
		str.append(readerXml.getStr());
		try {
			javax.naming.Context ctx = new javax.naming.InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestMYSQL_AXIS2");
		} catch (NamingException e) {
			LOGGER.error("no DataBase defined!\n"+e.getStackTrace());
		}
	}
	@Override
	public Integer insertUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer updateUser(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer deleteUser(Integer user_no) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserVO getOneUser(Integer user_no) {
		Connection con = null;
		UserVO user = new UserVO();
		try {
			con = ds.getConnection();
			PreparedStatement psmt = con.prepareStatement(GET_ONE_STMT);
			psmt.setInt(1, user_no);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				user.setNo(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
			}
			if(user.getNo()==null) {
				return null;
			}
			
		}catch(SQLException ex) {
			LOGGER.error("SQLException = "+ex);
		}
		return user;
	}
	@Override
	public List<UserVO> getAllUser() {
		Connection con = null;
		List<UserVO> list = new LinkedList<>();
		try {
			con = ds.getConnection();
			PreparedStatement psmt = con.prepareStatement(GET_ALL_STMT);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setNo(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEmail(rs.getString(4));
				list.add(user);
			}
			if(list.size()==0) {
				return null;
			}
			
		} catch (SQLException e) {
			LOGGER.error("SQLException = "+e);
		
		}
		return list;
	}
	@Override
	public List<String> getUserHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	static public StringBuffer getXml() {
		return str;
	}

}
