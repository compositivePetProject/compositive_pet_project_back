package com.project.pet.repository;


import com.project.pet.entity.adoptationBoard.AdoptationBoardView;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptationBoardViewMapper {
    public int postAdoptationBoardView (AdoptationBoardView adoptationBoardView);
    public int getAdoptationBoardViewCount (int boardId);
}
