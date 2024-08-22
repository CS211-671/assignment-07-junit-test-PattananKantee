package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;
    Student s2;

    @BeforeEach
    void init(){
        s1 = new Student("6xxxxx", "Aim");
        s2 = new Student("6xxxxx", "Aim", 20);
    }

    @Test
    void testAddScore(){
        //Student s1 = new Student("6610405972", "aim"); มี default แล้ว
        s1.addScore(40);
        assertEquals(40, s1.getScore()); //check if equal, expect = real?
        s1.addScore(30); //บวกเพิ่ม
        assertEquals(70, s1.getScore());
    }

    @Test
    void testCalculateGrade(){
        //Student s1 = new Student("66xxxxxx", "aim", 50); //has default
        s1.addScore(10);
        assertEquals("C", s1.grade());
    }
}