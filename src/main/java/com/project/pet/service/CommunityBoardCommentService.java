package com.project.pet.service;

import com.project.pet.dto.communityboard.request.*;
import com.project.pet.dto.communityboard.response.GetCommunityBoardCommentResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoardComment;
import com.project.pet.entity.communityBoard.CommunityBoardCommentRating;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.CommunityBoardCommentMapper;
import com.project.pet.repository.CommunityBoardCommentRatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardCommentService {

    @Autowired
    private CommunityBoardCommentMapper communityBoardCommentMapper;
    @Autowired
    private CommunityBoardCommentRatingMapper communityBoardCommentRatingMapper;

    // 커뮤니티 게시판 댓글 추가(post)
    @Transactional(rollbackFor = Exception.class)
    public void saveCommunityComments (CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        int successCount = 0;

        CommunityBoardComment communityBoardComment = communityBoardCommentRequestDto.toEntity();
        successCount += communityBoardCommentMapper.saveCommunityBoardComment(communityBoardComment);
        successCount += communityBoardCommentRatingMapper.saveCommunityBoardCommentRating(
                CommunityBoardCommentRating.builder()
                        .communityBoardCommentId(communityBoardComment.getCommunityBoardCommentId())
                        .userId(communityBoardComment.getUserId())
                        .communityBoardCommentRatingValue(communityBoardCommentRequestDto.communityBoardCommentRatingValue)
                        .build()

        );
        if (successCount < 2) {
            throw new RuntimeException("데이터 저장 오류");
        }

    }

    // 커뮤니티 게시판 댓글 다건 조회 (get)
    public List<GetCommunityBoardCommentResponseDto> getCommunityBoardAllCommentsByBoardId(GetCommunityBoardCommentByBoardIdReqDto getCommunityBoardCommentByBoardIdReqDto) {
        System.out.println(getCommunityBoardCommentByBoardIdReqDto);
        System.out.println(communityBoardCommentMapper.getCommunityBoardAllCommentsByBoardId(getCommunityBoardCommentByBoardIdReqDto.getCommunityBoardId()));
        List<CommunityBoardComment> communityBoardComments = communityBoardCommentMapper.getCommunityBoardAllCommentsByBoardId(getCommunityBoardCommentByBoardIdReqDto.getCommunityBoardId());
        return  communityBoardComments.stream().map(CommunityBoardComment::toGetCommunityBoardCommentResponseDto).collect(Collectors.toList());
     }

    // 커뮤니티 게시판 댓글 조회(단건) - boardId를 통해 게시판에 단 댓글을 조회.
     public List<GetCommunityBoardCommentResponseDto> getCommunityBoardCommentByUserId(GetCommunityBoardCommentByUserIdReqDto getCommunityBoardCommentByUserIdReqDto) {
         List<CommunityBoardComment> communityBoardComments = communityBoardCommentMapper.getCommunityBoardCommentByUserId(getCommunityBoardCommentByUserIdReqDto.getUserId());
         return  communityBoardComments.stream().map(CommunityBoardComment::toGetCommunityBoardCommentResponseDto).collect(Collectors.toList());
     }

     // 커뮤니티 게시판 댓글 단건 삭제 (Delete)
     public void deleteCommunityBoardCommentId(DeleteCommunityBoardCommentRequestDto deleteCommunityBoardCommentRequestDto) {
         communityBoardCommentMapper.deleteCommunityBoardComment(deleteCommunityBoardCommentRequestDto.getCommunityBoardCommentId());
     }

     // 커뮤니티 게시판 댓글 다건 삭제 (Delete)
     public void deleteCommunityBoardComment(DeleteCommunityBoardCommentRequestDto deleteCommunityBoardCommentRequestDto) {
        communityBoardCommentMapper.deleteCommunityBoardComment(deleteCommunityBoardCommentRequestDto.getCommunityBoardCommentId());
     }

     // 커뮤니티 게시판 댓글 단건 수정 (put)
     public void updateCommunityBoardComment(UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        CommunityBoardComment communityBoardComment = updateCommunityBoardCommentRequestDto.toEntity();
        communityBoardCommentMapper.updateCommunityBoardComment(communityBoardComment);
        communityBoardCommentRatingMapper.updateCommunityBoardCommentRating (
                CommunityBoardCommentRating.builder()
                        .communityBoardCommentRatingId(updateCommunityBoardCommentRequestDto.getCommunityBoardCommentId())
                        .communityBoardCommentRatingValue(updateCommunityBoardCommentRequestDto.getCommunityBoardCommentRatingValue())
                        .build()
        );
     }
}
