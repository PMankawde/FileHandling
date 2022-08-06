package FileHandling;

import java.util.Scanner;

public class UserFilesMain {
	UserFileHandling Userfiles;

	public static void main(String[] args) {
		UserFilesMain userfilesmain = new UserFilesMain();
		userfilesmain.MainMenu();

	}

	public void MainMenu() {
		System.out.println("Main Menu");
		Userfiles = new UserFileHandling();
		this.Userfiles.createDirectory();

		try {
			int selection = 0;
			Scanner input = new Scanner(System.in);

			do {
				System.out.println("Choose from the below options");
				System.out.println("1.Display the File Names in Ascending Order");
				System.out.println("2.Display User Interface Menu");
				System.out.println("3.Exit");
				selection = input.nextInt();
				switch (selection) {
				case 1:
					System.out.println("Displaying File List in Ascending Order");
					Userfiles.listFilesinAscendingOrder();
					break;
				case 2:
					System.out.println("Displaying User Interface Menu");
					userInterfaceMenu(input);
					break;
				case 3:
					System.out.println("Thank You for using our Application");
					break;
				default:
					System.out.println("Wrong option");
				}
			} while (selection != 3);
			
			input.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userInterfaceMenu(Scanner inOption) {
		try {
			int selection;
			do {
				System.out.println("Choose from the below Options:");
				System.out.println("1.Add a user specified file to the Directory");
				System.out.println("2.Delete a user specified file from the Directory");
				System.out.println("3.Search for a user specified file from the Directory");
				System.out.println("4.Back to Main Menu");

				selection = inOption.nextInt();
				switch (selection) {
				case 1:
					this.Userfiles.createuserFile();
					break;

				case 2:
					this.Userfiles.deleteuserFile();
					break;

				case 3:
					this.Userfiles.searchFile();
					break;

				case 4:
					System.out.println("Returning to main menu.");
					break;
				default:
					System.out.println("Wrong Option Selected");
					break;
				}

			} while (selection != 4);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
