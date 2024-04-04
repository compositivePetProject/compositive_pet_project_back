package com.project.pet.repository;

import com.project.pet.entity.OAuth2;
import com.project.pet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public User findUserByNickname(String nickname);
    public User findUserByOAuth2name(String oAuth2name);
    public int saveUser(User user);
    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);
    public int saveOAuth2(OAuth2 oAuth2);
}
