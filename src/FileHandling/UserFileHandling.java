package FileHandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserFileHandling {
	Path path;

//To get the file Directory
	public void createDirectory() {
		this.path = Paths.get("./Files/UserFiles");
		try {
			Files.createDirectories(path);
			System.out.println("Directory created successfully");
		} catch (IOException e) {
			System.out.println("Failed to create the directory" + e.getMessage());
			e.printStackTrace();
		}
	}

	public Path getDirectoryPath() {
		return this.path;
	}

	// Add a user specified file to the application
	public void createuserFile() {
		System.out.println("Enter the File Name you want to create");
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		Path newfilepath = Paths.get(this.path + "/" + filename);
		try {
			Files.createFile(newfilepath);
			System.out.println("File Created Successfully");
		} catch (FileAlreadyExistsException e) {
			System.out.println("The file you want to create already exist");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To list all the files added to the directory
	public void listofFiles() {
		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();

		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				System.out.println(file.getName());
			} else if (file.isFile()) {
				System.out.println(file.getName());
			}
		}
	}

	// To search a user specified file from the application
	public void searchFile() {
		System.out.println("Enter the File Name you want to search");
		Scanner sc = new Scanner(System.in);
		String FiletoSearch = sc.nextLine();
		Path path = Paths.get(this.path + "/" + FiletoSearch);

		if (Files.exists(path)) {
			if (Files.isRegularFile(path)) {
				System.out.println("File Exists");
			}
			if (Files.isDirectory(path)) {
				System.out.println("File Exists but it is a Directory");
			}
		} else {
			System.out.println("File doesnot Exists");
		}
	}

	// To delete User specified File from the application
	public void deleteuserFile() {
		System.out.println("Enter the File Name you want to delete");
		Scanner sc = new Scanner(System.in);
		String FileToDelete = sc.nextLine();
		try {
			Files.delete(Paths.get(this.path + "/" + FileToDelete));
			System.out.println("File Deleted Successfully");
		} catch (NoSuchFileException e) {
			System.out.println("File doesnot exists!!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To List all the Files in Ascending Order
	public void listFilesinAscendingOrder() {
		String dir = this.path.toString();
		File[] listOfFiles = new File(dir).listFiles();
		List<File> listofFile = Arrays.asList(listOfFiles);
		Collections.sort(listofFile);
		Iterator<File> it = listofFile.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}

	}
}
