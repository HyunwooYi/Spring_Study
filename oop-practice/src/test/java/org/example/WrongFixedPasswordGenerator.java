package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatePassword(){
        return "ab";  // 2글자를 생성해주는 WrongFixedPasswordGenerator를 만들었다.
    }
 /*
    즉 test 코드를 위해서 항상 통과하지 않는 경우를 만들었다
     */
}
