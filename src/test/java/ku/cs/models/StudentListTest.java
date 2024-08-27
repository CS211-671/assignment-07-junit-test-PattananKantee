package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void addNewStudent() {
        studentList.addNewStudent("6610405111", "one");
        studentList.addNewStudent("6610405112", "two");
        studentList.addNewStudent("6610405113", "three");

        assertNotNull(studentList.findStudentById("6610405111"));
        assertNotNull(studentList.findStudentById("6610405112"));
        assertNotNull(studentList.findStudentById("6610405113"));
    }

    @Test
    void testAddNewStudentWithDuplicateId() {
        studentList.addNewStudent("6610405111", "one");
        studentList.addNewStudent("6610405111", "anotherOne");

        assertEquals(1, studentList.getStudents().size());
        assertEquals("one", studentList.findStudentById("6610405111").getName());
    }

    @Test
    void findStudentById() {
        studentList.addNewStudent("6610405111", "one");
        studentList.addNewStudent("6610405112", "two");

        Student student = studentList.findStudentById("6610405111");
        assertNotNull(student);
        assertEquals("one", student.getName());

        student = studentList.findStudentById("nonexistentId");
        assertNull(student);
    }

    @Test
    void giveScoreToId() {
        studentList.addNewStudent("6610405111", "one");
        studentList.giveScoreToId("6610405111", 85.0);

        Student student = studentList.findStudentById("6610405111");
        assertNotNull(student);
        assertEquals(85.0, student.getScore());
    }

    @Test
    void viewGradeOfId() {
        studentList.addNewStudent("6610405111", "one", 95.0);
        studentList.addNewStudent("6610405112", "two", 75.0);

        String gradeOne = studentList.viewGradeOfId("6610405111");
        String gradeTwo = studentList.viewGradeOfId("6610405112");

        assertEquals("A", gradeOne);
        assertEquals("B", gradeTwo);

        assertNull(studentList.viewGradeOfId("nonexistentId"));
    }
}
