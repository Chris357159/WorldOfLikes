package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Restauration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestoRepositoryInterface extends JpaRepository<Restauration,Integer> {
    Restauration findById(int idResto);
}
