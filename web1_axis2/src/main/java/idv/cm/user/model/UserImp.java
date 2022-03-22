package idv.cm.user.model;

import java.util.List;

public interface UserImp {
	
	//SQL STMT
		final String CREATE_ONE_STMT=" Insert into user (name,password,email) "
				+ " VALUES (?,?,?)";
		final String UPDATE_ONE_STMT="UPDATE user SET"
				+ " name=?,"
				+ " password=?,"
				+ " email=?,"
				+ " WHERE no=?";
		final String DELETE_ONE_STMT="DELETE FROM user WHERE no=?";
		final String GET_ONE_STMT="SELECT no,name,password,email FROM user WHERE no=?";
		final String GET_ALL_STMT="SELECT no,name,password,email FROM user ORDER BY name ASC";
		//CRUD
		
		Integer insertUser(UserVO user);
		Integer updateUser(UserVO user);
		Integer deleteUser(Integer user_no);
		UserVO getOneUser(Integer user_no);
		List<UserVO> getAllUser();
		List<String> getUserHeader();

}
