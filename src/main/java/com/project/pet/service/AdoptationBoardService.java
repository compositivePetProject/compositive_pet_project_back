package com.project.pet.service;

import com.project.pet.dto.request.GetAdoptationBoardReqDto;
import com.project.pet.dto.request.PostAdoptationBoardReqDto;
import com.project.pet.dto.response.GetAdoptationBoardRespDto;
import com.project.pet.entity.AdoptationBoard;
import com.project.pet.repository.AdoptationBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardService {

    @Autowired
    private AdoptationBoardMapper adoptationBoardMapper;

    public void postAdoptationBoard (PostAdoptationBoardReqDto postAdoptationBoardReqDto) {
        adoptationBoardMapper.postAdoptationBoard(postAdoptationBoardReqDto.toEntity());
    }








}
