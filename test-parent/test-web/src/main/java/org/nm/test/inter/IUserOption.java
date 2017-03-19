package org.nm.test.inter;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.nm.test.model.User;

public interface IUserOption {
	User selectUserById(int id);
	@Select("select * from user")
	List<User> selectUsers();
}
