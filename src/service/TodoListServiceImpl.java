package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {


    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("=== TODOLIST ===");

        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist newTodo = new Todolist(todo);
        todoListRepository.add(newTodo);
    }

    @Override
    public void removeTodoList(Integer number) {
        Todolist todolist = todoListRepository.find(number);

        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("SUCCESS DELETED TODOLIST: " + number + ". " + todolist.getTodo());
        } else {
            System.out.println("FAILED TO DELETE TODOLIST: " + number);
        }
    }

    @Override
    public void findTodoList(Integer number, String todo) {
        if (todo != null) {
            var todolist = todoListRepository.findAll(todo);
            for (var i = 0; i < todolist.length; i++) {
                var no = i + 1;

                if (todolist[i] != null) {
                    System.out.println(no + ". " + todolist[i].getTodo());
                }
            }
        }
    }

    @Override
    public void updateTodoList(Integer number, String todo) {
        Todolist todolist = todoListRepository.find(number);

        boolean success = todoListRepository.update(number,new Todolist(todo));

        if (success) {
            System.out.println("SUCCESS UPDATE TODOLIST: " + number + ". " + todolist.getTodo());
        } else {
            System.out.println("FAILED TO UPDATE TODOLIST: " + number);
        }
    }


}
