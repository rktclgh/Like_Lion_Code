package SpringWorkshop10.com.sec01.controller;


import SpringWorkshop10.com.sec01.entity.Post;
import SpringWorkshop10.com.sec01.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")

public class PostController {


    private final PostRepository repository;
    @Autowired
    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post)
    {
      return repository.save(post);
    }


    @GetMapping
    public Post getAllPosts()
    {
        return repository.findAll().iterator().next();
    }


    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost)
    {
        return repository.findById(id).
                map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    return repository.save(post);
                }).orElseThrow(() -> new IllegalArgumentException("해당 ID의 게시물이 존재하지 않습니다: " + id));
    }


    @DeleteMapping
    public void deletePost(@PathVariable Long id)
    {
        repository.deleteById(id);
    }






}
