package com.repo;

import com.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBookRepo extends CrudRepository<Book,Long> {
    @Query(value = "from Book where bookName like :bookName")
    Optional<Book> findByBookName(@Param("bookName") String bookName);
}
