package com.project.pet.service;

import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.repository.AdoptationBoardFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptationBoardFavoriteService {
    @Autowired
    private AdoptationBoardFavoriteMapper adoptationBoardFavoriteMapper;

    public void saveAdoptationBoardFavorite(PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
            adoptationBoardFavoriteMapper.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto.toEntity());
    }


}
