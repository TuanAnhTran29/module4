package com.repo;

import com.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends PagingAndSortingRepository<Comment,Long> {
}
