package MetThePet.service.impl;

import MetThePet.model.Post;
import MetThePet.repository.PostRepository;
import MetThePet.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public void save(Post post) {
    postRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public void update(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post getBypostTitle(String postTitle) {
        return postRepository.findByPostTitle(postTitle);
    }

}
