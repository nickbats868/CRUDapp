
import org.controller.WriterController;
import org.repository.Impl.GsonWriterRepositoryImpl;
import org.view.WriterView;

public class Main {
    public static void main (String[] args){
        WriterController writerController = new WriterController(new GsonWriterRepositoryImpl());
        WriterView writerView = new WriterView(writerController);
        writerView.showMenu();
    }

}
