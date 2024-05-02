package com.project.pet.service;


import com.project.pet.dto.communityboard.request.PostCommunityBoardViewReqDto;
import com.project.pet.repository.CommunityBoardViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityBoardViewService {

    @Autowired
    private CommunityBoardViewMapper communityBoardViewMapper;


    public void postCommunityBoardView (PostCommunityBoardViewReqDto postCommunityBoardViewReqDto) {
        communityBoardViewMapper.postCommunityBoardView(postCommunityBoardViewReqDto.toEntity());

    }


    public void getBoardViewCount (int communityBoardId) {

     communityBoardViewMapper.getCommunityBoardViewCount(communityBoardId);

    }
}



