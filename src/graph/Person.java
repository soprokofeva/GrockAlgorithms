package graph;

public class Person {

    private String name;
    private String activity;

    public Person(String name, String activity) {
        this.name = name;
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
