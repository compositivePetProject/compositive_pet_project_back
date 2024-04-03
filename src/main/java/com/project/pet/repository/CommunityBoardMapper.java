package com.project.pet.repository;

import com.project.pet.entity.CommunityBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardMapper {


    public int postCommunityBoard(CommunityBoard communityBoard);




    }












