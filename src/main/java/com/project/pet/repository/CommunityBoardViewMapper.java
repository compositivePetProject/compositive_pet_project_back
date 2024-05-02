package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardView;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardViewMapper {

    public int postCommunityBoardView (CommunityBoardView communityBoardView);

    public void getCommunityBoardViewCount (int communityBoardId);


}
