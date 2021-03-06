package cn.xupt.reward.project.user.service;

import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;

import cn.xupt.reward.project.user.domain.User;

public interface UserService {

    public User selectUserByColCode(String colCode,String colPasswd);

    public Long selectColRole(String colCode);

	public List<User> findAll(String colSname, String colDname);

	public String checkColCode(String colCode);

	public void insertUser(User user);

	public User findBycolCode(String colCode);

	public void updateUserRank(User user1);

	public int deleteBycolId(Long colId);

	public void updatePasswd(Long colId, String newPasswd);

	public int fillInfo(String colEmail,String colBankcard,String colIdcard,String colTelephone,Long userId);

	public String findEmail(String colCode);

	public int initPasswd(User user);

	public Set<User> selectperm(String colCode);

	public List<User> findBycolName(String colName);

	public int checkcolName(String colName);

}
