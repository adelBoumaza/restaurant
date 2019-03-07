package fr.restauration.skikda;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.restauration.skikda.util.Constant;

public class Driver {

	public static void main(String[] args) throws IOException {
		/*File[] fileList = getFileList(Paths.get(Constant.uploadDirectory).toString());

        for(File file : fileList) {
            System.out.println(file.getName());
            byte[] bFile = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            System.out.println(bFile);
        }*/
		
	}
	
	private static File[] getFileList(String dirPath) {
        File dir = new File(dirPath);   

        File[] fileList = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return true;
			}
        });
        return fileList;
    }
}
