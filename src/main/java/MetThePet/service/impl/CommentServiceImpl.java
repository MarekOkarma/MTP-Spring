package MetThePet.service.impl;

import MetThePet.model.Comment;
import MetThePet.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private List<Comment> comments;

    public CommentServiceImpl() {
        comments = new ArrayList<>();
    }

    @Override
    public void save(Comment comment) {

        comments.add(comment);
    }

    @Override
    public List<Comment> getAll() {
        return comments;
    }
}
