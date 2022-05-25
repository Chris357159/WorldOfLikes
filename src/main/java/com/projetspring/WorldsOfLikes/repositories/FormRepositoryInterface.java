package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Form;
import com.projetspring.WorldsOfLikes.beans.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.From;

public interface FormRepositoryInterface extends JpaRepository<Form, Integer>{

    int countByEmail(String email);
    Form findByEmail(String email);
    Form findById(int id);
}
