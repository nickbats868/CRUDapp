package org.repository;

import org.model.Writer;

public interface WriterRepository extends GenericRepository<Writer,Integer> {

    public void saveWriters();

    public boolean deleteAllWriters();






    }
