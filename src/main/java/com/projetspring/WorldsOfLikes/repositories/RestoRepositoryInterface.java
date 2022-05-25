package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Menu;
import com.projetspring.WorldsOfLikes.beans.Restauration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestoRepositoryInterface extends JpaRepository<Restauration,Integer> {
    Restauration findById(int id);
    Restauration findBymenutab(Menu menu);



}
