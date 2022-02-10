package com.repo;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findBlogsByTitleLike(String title, Pageable pageable);

    Iterable<Blog> findByCategoryId(Long id);

    @Query(value = "select * from blog.blog limit ?1", nativeQuery = true)
    Iterable<Blog> getBlogLimit(Integer limit);
}
