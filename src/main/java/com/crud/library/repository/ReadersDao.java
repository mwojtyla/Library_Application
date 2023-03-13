package com.crud.library.repository;

import com.crud.library.domain.Readers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ReadersDao extends CrudRepository<Readers, Long> {
   List<Readers> findByName(String name);

   @Override
   Optional<Readers> findById(Long Id);

   Readers save(Readers reader);

   void deleteById(Long Id);
}
