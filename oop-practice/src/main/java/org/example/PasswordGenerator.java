package org.example;

/*
  RandomPasswordGenerator를 제어하기 위해 interface를 만들었다.
  그렇기에 RandomPasswordGenerator가 이 interface를 구현하도록 한다.
 */
public interface PasswordGenerator {

    String generatePassword();
}
