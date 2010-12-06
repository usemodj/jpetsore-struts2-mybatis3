package com.usemodj.blog.mappers;


import java.util.List;

import com.usemodj.blog.domain.Author;

public interface AuthorMapper {

  List<Author> selectAllAuthors();

  Author selectAuthor(int id);

  void insertAuthor(Author author);

  int deleteAuthor(int id);

  int updateAuthor(Author author);

}



