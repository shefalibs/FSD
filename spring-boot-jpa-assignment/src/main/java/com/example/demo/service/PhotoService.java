package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Photo;

public interface PhotoService {
	public List<Photo> getAllPhotos();
	public void createPhoto(Photo photo);
	public Optional<Photo> getPhotoById(int theId);

}
