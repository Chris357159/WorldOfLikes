package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.UserData;
import com.projetspring.WorldsOfLikes.beans.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepositoryInterface extends JpaRepository<UserProfile,Integer> {
String findUsernameById(int id);
UserProfile findById(int id);
List<UserProfile> findAll();
UserProfile findByLogin(UserData login);
UserProfile findByIsLogged(int binary);

}
