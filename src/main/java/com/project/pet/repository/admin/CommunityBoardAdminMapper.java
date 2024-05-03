package com.project.pet.repository.admin;

import com.project.pet.entity.communityBoard.CommunityBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardAdminMapper {

   // 커뮤니티 게시판 관리자 공지사항 게시판 추가
   public int postCommunityBoardAdmin(CommunityBoardAdmin communityBoardAdmin);

   // 커뮤니티 게시판 관리자 해당BoardId로 공지사항 게시판 단건 조회
   public CommunityBoardAdmin getCommunityBoardAdminByBoardId(int communityBoardAdminId);

   //커뮤니티 게시판 관리자 공지사항 게시판 다건 조회
   public List<CommunityBoardAdmin> getCommunityBoardsAdmin();

   // 커뮤니티 게시판 관리자 해당BoardId로 공지사항 게시판 단건 삭제
   public void deleteCommunityBoardAdminByBoardId(int communityBoardAdminId);

   // 커뮤니티 게시판 관리자 공지사항 게시판 다건 삭제
   public void deleteCommunityAdminBoards(List<Integer> boardAdminIds);

   // 커뮤니티 게시판 관리자 해당BoardId로 공지사항 게시판 단건 수정.
   public int putCommunityAdminBoard(CommunityBoardAdmin communityBoardAdmin);

}
