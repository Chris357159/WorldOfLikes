package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepositoryInterface extends JpaRepository<UserData, Integer>{

    int countByEmail(String email);
    UserData findByEmail(String email);
    UserData findById(int id);
}
