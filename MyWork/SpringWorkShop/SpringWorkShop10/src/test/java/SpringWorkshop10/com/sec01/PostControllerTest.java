package SpringWorkshop10.com.sec01;

import SpringWorkshop10.com.sec01.entity.Post;
import SpringWorkshop10.com.sec01.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testPostController() throws Exception {
        //테스트 포스트 저장
        Post post = new Post();
        post.setTitle("테스트 제목");
        post.setContent("테스트 본문");
        postRepository.save(post);

        // when
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("테스트 제목"))
                .andExpect(jsonPath("$.content").value("테스트 본문"));

        // then
        assertThat(postRepository.findAll())
                .extracting("title")
                .contains("테스트 제목");

    }
}
