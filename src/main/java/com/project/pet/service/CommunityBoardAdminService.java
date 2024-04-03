package com.project.pet.service;

import com.project.pet.dto.communityboard.request.CommunityBoardAdminRequestDto;
import com.project.pet.repository.CommunityBoardAdminMapper;
import com.project.pet.repository.CommunityBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardAdminService {

    @Autowired
    CommunityBoardAdminMapper communityBoardAdminMapper;

            public void CommunityBoardAdminRequestDto(CommunityBoardAdminRequestDto communityBoardAdminRequestDto) {

                communityBoardAdminMapper.postCommunityBoardAdmin(communityBoardAdminRequestDto.toEntity());
            }

}
