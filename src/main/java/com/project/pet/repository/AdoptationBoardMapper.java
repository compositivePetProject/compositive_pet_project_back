package com.project.pet.repository;


import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.entity.AdoptationBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptationBoardMapper {

    public int postAdoptationBoard(AdoptationBoard adoptationBoard);

}
