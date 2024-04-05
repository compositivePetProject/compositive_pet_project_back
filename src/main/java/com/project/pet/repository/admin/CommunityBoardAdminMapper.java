package com.project.pet.repository.admin;

import com.project.pet.entity.communityBoard.CommunityBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardAdminMapper {

   // 커뮤니티 게시판 관리자 공지사항 게시판 추가
   public int postCommunityBoardAdmin(CommunityBoardAdmin communityBoardAdmin);

   // 커뮤니티 게시판 관리자 공지사항 게시판 단건 조회
   public CommunityBoardAdmin getCommunityBoardAdminByBoardId(int boardAdminId);

   // 커뮤니티 게시판 관리자 공지사항 게시판 단건 삭제
   public void deleteCommunityBoardAdminByBoardId(int boardAdminId);

   // 커뮤니티 게시판 관리자 공지사항 게시판 단건 수정.
   public int putCommunityAdminBoard(CommunityBoardAdmin communityBoardAdmin);

}
