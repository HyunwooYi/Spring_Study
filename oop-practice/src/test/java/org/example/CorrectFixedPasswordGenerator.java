package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword(){
        return "abcdefgh";  // 8글자를 생성해주는 CorrectFixedPasswordGenerator를 만들었다.
    }
    /*
    즉 test 코드를 위해서 항상 통과하는 경우를 만들었다
     */

}
