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
        return writers.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst()
                .orElse(null);
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
            System.out.println("ID cannot be null");
            return false;
        }
        if (existsById(id)) {
            boolean removed = writers.removeIf(writer -> writer.getId().equals(id));
            if (removed) {
                try {
                    saveWriters();
                    System.out.println("Writer with id " + id + " was successfully removed and writers were saved.");
                } catch (Exception e) {
                    System.err.println("Failed to save writers after removing writer with ID " + id + ". Error: " + e.getMessage());
                }
            }
            return removed;
        } else {
            System.out.println("No writer found with ID " + id + ".");
            return false;
        }
    }


    @Override
    public boolean existsById(Integer id) {
        return writers.stream().anyMatch(writer -> writer.getId().equals(id));
    }

    private List<Writer> loadWriters() {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Writer>>() {
            }.getType();
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

    public void saveWriters() {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            gson.toJson(writers, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteAllWriters() {
        if (!writers.isEmpty()) {
            writers.clear();
            saveWriters();
            return true;
        } else {
            return false;
        }
    }

}
