package com.project.pet.repository.admin;


import com.project.pet.entity.AdoptationBoardAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdoptationBoardAdminMapper {

    public int postAdoptationBoardAdmin(AdoptationBoardAdmin adoptationBoardAdmin);

}
