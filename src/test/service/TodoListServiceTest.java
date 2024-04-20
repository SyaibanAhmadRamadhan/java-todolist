package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {

    public static void main(String[] args) {
        testShowTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("learn java");
        todoListService.addTodoList("learn rust");
        todoListService.addTodoList("learn javascript");
        todoListService.showTodoList();

        // deleted todolist
        todoListService.removeTodoList(2);
        todoListService.removeTodoList(34);
        todoListService.showTodoList();
    }

}
