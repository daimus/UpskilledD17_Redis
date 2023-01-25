package id.daimus.redis.infrastructure.data.redis.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedisBookRepository extends CrudRepository<BookEntity, String> {
}
