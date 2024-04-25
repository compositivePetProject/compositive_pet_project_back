package com.project.pet.service;

import com.project.pet.dto.adoptation.request.DeleteAdoptationBoardLikeReqDto;
import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.dto.adoptation.response.GetAdoptationFavoriteRespDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardFavorite;
import com.project.pet.repository.AdoptationBoardFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardFavoriteService {
    @Autowired
    private AdoptationBoardFavoriteMapper adoptationBoardFavoriteMapper;

    public void saveAdoptationBoardFavorite(PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
            adoptationBoardFavoriteMapper.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto.toEntity());
    }

    public List<GetAdoptationFavoriteRespDto> getAdoptationBoardFavorite(int boardId) {
        List<AdoptationBoardFavorite> adoptationBoardFavorites = adoptationBoardFavoriteMapper.getAdoptationBoardFavorite(boardId);
        return adoptationBoardFavorites.stream().map(AdoptationBoardFavorite::toGetAdoptationFavoriteRespDto).collect(Collectors.toList());
    }

    public void deleteAdoptationBoardFavorite(Map<String, Integer> params) {
        adoptationBoardFavoriteMapper.deleteAdoptationBoardFavorite(params);
    }


}
