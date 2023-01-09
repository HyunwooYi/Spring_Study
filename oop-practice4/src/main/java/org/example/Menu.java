package org.example;

import java.util.List;

public class Menu {     // 메뉴판

    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {     // 메뉴판은 여러개의 메뉴들을 가진다.
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name)) // menuItem에서 해당 이름과 match되는 아이템 이름을 가지고 오고
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));  // 만약 일치하는게 없다면
    }
}
