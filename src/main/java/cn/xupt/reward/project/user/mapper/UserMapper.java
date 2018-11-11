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

	public List<User> findAll(@Param("colSname") String colSname, @Param("colDname") String colDname);

	public int checkColCode(String colCode);

	public void insertUser(User user);

	public User findBycolCode(@Param("colCode") String colCode);

	public void updateUserRank(User user1);

	public int deleteBycolId(@Param("colId") Long colId);

	public void updatePasswd(@Param("colId") Long colId,@Param("newPasswd") String newPasswd);

	public int fillInfo(@Param("colEmail")String colEmail,@Param("colBankcard")String colBankcard,@Param("colIdcard")String colIdcard,@Param("colTelephone")String colTelephone,@Param("userId") Long userId);

	public String findEmail(@Param("colCode") String colCode);

	public int initPasswd(User user);

}
