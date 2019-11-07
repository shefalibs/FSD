package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.PhotoRepository;
import com.example.demo.dao.AlbumRepository;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Album;

@SpringBootApplication
public class SpringBootJpaAssignmentApplication {
	
	private PhotoRepository photoRepository;
	private AlbumRepository albumRepository;

	
	public SpringBootJpaAssignmentApplication(PhotoRepository photoRepository, AlbumRepository albumRepository) {
		super();
		this.photoRepository = photoRepository;
		this.albumRepository = albumRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAssignmentApplication.class, args);
	}
	
	@Component
	class CourseCommand implements CommandLineRunner
	{

		@Override
		public void run(String... args) throws Exception {
			List<Photo> list=new ArrayList<Photo>();
			Album tempAlbum=new Album();
			Photo tempPhoto=new Photo();
			
			
			tempAlbum.setTitle("Whatsapp images");
			tempAlbum.setOwner("Whatsapp");
			tempPhoto.setTitle("Group photo");
			list.add(tempPhoto);
			tempPhoto.setAlbum(tempAlbum);
			tempAlbum.setPhotos(list);
			albumRepository.save(tempAlbum);
			photoRepository.save(tempPhoto);
			
		}
		
	}

}
