package MetThePet.controller;

import MetThePet.model.Comment;
import MetThePet.service.CommentService;
import MetThePet.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/comments")
@Slf4j
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;


    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping("comments/create")
    public String showCommentForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyComment", new Comment());
        return "comment-create";
    }

    @PostMapping("/comments/{id}/save")
    public String handleNewPost(@PathVariable @ModelAttribute("emptyComment") Integer id, Comment comment) {
        commentService.save(comment);
        return "redirect:/post-details";
    }

    @GetMapping("/posts/{id}/comments")
    public String postComments(@PathVariable Integer id,ModelMap modelMap) {
        modelMap.addAttribute("comments", commentService.getAll());
        modelMap.addAttribute("post", postService.getById(id));
        return "redirect:/post-details";
    }
}
