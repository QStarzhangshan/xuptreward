package cn.xupt.reward.project.user.service;

import java.util.List;

import cn.xupt.reward.project.user.domain.User;

public interface UserService {

    public User selectUserByColCode(String colCode,String colPasswd);

    public Long selectColRole(String colCode);

	public List<User> findAll(String colName, String colDepartment);

	public String checkColCode(String colCode);

	public void insertUser(User user);

}
