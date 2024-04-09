package com.project.pet.service;

import com.project.pet.dto.communityboard.request.CommunityBoardFavoriteRequestDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.CommunityBoardFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardFavoriteService {

    @Autowired
    private CommunityBoardFavoriteMapper communityBoardFavoriteMapper;

    private PrincipalUser getPrincipalUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return principalUser;
    }

    // 게시물
    public GetCommunityBoardFavoriteResponseDto getCommunityBoardFavoritesCountByBoardId(int CommunityFavoriteId) {
        return communityBoardFavoriteMapper.getCommunityBoardFavoritesCount(CommunityFavoriteId).toGetCommunityBoardFavoriteResponseDto();
    }

    // 게시물 좋아요 증가 등록(Post)
    public void postCommunityBoardFavoriteByBoardId (CommunityBoardFavoriteRequestDto communityBoardFavoriteRequestDto) {
        communityBoardFavoriteMapper.postCommunityBoardFavorite(communityBoardFavoriteRequestDto.toEntity(getPrincipalUser().getUserId()));
    }

    // 게시물 좋아요 감소 (Delete)
    public void deleteCommunityBoardFavoriteByBoardId(int CommunityBoardFavoriteId) {
        communityBoardFavoriteMapper.deleteCommunityBoardFavorite(CommunityBoardFavoriteId);
    }

}
