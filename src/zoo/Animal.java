package zoo;

public class Animal {
    public String name;
    private int id;
    public Animal(){
        this.name="小黑";
        id=1000;
    }
    public  Animal(String name,int id){
        this.name=name;
        this.id=id;
    }
    public void eat(){
        System.out.println(name+" is eating");
    }
    public void eat(String sth){
        System.out.println(name+" is eating "+sth);
    }
    public void sleep(){
        System.out.println(name+" is sleeping");
    }

    public void setId(int id) {
        this.id = id;
    }
}
