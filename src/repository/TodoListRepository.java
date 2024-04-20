package repository;

import entity.Todolist;

public interface TodoListRepository {
    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);

    Todolist find(Integer number);

    Todolist[] findAll(String todo);

    boolean update(Integer number, Todolist todolist);
}
