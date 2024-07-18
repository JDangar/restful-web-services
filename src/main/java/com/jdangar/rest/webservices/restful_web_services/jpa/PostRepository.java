package com.jdangar.rest.webservices.restful_web_services.jpa;

import com.jdangar.rest.webservices.restful_web_services.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
