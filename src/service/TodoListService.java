package service;

public interface TodoListService {

    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);

    void findTodoList(Integer number, String todo);

    void updateTodoList(Integer number, String todo);

}
