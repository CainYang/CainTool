package OneToAnother;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneToAnother {

    // full name of dto class
    private String firstClassName;

    //instance name of dto class
    private String firstInsName;

    //full name of bean class
    private String secondClassName;

    //instance name of bean class
    private String secondInsName;

    public OneToAnother(String firstClassName, String firstInsName, String secondClassName, String secondInsName) {
        this.secondClassName = secondClassName;
        this.secondInsName = secondInsName;
        this.firstClassName = firstClassName;
        this.firstInsName = firstInsName;
    }

    public void printResult() {
        Class dto;
        try {
            dto = Class.forName(firstClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Field[] fields = dto.getDeclaredFields();

        List<String> dtoFields = new ArrayList<>();

        for (Field field : fields) {
            dtoFields.add(field.getName());
        }

        Class bean;
        try {
            bean = Class.forName(secondClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Field[] beanFields = bean.getDeclaredFields();

        for (Field field : beanFields) {
            if (dtoFields.contains(field.getName())) {
                String name = field.getName();
                String upper = name.substring(0,1);
                String last = name.substring(1);
                StringBuilder funcname = new StringBuilder();
                funcname.append(upper.toUpperCase()+last);
                System.out.println(firstInsName+".set"+funcname+"("+secondInsName+".get"+funcname+"());");
            }
        }
    }

    public static void main(String[] args) {
        String firstClass;
        String firstIns;
        String secondClass;
        String secondIns;

        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("|  此工具是为了方便将一个类中的属性通过get和set复制到另一个具有相同属性的类中  |");
        System.out.println("|           此工具会将结果打印出来，复制粘贴到你需要使用的地方即可           |");
        System.out.println("|       你的类必须具有相应的get及set方法，且为驼峰命名方式，如 getAge       |");
        System.out.println("-----------------------------------------------------------------------");

        while (true) {
            System.out.println("请输入将要调用set方法的类的全限定名称：");
            firstClass = scanner.nextLine();
            try {
                Class.forName(firstClass);
            } catch (ClassNotFoundException e) {
                System.out.println("类未找到，请检查名称输入是否有误并重新输入");
                continue;
            }
            break;
        }

        System.out.println("请输入上一个类的实例的名称：");
        firstIns = scanner.nextLine();

        while (true) {
            System.out.println("请输入将要调用get方法的类的全限定名称：");
            secondClass = scanner.nextLine();
            try {
                Class.forName(secondClass);
            } catch (ClassNotFoundException e) {
                System.out.println("类未找到，请检查名称输入是否有误并重新输入");
                continue;
            }
            break;
        }

        System.out.println("请输入上一个类的实例的名称：");
        secondIns = scanner.nextLine();

        OneToAnother beanToDto = new OneToAnother(firstClass, firstIns, secondClass, secondIns);
        System.out.print("\n结果如下\n----------------------------------------------\n\n");
        beanToDto.printResult();
        System.out.print("\n----------------------------------------------");
    }
}
