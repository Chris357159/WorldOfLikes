package com.projetspring.WorldsOfLikes.repositories;

import com.projetspring.WorldsOfLikes.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositoryInterface extends JpaRepository<Post,Integer> {
    Post findById(int id);
}
