package id.daimus.redis.infrastructure.data.jpa.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookRepository extends CrudRepository<BookEntity, Long> {
}
