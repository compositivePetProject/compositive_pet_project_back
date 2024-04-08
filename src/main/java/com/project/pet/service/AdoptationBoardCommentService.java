package com.project.pet.service;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.AdoptationBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AdoptationBoardCommentService {

    @Autowired
    private AdoptationBoardCommentMapper adoptationBoardCommentMapper;

    //댓글 작성
    public void saveAdoptationBoardComment (PostAdoptationBoardCommentReqDto postAdoptationBoardCommentReqDto) {

        adoptationBoardCommentMapper.saveAdoptationBoardComment(postAdoptationBoardCommentReqDto.toEntity());
    }
}
