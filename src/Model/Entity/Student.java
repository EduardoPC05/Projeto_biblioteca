package Model.Entity;

import Model.Enum.UserType;

public class Student extends User{

    public Student(String name, String email, String phone) {
        super(name, email, phone, 0);
    }

    @Override
    public int getDeadline() {
        return 5;
    }

    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }
}
