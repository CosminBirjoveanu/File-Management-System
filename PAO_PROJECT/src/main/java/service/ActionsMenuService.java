package main.java.service;
import main.java.repositories.FilesRepository;
import main.java.repositories.FoldersRepository;
import java.util.Scanner;

public class ActionsMenuService {
    private CopyToService copyToService;
    private CreateFileService createFileService;
    private CreateFolderService createFolderService;
    private DeleteService deleteService;
    private ListAllService listAllService;
    private MoveToService moveToService;
    private PrintContentService printContentService;
    private PrintFileTypeService printFileTypeService;
    private PrintSizeService printSizeService;
    private RenameService renameService;
    private RunService runService;

    private FilesRepository filesRepository = FilesRepository.getInstance();
    private FoldersRepository foldersRepository = FoldersRepository.getInstance();

    public void run(){
        int actiune = 1;
        Scanner input = new Scanner(System.in);
        LogService logService = LogService.getInstance();
        while (actiune != 0) {
            actiune = input.nextInt();
            switch (actiune){
                case 1: String file = input.next();
                        String folder = input.next();
                        copyToService.copy(filesRepository.findFileByName(file), foldersRepository.findFoldersByFile(filesRepository.findFileByName(folder)).get(0));
                        logService.createLog("copy file");
                        break;
                case 2: file = input.next();
                        folder = input.next();
                        copyToService.copy(foldersRepository.findFoldersByFile(filesRepository.findFileByName(file)).get(0), foldersRepository.findFoldersByFolderName(folder).get(0));
                        logService.createLog("copy folder");
                        break;
                case 3: file = input.next();
                        createFileService.addFile(filesRepository.findFileByName(file));
                        logService.createLog("create file");
                        break;
                case 4: folder = input.next();
                        createFolderService.addFolder(foldersRepository.findFoldersByFolderName(folder).get(0));
                        logService.createLog("create folder");
                        break;
                case 5: file = input.next();
                        deleteService.delete(filesRepository.findFileByName(file));
                        logService.createLog("delete file");
                        break;
                case 6: folder = input.next();
                        deleteService.delete(foldersRepository.findFoldersByFolderName(folder).get(0));
                        logService.createLog("delete folder");
                        break;
                case 7: String in = input.next();
                        listAllService.list(in);
                        logService.createLog("list all");
                        break;
                case 8: String from = input.next();
                        file = input.next();
                        String to = input.next();
                        moveToService.move(foldersRepository.findFoldersByFolderName(from).get(0), filesRepository.findFileByName(file), foldersRepository.findFoldersByFolderName(to).get(0));
                        logService.createLog("move file to folder");
                        break;
                case 9: from = input.next();
                        folder = input.next();
                        to = input.next();
                        moveToService.move(foldersRepository.findFoldersByFolderName(from).get(0), foldersRepository.findFoldersByFolderName(folder).get(0), foldersRepository.findFoldersByFolderName(to).get(0));
                        logService.createLog("move folder to folder");
                        break;
                case 10:folder = input.next();
                        printContentService.print(foldersRepository.findFoldersByFolderName(folder).get(0));
                        logService.createLog("print contents of folder");
                        break;
                case 11:file = input.next();
                        printFileTypeService.print(filesRepository.findFileByName(file));
                        logService.createLog("print files");
                        break;
                case 12:folder = input.next();
                        printSizeService.print(foldersRepository.findFoldersByFolderName(folder).get(0));
                        logService.createLog("print sizeof folder");
                        break;
                case 13:file = input.next();
                        printSizeService.print(filesRepository.findFileByName(file));
                        logService.createLog("print sizeof file");
                        break;
                case 14:folder = input.next();
                        String newName = input.next();
                        renameService.rename(foldersRepository.findFoldersByFolderName(folder).get(0), newName);
                        logService.createLog("rename folder");
                        break;
                case 15:file = input.next();
                        newName = input.next();
                        renameService.rename(filesRepository.findFileByName(file), newName);
                        logService.createLog("rename file");
                        break;
                case 16:file = input.next();
                        runService.run(filesRepository.findFileByName(file));
                        logService.createLog("run file");
                        break;
            }
        }
    }
}
