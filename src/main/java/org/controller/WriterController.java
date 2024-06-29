package org.controller;

import org.model.Writer;
import org.repository.WriterRepository;

import java.util.List;

public class WriterController {
    public final WriterRepository writerRepository;

    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public Writer getWriterById(Integer id) {
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters() {
        return writerRepository.getAll();
    }

    public void createWriter(Writer writer) {
        writerRepository.save(writer);
    }

    public void updateWriter(Writer writer) {
        writerRepository.update(writer);
    }

    public boolean deleteWriterById(Integer id) {
        if (writerRepository.existsById(id)) {
            writerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean isUniqueID(int id) {
        List<Writer> writers = writerRepository.getAll();
        return writers.stream().noneMatch(writer -> writer.getId() == id);
    }
}
