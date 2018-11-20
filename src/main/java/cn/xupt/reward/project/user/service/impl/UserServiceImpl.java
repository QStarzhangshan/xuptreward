package cn.xupt.reward.project.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xupt.reward.common.constant.UserConstants;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.mapper.UserMapper;
import cn.xupt.reward.project.user.service.UserService;
import cn.xupt.reward.util.Md5Util;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectUserByColCode(String colCode, String colPasswd) {
        try {
			colPasswd = Md5Util.md5(colPasswd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return userMapper.selectUserByColCode(colCode,colPasswd);
    }

    @Override
    public Long selectColRole(String colCode) {
        return userMapper.selectColRole(colCode);
    }

	@Override
	public List<User> findAll(String colSname,String colDname) {
		//PageHelper.startPage(pageNum,pageSize);
		return userMapper.findAll(colSname,colDname);
		 
	}

	@Override
	public String checkColCode(String colCode) {
		int count = userMapper.checkColCode(colCode);
		if(count > 0) {
			System.out.println(UserConstants.USER_COLCODE_NOT_UNIQUE);
			return UserConstants.USER_COLCODE_NOT_UNIQUE;
		}else {
			System.out.println(UserConstants.USER_COLCODE_UNIQUE);
			return UserConstants.USER_COLCODE_UNIQUE;
		}
	}

	@Override
	public void insertUser(User user) {
		 userMapper.insertUser(user);
	}

	@Override
	public User findBycolCode(String colCode) {
		return userMapper.findBycolCode(colCode);
	}

	@Override
	public void updateUserRank(User user1) {
		userMapper.updateUserRank(user1);
		
	}

	@Override
	public int deleteBycolId(Long colId) {
		return userMapper.deleteBycolId(colId);
		
	}

	@Override
	public void updatePasswd(Long colId, String newPasswd) {
		userMapper.updatePasswd(colId,newPasswd);
		
	}

	@Override
	public int fillInfo(String colEmail,String colBankcard,String colIdcard,String colTelephone,Long userId) {
		return userMapper.fillInfo(colEmail,colBankcard,colIdcard,colTelephone,userId);
	}

	@Override
	public String findEmail(String colCode) {
		return userMapper.findEmail(colCode);
	}

	@Override
	public int initPasswd(User user) {
		return userMapper.initPasswd(user);
	}

	@Override
	public Set<User> selectperm(String colCode) {
		return userMapper.selectperm(colCode);
	}

	@Override
	public List<User> findBycolName(String colName) {
		return userMapper.findBycolName(colName);
	}

	@Override
	public int checkcolName(String colName) {
		return userMapper.checkcolName(colName);
	}
}
