package com.crud.library.service;

import com.crud.library.controller.CopyNotFoundException;
import com.crud.library.controller.ReaderNotFoundException;
import com.crud.library.controller.TitleNotFoundException;
import com.crud.library.domain.Copies;
import com.crud.library.domain.Readers;
import com.crud.library.domain.Titles;
import com.crud.library.repository.CopiesDao;
import com.crud.library.repository.ReadersDao;
import com.crud.library.repository.TitlesDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DbService {
    private final ReadersDao readersDao;
    private final TitlesDao titlesDao;

    private final CopiesDao copiesDao;
    public Readers getReader(final Long readerId) throws ReaderNotFoundException {
        return readersDao.findById(readerId).orElseThrow(ReaderNotFoundException::new);
    }

    public Readers saveReader(final Readers reader) {
        return readersDao.save(reader);
    }

    public void deleteReader(final Long readerId) {
        readersDao.deleteById(readerId);
    }


    public Titles getTitle(final Long titleId) throws TitleNotFoundException {
        return titlesDao.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

    public Titles saveTitle(final Titles title) {
        return titlesDao.save(title);
    }

    public void deleteTitle(final Long titleId) {
        titlesDao.deleteById(titleId);
    }



    public List<Copies> getCopiesByStatus(String status) throws CopyNotFoundException  {
        return copiesDao.findByStatus(status);
    }
    public Copies getCopy(final Long copyId) throws CopyNotFoundException {
        return copiesDao.findById(copyId).orElseThrow(CopyNotFoundException::new);
    }

    public Copies saveCopy(final Copies copy) {
        return copiesDao.save(copy);
    }

    public void deleteCopy(final Long copyId) {
        copiesDao.deleteById(copyId);
    }


}
