package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.dto.PostDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.repository.PostRepo;
import com.example.BloggingApplication.repository.UserRepo;
import com.example.BloggingApplication.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Post createPost(Post post, MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // handle validations
        try{
            if(fileName.contains("..")){
                throw new Exception("Filename contains invalid path sequence: "+ fileName);
            }
            post = Post.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .user(post.getUser())
                    .category(post.getCategory())
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();
            return postRepo.save(post);
        } catch (Exception e) {
            throw new Exception("Could not save File: "+ fileName);
        }
    }

    @Override
    public PostDto getPost(int postId) throws ResourceNotFoundException{
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found for this id ::"+postId));
        PostDto postdto = new PostDto();
        BeanUtils.copyProperties(post, postdto);
        return postdto;
    }

    @Override
    public Post updatePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public String deletePost(int postId) throws ResourceNotFoundException {
        Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post not found for this id ::"+postId));
        postRepo.delete(post);
        return "Post has been deleted";
    }

    @Override
    public List<Post> findPostsByUserId(int userId) {
        return postRepo.findPostsByUser_userId(userId);
    }

    @Override
    public List<Post> finPostsByCategoryId(int categoryId) {
        return postRepo.findPostsByCategory_categoryId(categoryId);
    }

//    @Override
//    public Post saveImage(MultipartFilcd e file) throws Exception {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        // handle validations
//        try{
//            if(fileName.contains("..")){
//                throw new Exception("Filename contains invalid path sequence: "+ fileName);
//            }
//            Post post = Post.builder()
//                    .fileName(fileName)
//                    .fileType(file.getContentType())
//                    .data(file.getBytes())
//                    .build();
//            return postRepo.save(post);
//        } catch (Exception e) {
//            throw new Exception("Could not save File: "+ fileName);
//        }
//    }

}
