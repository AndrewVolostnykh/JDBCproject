package model2;

import javax.persistence.*;
import java.io.File;
import java.io.FileInputStream;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private byte[] image;
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    public Item(){}

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addImage(String path)
    {
        File file = new File(path);
        byte[] byteFile = new byte[(int) file.length()];

        try {

            FileInputStream inputStream = new FileInputStream(file);
            inputStream.read(byteFile);
            inputStream.close();
        } catch (Exception e)
        {
            System.err.println("Fuck you");
        }

        this.image = byteFile;
    }
}
