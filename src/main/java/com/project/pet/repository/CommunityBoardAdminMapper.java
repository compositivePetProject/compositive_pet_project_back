package com.project.pet.repository;

import com.project.pet.entity.CommunityBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommunityBoardAdminMapper {

   public int postCommunityBoardAdmin(CommunityBoardAdmin communityBoardAdmin);


}
