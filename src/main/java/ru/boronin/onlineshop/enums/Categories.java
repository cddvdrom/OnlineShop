package ru.boronin.onlineshop.enums;

public enum Categories {
        BOX("Бокс"),
        FOOTBALL("Футбол"),
        HOCKEY("Хоккей"),
        BASKETBALL("Баскетбол"),
        TENNIS("Теннис");

        private String title;

        Categories(String string){
            this.title=string;
        }
        @Override
        public String toString() {
                return title;
        }
}
