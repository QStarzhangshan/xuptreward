package cn.xupt.reward.project.constant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperScoreMapper {

	List<String> findAllType();

	
}
