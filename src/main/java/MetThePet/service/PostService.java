package MetThePet.service;

import MetThePet.model.Post;
import java.util.List;

public interface PostService {
    void save(Post post);

    List<Post> getAll();

    void deleteById(Integer id);

    void update(Post post);

    Post getById(Integer id);

    Post getBypostTitle(String postTitle);

}
