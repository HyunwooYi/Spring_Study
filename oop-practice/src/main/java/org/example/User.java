package org.example;

public class User {
    private String password;

    /*
    해당 컨트롤 할 수 없는 부분인 RandomPasswordGenerator을 외부로 부터 주입 받도록 한다.
    PasswordGenerator을 구현했기 때문에 RandomPasswordGenerator로 받는 것이 아니라PasswordGenerator 즉, 상위의 인터페이스로 받도록한다.
    인터페이스를 통해서 generatePassword(),  내 구현체가(PasswordGenerator) 어떤 것인지 모르겠지만 generatePassword가 오면 password로 받고
    아래 if문 조건이면 통과한다.

     */
    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is 방식   -> 내부에서 생성하는 경우 강한 결합이다. 그렇기에 해당부분에 대해서 영향을 많이 받을 수 밖에 없다.
        // 이 강한 결합을 약화 시키기 위해서 상위 인터페이스를 두었다. 그렇기에 더 이상 RandomPasswordGenerator에 대해서
        // 의존하는게 아니라 PasswordGenerator라는 인터페이스를 두면서 결합을 느슨하게 만들었다.
        // 그래서 실제로 RandomPasswordGenerator도 들어올 수 있지만 CorrectFixedGenerator/WrongFixedGenerator도
        // 들어올 수 있게 되었다.
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator(); // 만들어 놓은 RandomPasswordGenerator를 만든다
//        String password = randomPasswordGenerator.generatePassword();

        // to-be 방식은  passwordGenerator를 이용해서 generator하는 방식이다.
        String password = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */

        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
        /*
        위의 조건이 만족 할때만 패스워드가 생성되는지 확인하기 위해 test 코드를 만들어야한다
        ctrl + shift + t 를 누르면 test 코드가 생성된다.
         */

        // to-be 방식

    }

    public String getPassword() {   //alt + insert 단축키를 이요하여 Getter를 생성할 수 있다.
        return password;
    }
}
