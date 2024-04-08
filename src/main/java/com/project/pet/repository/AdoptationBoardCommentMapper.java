package com.project.pet.repository;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptationBoardCommentMapper {

    public int saveAdoptationBoardComment(AdoptationBoardComment adoptationBoardComment);
}

