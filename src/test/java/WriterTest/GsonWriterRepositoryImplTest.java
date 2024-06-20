/*
package WriterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.Writer;
import org.repository.Impl.GsonWriterRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

public class GsonWriterRepositoryImplTest {

    private GsonWriterRepositoryImpl repository;

    @BeforeEach
    public void setUp() {
        repository = new GsonWriterRepositoryImpl();
    }

    @Test
    public void testSaveAndGetById() {
        Writer writer = new Writer("John", "Doe");
        repository.save(writer);
        Writer retrievedWriter = repository.getById("1");
        assertNotNull(retrievedWriter);
        assertEquals("1", retrievedWriter.getUniqueID());
        assertEquals("John", retrievedWriter.getFirstName());
        assertEquals("Doe", retrievedWriter.getLastName());
    }

    @Test
    public void testUpdate() {
        Writer writer = new Writer( "John", "Doe");
        repository.save(writer);
        Writer updatedWriter = new Writer("Jane", "Doe");
        repository.update(updatedWriter);
        Writer retrievedWriter = repository.getById("1");
        assertEquals("Jane", retrievedWriter.getFirstName());
    }

    // Add more test cases for other methods...

}


 */