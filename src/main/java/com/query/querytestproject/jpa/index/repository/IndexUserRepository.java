package com.query.querytestproject.jpa.index.repository;

import com.query.querytestproject.jpa.index.model.IndexCategoryEnum;
import com.query.querytestproject.jpa.index.model.IndexUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndexUserRepository extends JpaRepository<IndexUser,Long> {
    @Query("SELECT u" +
            " FROM IndexUser u " +
            " WHERE u.categoryEnum = :category")
    List<IndexUser> basicFindUserByCategory(IndexCategoryEnum category);


    @Query(value = "SELECT *" +
            " FROM index_user_table" +
            " USE INDEX (category__index__user)" +
            " WHERE index_user_table.category_enum = ?"
            ,nativeQuery = true)
    List<IndexUser> indexFindUserByCategory(String category);
}
