package MetThePet.service.impl;

import MetThePet.model.Comment;
import MetThePet.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    public List<Comment> commentList;

    public void CommentService(){
        commentList = new ArrayList<>();
        commentList.add(new Comment());
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public List<Comment> getAll() {
        return null;
    }
}
