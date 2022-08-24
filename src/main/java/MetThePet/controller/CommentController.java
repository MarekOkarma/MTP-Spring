package MetThePet.controller;

import MetThePet.model.Comment;
import MetThePet.service.CommentService;
import MetThePet.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
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
    public String recipeComments(@PathVariable Integer id,ModelMap modelMap) {
        modelMap.addAttribute("comments", commentService.getAll());
        modelMap.addAttribute("post", postService.getById(id));
        return "redirect:/post-details";
    }
}
