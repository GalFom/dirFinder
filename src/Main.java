import java.util.List;

public class Main {
    public static void main(String[] args) {
        DirScanner dirScanner = new DirScanner("C:\\Users\\Галина", "mp4");
        List<FileSize> fileList = dirScanner.fileList();
        for (FileSize file : fileList) {
            System.out.println(file.getSize() + " - " + file.getName());
        }
    }

}
