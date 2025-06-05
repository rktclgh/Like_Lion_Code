package SpringWorkshop10.com.sec01.repository;

import SpringWorkshop10.com.sec01.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
