
import org.controller.WriterController;
import org.repository.Impl.GsonWriterRepositoryImpl;
import org.view.WriterView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args){
        logger.info("The application has been launched");

        WriterController writerController = new WriterController(new GsonWriterRepositoryImpl());
        WriterView writerView = new WriterView(writerController);
        writerView.showMenu();

        logger.info("The application has shut down");
    }
}
