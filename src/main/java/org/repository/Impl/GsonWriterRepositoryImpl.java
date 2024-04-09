package org.repository.Impl;

import com.google.gson.Gson;
import org.model.Writer;
import org.repository.WriterRepository;

import java.util.ArrayList;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {

    private Gson gson = new Gson();
    private List<Writer> writers = new ArrayList<>();

    @Override
    public Writer getById(Integer writerInt) {
        return null;
    }

    @Override
    public List<Writer> getAll() {
        return null;
    }

    @Override
    public Writer save(Writer writer) {
        return null;
    }

    @Override
    public Writer update(Writer writer) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
