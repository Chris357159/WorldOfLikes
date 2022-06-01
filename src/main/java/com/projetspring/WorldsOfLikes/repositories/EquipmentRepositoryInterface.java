package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EquipmentRepositoryInterface extends JpaRepository<Equipment, Integer> {

    Equipment findById(int Id);

}
