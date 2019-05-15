import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class DirScanner {
    private String dirName;
    private String fileExtension;

    public DirScanner(String dirName, String fileExtension) {
        this.dirName = dirName;
        this.fileExtension = fileExtension;
    }

    public List<FileSize> fileList() {
        ArrayList<FileSize> fileList = new ArrayList<>();
        scanDir(new File(dirName), fileList);
        Collections.sort(fileList, new Comparator<FileSize>() {
            @Override
            public int compare(FileSize o1, FileSize o2) {
                return o1.getSize() < o2.getSize() ? 1 :
                        (o1.getSize() > o2.getSize() ? -1 : 0);
            }
        });
        return fileList;
    }

    private void scanDir(File dir, ArrayList<FileSize> fileList) {
        try {
            for (File current : dir.listFiles()) {
                if (current.isDirectory()) {
                    scanDir(current, fileList);
                } else {
                    if (current.getName().endsWith("." + fileExtension)) {
                        fileList.add(new FileSize(current.getName(), current.length()));
                    }
                }


            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
