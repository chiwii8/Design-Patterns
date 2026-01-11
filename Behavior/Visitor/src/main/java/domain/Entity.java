package domain;


import domain.visitor.Visitor;

public interface Entity {
    void accept(Visitor visitor);
}
