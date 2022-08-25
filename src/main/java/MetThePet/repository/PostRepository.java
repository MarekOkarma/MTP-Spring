package MetThePet.repository;

import MetThePet.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    Post findByPostTitle(String postTitle);


//    List<Post> findAllByTag(String tag);
}
