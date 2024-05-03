package com.project.pet.service;

import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.repository.AdoptationBoardFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AdoptationBoardFavoriteService {
    @Autowired
    private AdoptationBoardFavoriteMapper adoptationBoardFavoriteMapper;


    @Transactional
    public void saveAdoptationBoardFavorite(PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
            adoptationBoardFavoriteMapper.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto.toEntity());


    }

    public int getAdoptationBoardFavorite(int boardId) {
        int adoptationBoardFavorites = adoptationBoardFavoriteMapper.getAdoptationBoardFavorite(boardId);
        return adoptationBoardFavorites;
    }


    public void deleteAdoptationBoardFavorite(Map<String, Integer> params) {
        adoptationBoardFavoriteMapper.deleteAdoptationBoardFavorite(params);
    }

    public int findMyUserIdByBoardId(int boardId) {
        return adoptationBoardFavoriteMapper.findMyUserIdByBoardId(boardId);
    }


}
