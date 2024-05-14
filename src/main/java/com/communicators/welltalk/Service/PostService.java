package com.communicators.welltalk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communicators.welltalk.Repository.PostRepository;
import com.communicators.welltalk.Entity.PostEntity;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<PostEntity> getAllPosts() {
        return postRepository.findByIsDeletedFalse();
    }

    public PostEntity getPostById(int id) {
        return postRepository.findByPostIdAndIsDeletedFalse(id).get();
    }

    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    @SuppressWarnings("finally")
    public PostEntity updatePost(int id, PostEntity post) {
        PostEntity postToUpdate = new PostEntity();
        try {
            postToUpdate = postRepository.findByPostIdAndIsDeletedFalse(id).get();

            postToUpdate.setPostContent(post.getPostContent());
            postToUpdate.setPostImage(post.getPostImage());
        } catch (Exception e) {
            throw new IllegalArgumentException("Post " + post.getPostId() + " does not exist.");
        } finally {
            return postRepository.save(postToUpdate);
        }
    }

    public boolean deletePost(int id) {
        PostEntity post = postRepository.findByPostIdAndIsDeletedFalse(id).get();
        if (post != null) {
            post.setIsDeleted(true);
            postRepository.save(post);
            return true;
        } else {
            System.out.println("Post " + id + " does not exist.");
            return false;
        }
    }
}
