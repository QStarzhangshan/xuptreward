package cn.xupt.reward.project.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.user.domain.User;

/**
 *@author ZH
 * */
@Mapper
public interface UserMapper {

    public User selectUserByColCode(@Param("colCode")String colCode,@Param("colPasswd")String colPasswd);

    public Long selectColRole(String colCode);

	public List<User> findAll(@Param("colName") String colName, @Param("colSchool") String colSchool);

	public int checkColCode(String colCode);

	public void insertUser(User user);

	public User findBycolCode(@Param("colCode") String colCode);

	public void updateUserRank(User user1);

	public void deleteBycolId(@Param("colId") Long colId);

	public void updatePasswd(Long colId,String newPasswd);

	public int fillInfo(User user);

	public String findEmail(@Param("colCode") String colCode);

	public int initPasswd(User user);

}
