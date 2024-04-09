package com.project.pet.repository;

import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardFavorite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptationBoardFavoriteMapper {
    public int saveAdoptationBoardFavorite(AdoptationBoardFavorite adoptationBoardFavorite);
}
