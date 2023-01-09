package org.example;

import java.util.Objects;
//  메뉴 항목
public class MenuItem {     //MenuItem을 보고 Cook(요리)를 요청할 것이기에 Cook과 MenuItem은 동일할 것이다.
    private final String name;

    private final int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public boolean matches(String name){
        return this.name.equals(name);  // 전달된 이름과 일치하면 일치하는 메뉴항목을 리턴해준다.
    }

    public String getName() {   //Getter 생성
        return name;
    }

    public int getPrice() {     //Getter 생성
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return price == menuItem.price && Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }


}
