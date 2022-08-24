package MetThePet.controller;

import MetThePet.model.Post;
import MetThePet.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/create")
        public String showCreatePostFrom(ModelMap modelMap){
        modelMap.addAttribute("emptyPost", new Post());
        return "post-create";
    }

    @PostMapping("/posts/save")
    public String handleNewPost(@ModelAttribute("emptyPost") Post post) {
        postService.save(post);
        return "redirect:/posts/list";
    }

    @GetMapping("/posts/list")
    public String showPosts(Model model){
        List<Post> postList = postService.getAll();
        model.addAttribute("posts", postService.getAll());
        return "post-list";
    }

    @GetMapping("/posts/{id}")
    public String postDetails (@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("post", postService.getById(id));
        return "post-details";
    }

    @GetMapping ("/posts/delete/{id}")
    public  String deletePost(@PathVariable Integer id){
        log.info("deleted Post by id with " + id);
        postService.deleteById(id);
        return "redirect:/posts/list";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditPostFrom(@PathVariable Integer id, ModelMap modelMap){
        modelMap.addAttribute("post", postService.getById(id));
        return "post-edit";
    }

    @PostMapping("/posts/update")
    public  String handleUpdatedPost(@Valid @ModelAttribute("post") Post post, Errors errors){
        log.info("Handle post to update: " + post);

        if (errors.hasErrors()){
            log.error("Errors from frontend: " + errors.getFieldError());
            return "post-edit";
        }

        postService.update(post);
        return "redirect:/posts/list";
    }
}
