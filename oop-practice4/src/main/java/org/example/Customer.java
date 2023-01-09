package org.example;

public class Customer {
    // 주문시 메뉴 이름뿐만 아니라 메뉴이름에 해당하는 메뉴항목을 선택해야하기 때문에 메뉴도 전달, 그리고 메뉴항목(MenuITem)을 만들어주는 요리사도 전달한다.
    public void order(String menuName, Menu menu, Cooking cooking) {
        MenuItem menuItem = menu.choose(menuName);  // 해당하는 메뉴가 있다면 메뉴 아이템을 반환 받는다.
        Cook cook = cooking.makeCook(menuItem); // 그러면 요리사에게 요리를 해달라고 전달한다.
    }
}
