package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PhotoRepository;
import com.example.demo.entity.Photo;
@Service
public class PhotoServiceImpl implements PhotoService {

	private PhotoRepository photoRepository;
	@Override
	@Transactional
	public List<Photo> getAllPhotos() {
		
		return photoRepository.findAll();
	}

	@Override
	@Transactional
	public void createPhoto(Photo photo) {
		
		photoRepository.save(photo);
		
	}

	@Override
	public Optional<Photo> getPhotoById(int theId) {
		
		Optional<Photo> photo=photoRepository.findById(theId);
		return photo;
	}

}
