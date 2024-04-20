package repository;

import entity.Todolist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoListRepositoryImpl implements TodoListRepository {

    public Todolist[] data = new Todolist[10];

    public boolean isFull() {
        var isFull = true;

        for (Todolist todolist : data) {
            if (todolist == null) {
                return false;
            }
        }
        return isFull;
    }

    public void resize() {
        if (isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];

            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public Todolist[] getAll() {
        return data;
    }

    @Override
    public void add(Todolist todolist) {
        resize();

        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
        }

        return true;
    }

    @Override
    public Todolist find(Integer number) {
        if ((number - 1) > data.length || data[number - 1] == null) {
            return null;
        }

        return data[number - 1];
    }

    public Todolist[] findAll(String todo) {
        var newData = data.clone();
        String regex = ".*" + todo + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (var i = 0; i < newData.length; i++) {
            if ((newData[i] != null) && !pattern.matcher(newData[i].getTodo()).find()) {
                newData[i] = null;
            }
        }
        return newData;
    }

    public boolean update(Integer number, Todolist todolist) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            this.data[number - 1] = todolist;
        }

        return true;
    }
}
