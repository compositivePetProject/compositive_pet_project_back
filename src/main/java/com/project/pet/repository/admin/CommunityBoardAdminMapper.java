package com.project.pet.repository.admin;

import com.project.pet.entity.CommunityBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardAdminMapper {

   // 커뮤니티 게시판 관리자 공지사항 게시판 추가
   public int postCommunityBoardAdmin(CommunityBoardAdmin communityBoardAdmin);

   // 커뮤니티 게시판 관리자 공지사항 게시판 단건 조회
   public CommunityBoardAdmin getCommunityBoardAdminByBoardId(int adminBoardId);

   // 커뮤니티 게시판 관리자 공지사항 게시판 단건 삭제
   public void deleteCommunityBoardAdminByBoardId(int adminBoardId);



}
