package MetThePet.service.impl;

import MetThePet.model.Post;
import MetThePet.repository.PostRepository;
import MetThePet.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Post> post = getById(id);
        postRepository.deleteById(id);
    }

    @Override
    public void update(Post post) {
        postRepository.save(post);
    }

    @Override
    public Optional<Post> getById(Integer id) {
        return Optional.ofNullable(postRepository.findById(id).orElse(null));
    }

    @Override
    public Post getBypostTitle(String postTitle) {
        return postRepository.findByPostTitle(postTitle);
    }

}
