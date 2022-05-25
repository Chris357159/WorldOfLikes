package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Form;
import com.projetspring.WorldsOfLikes.beans.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetworkRepositoryInterface extends JpaRepository<SocialNetwork,Integer> {
String findUsernameById(int id);
SocialNetwork findById(int id);

}
