package com.project.pet.service;

import com.project.pet.dto.communityboard.request.RegisterCommunityBoardRequestDto;
import com.project.pet.dto.communityboard.response.SearchCommunityBoardResponseDto;
import com.project.pet.repository.CommunityBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardService {


    @Autowired
    CommunityBoardMapper communityBoardMapper;

    public void  RegisterCommunityBoardRequestDto (RegisterCommunityBoardRequestDto registerCommunityBoardRequestDto) {


        communityBoardMapper.postCommunityBoard(registerCommunityBoardRequestDto.toEntity());
    }

}
