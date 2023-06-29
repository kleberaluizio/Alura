package com.kleberaluizio.school.infra.students;

import com.kleberaluizio.school.domain.students.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentRepositoryJDBC implements StudentRepository {

    private Connection connection;

    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        try {
            String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,student.getCpf());
            ps.setString(2,student.getName());
            ps.setString(3,student.getEmail());
            ps.execute(); //Execute Insert command in the database

            sql = "INSERT INTO PHONENUMBER VALUES(?,?)";
            ps = connection.prepareStatement(sql);
            for (PhoneNumber phoneNumber : student.getPhoneNumbers()) {
                ps.setString(1, phoneNumber.getDdd());
                ps.setString(2, phoneNumber.getNumber());
                ps.execute(); //Execute Insert command in the database
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCpf(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM STUDENT WHERE CPF = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpfNumber());

            ResultSet rs = ps.executeQuery();
            boolean found = rs.next();
            if(!found){
                throw new StudentNotFounded(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student founded = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                founded.addPhoneNumber(ddd, number);
            }

            return founded;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> enrolledStudents() {
        try{
        String sql = "SELECT id, cpf, nome, email FROM STUDENT";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Student> students = new ArrayList<>();
        while(rs.next()){
            CPF cpf = new CPF(rs.getString("cpf"));
            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student student = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE student_id = ?";
            PreparedStatement psPhoneNumber = connection.prepareStatement(sql);
            psPhoneNumber.setLong(1, id);
            ResultSet rsPhoneNumber = psPhoneNumber.executeQuery();
            while (rsPhoneNumber.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                student.addPhoneNumber(ddd, number);
            }
            students.add(student);
        }

        return students;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
