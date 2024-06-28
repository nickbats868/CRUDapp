package org.repository.Impl;

import org.model.Writer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.repository.WriterRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GsonWriterRepositoryImpl implements WriterRepository {

    private final String filePath = "writers.json";
    private final Gson gson = new Gson();
    private List<Writer> writers;

    public GsonWriterRepositoryImpl() {
        writers = loadWriters();
    }

    @Override
    public Writer getById(Integer id) {
        Writer writer = writers.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (writer != null) {
            System.out.println("Found writer: " + writer.getFirstName() + " " + writer.getLastName());
        } else {
            System.out.println("Writer with ID: " + id + " not found.");
        }
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        return new ArrayList<>(writers);
    }

    @Override
    public Writer save(Writer writer) {
        writers.add(writer);
        System.out.println("Saving Writer: " + writer.getFirstName() + " " + writer.getLastName());
        saveWriters();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        if (writer == null || writer.getId() == null) {
            throw new IllegalArgumentException("Writer or its ID cannot be null");
        }
        Integer id = writer.getId();

        for (Writer existingWriter : writers) {
            if (existingWriter.getId().equals(id)) {
                existingWriter.setFirstName(writer.getFirstName());
                existingWriter.setLastName(writer.getLastName());
                saveWriters();
                return existingWriter;
            }
        }
        throw new NoSuchElementException("Writer with ID" + id + "not found. Please enter a valid id. ");
    }

    @Override
    public boolean deleteById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        boolean removed = writers.removeIf(writer -> writer.getId().equals(id));
        if (removed) {
            //TODO:
            saveWriters();
        }
        return removed;
    }

    private List<Writer> loadWriters() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Writer>>(){}.getType();
            List<Writer> writers = gson.fromJson(reader, listType);
            if (writers == null) {
                writers = new ArrayList<>();
            }
            return writers;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveWriters() {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(writers, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
