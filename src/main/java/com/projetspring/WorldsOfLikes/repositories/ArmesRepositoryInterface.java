package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Armes;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ArmesRepositoryInterface extends JpaRepository<Armes, Integer> {
    Armes findById(int Id);

}
