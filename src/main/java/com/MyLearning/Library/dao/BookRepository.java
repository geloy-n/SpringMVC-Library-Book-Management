package com.MyLearning.Library.dao;

import com.MyLearning.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByOrderByTitleAsc();
}
