package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepositoryInterface extends JpaRepository<Form, Integer>{

    int countByEmail(String email);
    Form findByEmail(String email);
}
