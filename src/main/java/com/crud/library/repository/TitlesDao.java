package com.crud.library.repository;

import com.crud.library.domain.Titles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TitlesDao extends CrudRepository<Titles, Long> {
    List<Titles> findByPublicationYear(int publicationYear);

    @Override
    Optional<Titles> findById(Long Id);

    Titles save(Titles title);

    void deleteById(Long Id);
}
