package org.repository.Impl;

import org.model.Post;
import org.repository.PostRepository;

import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {

    private List<Post> posts;

    @Override
    public Post getById(Integer id) {
        return null;
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public boolean deleteById(Integer integer) {

        return false;
    }

    @Override
    public boolean existsById(Integer id) {
        return posts.stream().anyMatch(post -> post.getId().equals(id));
    }

}
