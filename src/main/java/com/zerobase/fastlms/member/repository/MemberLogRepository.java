package com.zerobase.fastlms.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerobase.fastlms.member.entity.MemberLog;

public interface MemberLogRepository extends JpaRepository<MemberLog, Long>{

}
