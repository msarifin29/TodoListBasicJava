import java.util.Scanner;

public class Main {

    public  static  String[] todos = new String[10];
    public  static java.util.Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        viewTodoList();
    }

    // Step 9
    public static void viewTodoList(){
        while (true){
            showTodoList();
            System.out.println("-----");
            System.out.println("Todo List App");
            System.out.println("1. Add Todo");
            System.out.println("2. Remove Todo");
            System.out.println("3. Exit");
            System.out.println("------");
            var input = input("Select number");
            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("3")){
                System.out.println("Finish");
                break;
            }else{
                System.out.println("Input not valid");
            }
        }
    }


    // Step 10
    public static void viewAddTodoList(){
        System.out.println("Added Todo (x to Cancel)");
        var input = input("Todo");
        if(input.equals("x")){
            // return
        }else{
            addTodoList(input);
        }
    }

    // Step 11
    public static void viewRemoveTodoList(){
        System.out.println("Remove Todo (x to Cancel)");
        var input = input("Number");
        if(input.equals("x")){
            // return
        }else{
            removeTodoList(Integer.valueOf(input));
        }
    }

   // Step 1
    public static void showTodoList(){
        for (int i = 0; i < todos.length; i++) {
            if(todos[i] != null){
              var todo =  todos[i] ;
             var number = i + 1;
                System.out.println(number  + ". "+ todo);
            }
        }
    }

    // Step 2
    public static void testShowTodoList(){
        todos[0] = "one";
        todos[1] = "two";
        todos[2] = "three";
        showTodoList();
    }

    // Step 3
    public static void addTodoList(String todo){
        boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if(todos[i] == null){
                isFull = false;
                break;
            }
        }

        if(isFull){
            String[] temp = todos;
            todos = new String[todos.length * 2];
            for (int i = 0; i < temp.length; i++) {
                todos[i] = temp[i];
            }
        }
        for (int i = 0; i < todos.length; i++) {
            if(todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }

    // Step 4
    public static void testAddTodoList(){
        for (int i = 0; i < 20; i++) {
            addTodoList("index todo of " + (i + 1));
        }
        showTodoList();
    }

    // Step 5
    public static boolean removeTodoList(Integer number){
            if((number -1 ) >= todos.length){
                return false;
            }else if(todos[number -1] == null){
                return false;
            }else{
                for (int i = (number -1); i < todos.length; i++) {
                    if(i == (todos.length - 1)){
                        todos[i] = null;
                    }else{
                        todos[i] = todos[i + 1];
                    }
                }
                return true;
            }
    }

    // Step 6
    public static void testRemoveTodoList(){
        todos[0] = "one";
        todos[1] = "two";
        todos[2] = "three";
        todos[3] = "four";
        showTodoList();
        removeTodoList(2);
        showTodoList();

    }

    // Step 7
    public static String input(String input){
        System.out.print(input + " :");
        return scanner.nextLine();
    }

    // Step 8
    public static void testInput(){
        var input = input("todo");
        System.out.println("you are input " + input);
    }
}