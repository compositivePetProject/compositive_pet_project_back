package com.project.pet.repository.admin;


import com.project.pet.entity.AdoptationBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptationBoardAdminMapper {


    //공지사항 작성
    public int postAdoptationBoardAdmin(AdoptationBoardAdmin adoptationBoardAdmin);

    //공지사항 단건 조회
    public AdoptationBoardAdmin getAdoptationBoardAdminByNoticeId(int noticeId);

}
