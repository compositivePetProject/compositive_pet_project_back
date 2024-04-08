package com.project.pet.service;

import com.project.pet.dto.communityboard.request.CommunityBoardCommentRequestDto;
import com.project.pet.dto.communityboard.request.UpdateCommunityBoardCommentRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardCommentResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoardComment;
import com.project.pet.repository.CommunityBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardCommentService {

    @Autowired
    private CommunityBoardCommentMapper communityBoardCommentMapper;


    // 커뮤니티 게시판 댓글 추가(post)
    public void postCommunityCommentByBoardId (CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        communityBoardCommentMapper.postCommunityBoardComment(communityBoardCommentRequestDto.toEntity());

    }

    // 커뮤니티 게시판 댓글 다건 조회 (get)
    public List<GetCommunityBoardCommentResponseDto> getCommunityBoardCommentResponseDtos() {
        List<CommunityBoardComment> communityBoardComments = communityBoardCommentMapper.getCommunityBoardComments();
        return  communityBoardComments.stream().map(CommunityBoardComment::toGetCommunityBoardCommentResponseDto).collect(Collectors.toList());

     }

     // 커뮤니티 게시판 댓글 단건 삭제 (Delete)
     public void deleteCommunityBoardCommentId(int CommunityCommentId) {
         communityBoardCommentMapper.deleteCommunityBoardComment(CommunityCommentId);
     }

     // 커뮤니티 게시판 댓글 단건 수정 (put)
     public void updateCommunityBoardCommentId(UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        communityBoardCommentMapper.updateCommunityBoardComment(updateCommunityBoardCommentRequestDto.toEntity());
     }
}
