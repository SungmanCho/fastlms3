package com.zerobase.fastlms.admin.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zerobase.fastlms.admin.dto.MemberLogDto;

@Mapper
public interface MemberLogMapper {
	List<MemberLogDto> selectListMyHistory(String userId);
	
	long selectListCount(String userId);
}
