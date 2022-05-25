package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Form;
import com.projetspring.WorldsOfLikes.services.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepositoryInterface extends JpaRepository<Form, Integer> {
    Form findByEmail(String email);
    Form findByID(int id);

}
