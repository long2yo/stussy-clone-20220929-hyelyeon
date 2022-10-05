package com.stussy.stussyclone20220929hyelyeon.repository;

import com.stussy.stussyclone20220929hyelyeon.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {

    public int save(User user);

    public User findUserByEmail(String Email);
}
