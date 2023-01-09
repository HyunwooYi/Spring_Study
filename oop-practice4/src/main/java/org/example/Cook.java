package org.example;

import java.util.Objects;

// 요리
public class Cook {     //MenuItem을 보고 Cook(요리)를 요청할 것이기에 Cook과 MenuItem은 동일할 것이다.
    private final String name;
    private final int price;

    public Cook(String name, int price) {       //name과 price를 받는 생성자
        this.name = name;
        this.price = price;
    }

    public Cook(MenuItem menuItem) {        //menuItem을 받는 생성자 추가
        this.name = menuItem.getName();     // 즉, 요리를 만들 때 menuItem을 받으면 menuItem에 대한 이름이 당연히 요리의 이름이 된다.
        this.price = menuItem.getPrice();       // ex) 메뉴아이템의 돈까스는 요리 이름도 당연히 돈까스 & 가격도 당연히 같다.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
