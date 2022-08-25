package MetThePet.controller;

import MetThePet.model.Post;
import MetThePet.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@Slf4j
@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/list")
    public String postList(ModelMap modelMap) {
        modelMap.addAttribute("posts", postService.getAll());

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("currentUser", currentUser);

        return "post-list";
    }

    @GetMapping("/admin/posts/create")
    public String showCreatePostForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyPost", new Post());
        return "post-create";
    }

    @PostMapping("/admin/posts/save")
    public String handleNewPost(@Valid @ModelAttribute("emptyPost") Post post, Errors errors) {
        log.info("Handle new post: " + post);

        if (errors.hasErrors()) {
            log.error("Errors form frontend: " + errors.getFieldErrors());
            return "post-create";
        }

        postService.save(post);
        return "redirect:/posts/list";
    }

    @GetMapping("/posts/{id}")
    public String postDetails (@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("post", postService.getById(id));
        return "post-details";
    }

    @GetMapping("/admin/posts/edit/{id}")
    public String showEditPostForm(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.addAttribute("book", postService.getById(id));
        return "post-edit";
    }

    @GetMapping("/admin/posts/edit/{postTitle}")
    public String showEditPostFrom(@PathVariable ModelMap modelMap, @PathVariable String postTitle){
        modelMap.addAttribute("post", postService.getBypostTitle(postTitle));
        return "post-edit";
    }

    @PostMapping("/admin/posts/update")
    public  String handleUpdatedPost(@Valid @ModelAttribute("post") Post post, Errors errors){
        log.info("Handle post to update: " + post);

        if (errors.hasErrors()){
            log.error("Errors from frontend: " + errors.getFieldError());
            return "post-edit";
        }

        postService.update(post);
        return "redirect:/posts/list";
    }

    @GetMapping("/admin/posts/delete/{id}")
    public String deletePost(@PathVariable Integer id) {
        log.info("Deleted post with id " + id);
        postService.deleteById(id);
        return "redirect:/posts/list";
    }

}
