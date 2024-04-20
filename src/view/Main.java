package view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import util.inputUtil;

public class Main {

    public static void main(String[] args) {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        Main todoListView = new Main(todoListService);

        todoListView.viewShowTodoList();
    }

    private final TodoListService todoListService;

    public Main(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void viewShowTodoList() {
        var i = 0;
        label:
        while (true) {
            if (i != 0) {
                System.out.println("\n--------------------------");
            }
            i++;
            todoListService.showTodoList();

            System.out.println("\nMENU : ");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("3. Update Todo");
            System.out.println("4. Find Todo");
            System.out.println("x. Exit");

            var input = inputUtil.input("Pilih");

            switch (input) {
                case "1":
                    addTodoList();
                    break;
                case "2":
                    removeTodoList();
                    break;
                case "4":
                    findTodoList();
                    break;
                case "3":
                    updateTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    public void addTodoList() {
        System.out.println("== ADD TODO ==");

        var todo = inputUtil.input("Todo (x if exit)");
        if (todo.equals("x")) {
            return;
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("== REMOVE TODO ==");

        var todo = inputUtil.input("Number of todo (x if exit)");

        int numInt = 0;
        try {
            if (todo.equals("x")) {
                return;
            } else {
                numInt = Integer.parseInt(todo);
                todoListService.removeTodoList(numInt);
            }
        } catch (Exception e) {
            System.out.println("number is not a number");
            removeTodoList();
        }


    }

    public void findTodoList() {
        System.out.println("== FIND TODO ==");


        while (true) {
            var todo = inputUtil.input("Name of todo (x if exit)");
            if (todo.equals("x")) {
                return;
            }
            todoListService.findTodoList(null, todo);
        }
    }

    public void updateTodoList() {
        System.out.println("== UPDATE TODO ==");

        var num = inputUtil.input("Number of todo (x if exit)");
        int numInt = 0;

        try {
            numInt = Integer.parseInt(num);
            if (num.equals("x")) {
                return;
            } else {
                var todo = inputUtil.input("Name of todo (x if exit)");
                if (todo.equals("x")) {
                    return;
                }

                todoListService.updateTodoList(numInt, todo);
            }
        } catch (Exception e) {
            System.out.println("number is not a number");
            updateTodoList();
        }

    }

}
