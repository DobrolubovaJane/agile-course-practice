package ru.unn.agile.PositionalNotation.viewmodel;

public enum Notation {
    BINARY("Двоичная система"),
    DECIMAL("Десятичная"),
    OCTAL("Восьмеричная"),
    HEXADECIMAL("Шестнадцатиричная");

    private final String name;
    Notation(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
