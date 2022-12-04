package XiEr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalShopWork {
}
class Test{
    public static void main(String[] args) {
        MyAnimalShop shop=new MyAnimalShop();
        double money=1000;
        shop.balance=money;shop.spent = money;
        ChineseGardenDog dog=new ChineseGardenDog("中华田园狗",10,"雄",200,true);
        Cat cat=new Cat("猫猫",5,"雄",100);
        Hamster ham=new Hamster("松鼠",5,"雌",75);
        shop.arr.add(dog);
        shop.arr.add(cat);
        shop.arr.add(ham);
        shop.run();

}}

//创建animal动物类

abstract class Animal{
protected String name;
protected int age;
protected String gender;
protected double value;

    public Animal(String name, int age, String gender, double value) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.value = value;
    }

    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

//中华田园犬类
class ChineseGardenDog extends Animal{
    public boolean isVaccineInjected;

    public ChineseGardenDog(String name, int age, String gender, double value, boolean isVaccineInjected) {
        super(name, age, gender, value);
        this.isVaccineInjected = isVaccineInjected;
    }

    public ChineseGardenDog(boolean isVaccineInjected) {
        this.isVaccineInjected = isVaccineInjected;

    }
}
class Cat extends Animal{

    public Cat(String name, int age, String gender, double value) {
        super(name, age, gender, value);
    }
}

class Hamster extends Animal{

    public Hamster(String name, int age, String gender, double value) {
        super(name, age, gender, value);
    }
}

class New extends Animal{
    public New(String name, int age, String gender, double value) {
        super(name, age, gender, value);
    }
}
//Customer客户类

class Customer{
    private String name;
    private int num;
    private LocalDate date;

    public Customer(String name, int num, LocalDate date) {
        this.name = name;
        this.num = num;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", date=" + date +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

//AnimalShop宠物店接口
interface AnimalShop{
    void buy(ArrayList<Animal>animal,Double balance);
    void serve(ArrayList<Customer>customer,ArrayList<Animal> arr,Double balance);
    void stop(ArrayList<Customer>customers,Double balance,Double profit);
}
//自己的宠物店
class MyAnimalShop implements AnimalShop{
    public double balance;
    public double spent;
    public ArrayList<Animal> arr=new ArrayList<>();
    public ArrayList<Customer> arr1=new ArrayList<>();
    public boolean work;
    public void run(){
        while (true) {
            System.out.println("宠物店应用");
            System.out.println("1.查看信息");
            System.out.println("2.买入动物");
            System.out.println("3.招待客户");
            System.out.println("4.歇业");
            System.out.println("请选择：");
            Scanner sc=new Scanner(System.in);
            int command=sc.nextInt();
            switch (command){
                case 1:show(arr,arr1,balance);break;
                case 2:buy(arr,balance);break;
                case 3:serve(arr1,arr,balance);break;
                case 4:stop(arr1,this.balance,spent);return;
                default: System.out.println("您输入的操作不存在");
            }
        }
    }

    @Override
    public String toString() {
        return "MyAnimalShop{" +
                "arr=" + arr +
                ", arr1=" + arr1 +
                '}';
    }

    public static void show(ArrayList<Animal> arr, ArrayList<Customer> arr1,Double balance){
        System.out.println("您的宠物有：");
        System.out.println(arr.toString());
        System.out.println("您的顾客有：");
        System.out.println(arr1.toString());
        System.out.println("您的余额是："+balance);
    }


    public void buy(ArrayList<Animal>animal,Double balance) {


            while(true){String name= null;
            int age= 0;
            String gender= null;
            Double value= null;
            try {Scanner sc=new Scanner(System.in);
                System.out.println("请输入要买宠物价格");
                Double cut=sc.nextDouble();
                System.out.println("请输入动物信息");
                Scanner sc1=new Scanner(System.in);
                System.out.println("宠物名");
                name = sc1.next();
                System.out.println("宠物年龄");
                age = sc1.nextInt();
                System.out.println("宠物性别");
                gender = sc1.next();
                System.out.println("宠物价格");
                value = sc1.nextDouble();
                Animal animal1=new New(name,age,gender,value) ;
                animal.add(animal1);
                this.balance=balance-cut;
                //检查是否余额不足

                InsufficientBalance(this.balance);
                System.out.println("您当前余额为"+this.balance);
                break;

            } catch (Exception e) {
                System.out.println("请您输入正确数据");
            }
        }
    }
    @Override
    public void serve(ArrayList<Customer>customer,ArrayList<Animal> arr1,Double balance) {
        Scanner sc1= null;
        OUT:
        while (true) {
            sc1 = null;
            try {
                System.out.println("请输入客户信息");
                sc1 = new Scanner(System.in);
                System.out.println("顾客名");
                String name=sc1.next();
                System.out.println("到店次数");
                int num=sc1.nextInt();
                System.out.println("最新访问时间");
                System.out.print("年");
                int year=sc1.nextInt();
                System.out.print("月");
                int mouth=sc1.nextInt();
                System.out.print("日");
                int day=sc1.nextInt();
                LocalDate ld=LocalDate.of(year,mouth,day);
                Customer c=new Customer(name,num,ld);
                customer.add(c);
                //出售动物
                AnimalNotFount(arr1);
                System.out.println("请输入动物名");
                String animalName=sc1.next();
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getName().equalsIgnoreCase(animalName)) {
                        System.out.println("宠物信息如下：");
                        System.out.println(arr.get(i).toString());
                        this.balance = balance + arr.get(i).getValue();
                        System.out.println("您当前的余额是" + this.balance);
                        AnimalNotFount(arr1);
                        arr.remove(i);
                        break OUT;
                    }
                }
                System.out.println("请输入正确的动物信息！");
            } catch (Exception e) {
                System.out.println("请仔细参考营业信息，输入正确的名字，到店次数，最新访问时间，动物信息！");
            }
        }

    }

    @Override
    public void stop(ArrayList<Customer>customers,Double balance,Double spent) {
        System.out.println("当天的利润是："+(balance-spent));
        System.out.println("当天的顾客信息如下："+customers.toString());
        System.out.println("歇业成功！");
    }

    public class RunTimeException extends Exception{
        public RunTimeException() {
        }
        public RunTimeException(String message) {
            super(message);
        }
    }

public class AnimalNotFountException extends RunTimeException{}

    public  class InsufficientBalanceException extends RunTimeException{}

public  void InsufficientBalance(double balance) throws InsufficientBalanceException {
        if (balance<0){
            System.out.println("余额不足，无法购买!");
            throw new InsufficientBalanceException();
        }
}
public void AnimalNotFount(ArrayList<Animal>animals) throws AnimalNotFountException {
        if (animals.isEmpty()){
            System.out.println("您店内没有宠物了！");
            throw new AnimalNotFountException();
        }
}

}


































