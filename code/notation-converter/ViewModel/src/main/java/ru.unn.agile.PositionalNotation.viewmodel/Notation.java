package ru.unn.agile.PositionalNotation.viewmodel;

public enum Notation {
    BINARY("binary"),
    DECIMAL("decimal"),
    OCTAL("octal"),
    HEX("hex");

    private final String name;
    Notation(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
