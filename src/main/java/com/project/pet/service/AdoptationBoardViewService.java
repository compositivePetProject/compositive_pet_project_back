package com.project.pet.service;


import com.project.pet.dto.adoptation.request.PostAdoptationViewReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardView;
import com.project.pet.repository.AdoptationBoardViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptationBoardViewService {
    @Autowired
    private AdoptationBoardViewMapper adoptationBoardViewMapper;

    public void postadoptationBoardView (PostAdoptationViewReqDto postAdoptationViewReqDto) {
        adoptationBoardViewMapper.postAdoptationBoardView(postAdoptationViewReqDto.toEntity());
    }

    public int getAdoptationBoardViewCount (int boardId) {
        int viewCount = adoptationBoardViewMapper.getAdoptationBoardViewCount(boardId);
        return viewCount;
    }
}
