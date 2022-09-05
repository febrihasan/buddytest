package org.ait.project.buddytest.modules.post.service.delegate;

import java.util.List;

import org.ait.project.buddytest.modules.post.model.entity.JsonPlaceHolderPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JsonPlaceHolderPostDelegate {
  List<JsonPlaceHolderPost> getAllPost();

  Page<JsonPlaceHolderPost> getAllPostPage(Pageable pageable);

  JsonPlaceHolderPost getPostById(Integer id);

  List<JsonPlaceHolderPost> saveAll(List<JsonPlaceHolderPost> jsonPlaceHolderPostList);

  JsonPlaceHolderPost save(JsonPlaceHolderPost jsonPlaceHolderPost);
}
