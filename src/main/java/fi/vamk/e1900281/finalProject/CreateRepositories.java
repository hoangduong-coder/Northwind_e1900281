package fi.vamk.e1900281.finalProject.CreatingFileFolder;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class CreateRepositories {
    public static void main(String[] args){
        createFile();
    }
    static File newInterface = null;
    static File newController = null;
    public static void createFile(){
        File directory = new File("finalProject/src/main/java/fi/vamk/e1900281/finalProject");
        directory.mkdir();
        String[] fileList = directory.list();
        List<String> fileName = new ArrayList<>();
        for(String s: fileList){
            if(s.contains(".java")){
                String[] newFileName = s.split(".java");
                fileName.add(newFileName[0]);
            }
        }
        for(String s: fileName){
            newInterface = new File(directory, s + "Repository.java");
            newController = new File(directory, s + "Controller.java");
            createRepositoryInterface(s);
            createController(s);
        }
    }
    private static void createController(String name) {
        try(PrintWriter outputFile = new PrintWriter(new FileOutputStream(newController), true)){
            outputFile.write("package fi.vamk.e1900281.finalProject;\r" 
                + "import java.util.*;\r"
                + "import org.springframework.beans.factory.annotation.Autowired;\r"
                + "import org.springframework.web.bind.annotation.PathVariable;\r"
                + "import org.springframework.web.bind.annotation.GetMapping;\r" 
                + "import org.springframework.web.bind.annotation.PostMapping;\r"
                + "import org.springframework.web.bind.annotation.DeleteMapping;\r"
                + "import org.springframework.web.bind.annotation.PutMapping;\r"
                + "import org.springframework.web.bind.annotation.RequestBody;\r"
                + "import org.springframework.web.bind.annotation.RestController;\r"
                + "\n@RestController\r"
                + "public class " + name + "Controller {\r"
                + "\t@Autowired\r"
                + "\tprivate " + name + "Repository repository;\r"
                + "\t@GetMapping(\"/" + name.toLowerCase() + "/\")\r"
                + "\tpublic Iterable<" + name + "> get" + name + "() {\r"
                + "\t\treturn repository.findAll();\r\t}\r"
                + "\t@GetMapping(value =\"/" + name.toLowerCase() + "/{id}\")\r"
                + "\tpublic Optional<" + name + "> getById(@PathVariable(\"id\") int id) {\r"
                + "\t\treturn repository.findById(id);\r\t}\r"
                + "\t@PostMapping(\"/" + name.toLowerCase() + "\")\r\t"
                + "public " + name + " create(@RequestBody " + name + " one" + name + ") {\r"
                + "\t\treturn repository.save(one" + name + ");\r\t}\r"
                + "\t@PutMapping(\"/" + name.toLowerCase() + "\")\r"
                + "\tpublic " + name + " update(@RequestBody " + name + " new" + name + ") {\r"
                + "\t\treturn repository.save(new" + name + ");\r\t}\r"
                + "\t@DeleteMapping(\"/" + name.toLowerCase() + "\")\r"
                + "\tpublic void delete(@RequestBody " + name + " delete" + name 
                + ") {\r\t\trepository.delete(delete" + name + ");\r\t}\r}"
                );
            System.out.println("Finish creating file " + name + "Controller.java!");
        }
        catch(Exception ex){
            System.out.println("File " + name + "Repository.java has not been sucessfully created!");
            ex.printStackTrace();
        }
    }
    public static void createRepositoryInterface(String name) {
        try(PrintWriter outputFile = new PrintWriter(new FileOutputStream(newInterface), true)){
            outputFile.write("package fi.vamk.e1900281.finalProject;\r" 
                + "import org.springframework.data.repository.CrudRepository;\r"
                + "public interface " + name + "Repository extends CrudRepository<" + name + ", Integer> {\r}");
            System.out.println("Finish creating file " + name + "Repository.java!");
        }
        catch(Exception ex){
            System.out.println("File " + name + "Controller.java has not been sucessfully created!");
            ex.printStackTrace();
        }
    }
}
