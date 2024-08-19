package com.ulanzhasssanov.CrudAppWithHibernate.controller;

import com.ulanzhasssanov.CrudAppWithHibernate.model.Post;
import com.ulanzhasssanov.CrudAppWithHibernate.repository.hibernate.HibernatePostRepositoryImpl;
import com.ulanzhasssanov.CrudAppWithHibernate.service.PostService;

import java.util.List;

public class PostController {
    private PostService postService = new PostService(new HibernatePostRepositoryImpl());

    public Post savePost(Post post){
        return postService.savePost(post);
    }


    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    public Post getPostById(Integer id){
        return postService.getPostById(id);
    }

    public Post updatePost(Post post){
        return postService.updatePost(post);
    }

    public void deletePost(Integer id){
        postService.deletePostById(id);
    }

}
