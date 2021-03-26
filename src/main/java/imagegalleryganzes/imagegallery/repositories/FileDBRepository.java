package imagegalleryganzes.imagegallery.repositories;

import imagegalleryganzes.imagegallery.entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FileDBRepository extends JpaRepository<FileDB, String> {

    FileDB getFileDBByName(String name);

    void deleteByName(String name);
}