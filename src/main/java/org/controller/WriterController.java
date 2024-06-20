package org.controller;

import org.model.Writer;
import org.repository.WriterRepository;

import java.util.List;

public class WriterController {
    public final WriterRepository writerRepository;

    public WriterController (WriterRepository writerRepository){
        this.writerRepository = writerRepository;
    }

    public Writer getWriterById (Integer id){
        return writerRepository.getById(id);
    }

    public List<Writer> getAllWriters(){
        return writerRepository.getAll();
    }

    public Writer createWriter(Writer writer){
        return writerRepository.save(writer);
    }

    public Writer updateWriter(Writer writer){
        return writerRepository.update(writer);
    }

    public void deleteWriterById(Integer id){
        writerRepository.deleteById(id);
    }

            public boolean isUniqueID(int id){
                List<Writer> writers = writerRepository.getAll();
                return writers.stream().noneMatch(writer -> writer.getId() == id);
            }

}
