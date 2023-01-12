package calculate;

public class PositiveNumber {   //매 클래스의 opernad를 다 양수 판별을 위해 if문을 쓰는것은 비효율적이므로 클래스를 따로 만들었다.

    private final int value;

    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }
    private void validate(int value) {              // 이 validate 코드로 인해
        if (isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
/*
    int value가 음수이면 아래 코드의 예외를 발생시킨다.
    양수면 객체가 만들어진다 (19줄)
    PositiveNumber가 만들어졌다는 것은 음수가 아니라는 뜻이고 양수임을 보장할 수 있다.
    그렇기때문에  Calculator 클래스에서 operand1, operand2를 int가 아닌 PositiveNumber로 바꿔줘야한다.
    그러나 실제로 계산할 때는 int 값으로 계산해야하기 때문에

        public int toInt() {
        return value;
    }
    를 통해 value 값을 리턴하게 만든다.
*/