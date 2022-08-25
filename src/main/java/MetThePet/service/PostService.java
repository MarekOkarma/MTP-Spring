package MetThePet.service;

import MetThePet.model.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {
    void save(Post post);

    List<Post> getAll();

    void deleteById(Integer id);

    void update(Post post);

    Optional<Post> getById(Integer id);

    Post getBypostTitle(String postTitle);

}
