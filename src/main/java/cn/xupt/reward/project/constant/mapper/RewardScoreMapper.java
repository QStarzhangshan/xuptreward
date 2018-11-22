package cn.xupt.reward.project.constant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RewardScoreMapper {

	List<String> findAllcolType();

	List<String> findAllSubType(@Param("colType") String colType);

}
