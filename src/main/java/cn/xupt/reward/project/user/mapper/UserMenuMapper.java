package cn.xupt.reward.project.user.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.xupt.reward.project.user.domain.User;

@Mapper
public interface UserMenuMapper {

	User selectperm(@Param("colCode") String colCode);

}
