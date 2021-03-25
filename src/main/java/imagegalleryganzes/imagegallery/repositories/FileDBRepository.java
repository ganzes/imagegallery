package imagegalleryganzes.imagegallery.repositories;

import imagegalleryganzes.imagegallery.entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}