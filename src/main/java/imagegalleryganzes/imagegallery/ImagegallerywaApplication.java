package imagegalleryganzes.imagegallery;

import imagegalleryganzes.imagegallery.repositories.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class ImagegallerywaApplication implements CommandLineRunner {

	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(ImagegallerywaApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();//deletes all saved files, to have it store it, just delete or comment this line
		storageService.init();
	}
}
