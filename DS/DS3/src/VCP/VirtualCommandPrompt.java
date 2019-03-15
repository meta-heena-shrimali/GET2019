package VCP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VirtualCommandPrompt {

    private static Directory root;

    /*
     * method to implement the virtual command prompt
     */
    public void virtualCommandPrompt() {
        root = new Directory("R:", new Date(), null);
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Welcome to Virtual Command Prompt***");
        String signature = "R:\\";
        System.out.print(signature + ">");
        Directory currentDirectory = root;

        while (true) {
            String commandLine = scanner.nextLine().toLowerCase();
            String[] commandWords = commandLine.split(" ");

            switch (commandWords[0]) {

            // command to create a directory in the current directory
            case "mkdir":
                if (commandWords.length >= 2) {
                    boolean directoryExist = false;
                    // same directory name exist or not
                    for (Directory directory : currentDirectory.getListOfSubDirectory()) {
                        if (directory.getName().equals(commandWords[1])) {
                            directoryExist = true;
                            break;
                        }
                    }
                    if (!directoryExist) {
                        Directory newDirectory = new Directory(commandWords[1], new Date(), currentDirectory);
                        currentDirectory.getListOfSubDirectory().add(newDirectory);
                    } else
                        System.out
                                .println(signature + ">A subdirectory or file " + commandWords[1] + " already exists.");
                }
                // new directory name not mentioned
                else
                    System.out.println(signature + ">The syntax of the command is incorrect.");
                System.out.print(signature + ">");
                break;

            // command to change the current directory
            case "cd":
                if (commandWords.length >= 2) {
                    boolean directoryExist = false;
                    for (Directory subDirectory : currentDirectory.getListOfSubDirectory()) {
                        if (subDirectory.getName().equals(commandWords[1])) {
                            currentDirectory = subDirectory;
                            directoryExist = true;
                            // if it's root not need to add \ as it already present in it
                            if (signature.charAt(signature.length() - 1) != '\\')
                                signature += "\\";
                            signature += currentDirectory.getName();
                            break;
                        }
                    }
                    if (!directoryExist)
                        System.out.println(signature + "> No such directory exists");
                } else
                    System.out.println(signature + ">The syntax of the command is incorrect.");
                System.out.print(signature + ">");
                break;

            // command to go back to the parent directory
            case "bk":
                if (currentDirectory.getName() != "R:") {
                    currentDirectory = currentDirectory.getParentDirectory();
                    String[] directories = signature.split("\\\\");
                    signature = "R:";
                    for (int i = 1; i < directories.length - 1; i++) {
                        signature += "\\" + directories[i];
                    }
                }
                System.out.print(signature + ">");
                break;

            // command to list all the subfolders in the current directory
            case "ls":
                for (Directory subDirectory : currentDirectory.getListOfSubDirectory()) {
                    System.out.println(subDirectory.getDateOfCreation() + "\t" + subDirectory.getName());
                }
                System.out.println(currentDirectory.getListOfSubDirectory().size() + " Folder(s)");
                System.out.print(signature + ">");
                break;

            // command to find the path of tran existing directory
            case "find":
                if (commandWords.length >= 2) {
                    List<String> paths = new ArrayList<String>();
                    paths = find(currentDirectory, commandWords[1], ".");
                    if (paths.size() != 0)
                        for (String path : paths)
                            System.out.println(path + "\\" + commandWords[1]);
                    else
                        System.out.println(signature + ">Directory not found");

                } else
                    System.out.println(signature + ">The syntax of the command is incorrect.");
                System.out.print(signature + ">");
                break;

            // command to display the tree structure for the current directory
            case "tree":
                System.out.println(".");
                printTree(currentDirectory, 0);
                System.out.print(signature + ">");
                break;

            // command to exit the virtual command prompt
            case "exit":
                scanner.close();
                System.exit(0);
                // case when the command is wrong
            default:
                System.out.println(signature + ">Command does not exist");
                System.out.print(signature + ">");

            }
        }
    }

    /*
     * method to display the tree of the given directory
     * 
     * @param currentDirectory
     * @param nesting          is the level of the subfolder
     */

    private void printTree(Directory currentDirectory, int nesting) {
        for (Directory subDirectory : currentDirectory.getListOfSubDirectory()) {
            for (int i = 0; i < nesting; i++)
                System.out.print("|    ");
            if (subDirectory.getListOfSubDirectory().size() != 0) {
                System.out.println("|---" + subDirectory.getName());
                printTree(subDirectory, nesting + 1);
            } else
                System.out.println("|___" + subDirectory.getName());
        }
    }

    /*
     * method to find the path of the given directory
     * 
     * @param currentDirectory
     * @param directoryToBeSearched
     * @param relativePath
     * @return list of path of the folder having name
     */
    private List<String> find(Directory currentDirectory, String directoryToBeSearched, String relativePath) {
        List<String> paths = new ArrayList<String>();
        for (Directory subDirectory : currentDirectory.getListOfSubDirectory()) {
            if (directoryToBeSearched.equalsIgnoreCase(subDirectory.getName()))
                paths.add("\\" + relativePath);
            if (subDirectory.getListOfSubDirectory().size() != 0) {
                relativePath += "\\" + subDirectory.getName();
                paths.addAll(find(subDirectory, directoryToBeSearched, relativePath));
            }
        }
        return paths;
    }
}