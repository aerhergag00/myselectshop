package org.example.rmrdo.myselectshop.repository;

import org.example.rmrdo.myselectshop.entity.Folder;
import org.example.rmrdo.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

    List<Folder> findAllByUser(User user);
}
