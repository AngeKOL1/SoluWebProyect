package com.example.MR.Barda.Repo;

import com.example.MR.Barda.Models.User;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface IUserRepo extends IGenericRepo<User, Integer> {
    User findOneByEmail(String email);
}
