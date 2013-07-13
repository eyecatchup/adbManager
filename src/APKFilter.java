import java.io.File;

class APKFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".apk");
    }
    
    public String getDescription() {
        return "APK files";
    }
}