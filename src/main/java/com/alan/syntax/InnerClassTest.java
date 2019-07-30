package com.alan.syntax;

public class InnerClassTest {
    public static void main(String[] args) {
        //<Integer> list= Arrays.asList(1,2,3,4,5);
//        List<Integer> l=new ArrayList();
//        for(int i=0;i<6;i++) l.add(i);
//        Iterator<Integer> iterator=l.iterator();
        //System.out.println("first");
        Person p = new Person("ming",25);
        //Person.InnerAsset asset= p.asset();
        ShowAsset asset= p.asset();
        asset.showAmount();
        System.out.println(asset.toString());
    }
}

class Person{
//    static {
//        System.out.println("loading Class Person");
//    }
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public InnerAsset asset(){
        return  new InnerAsset(age*2);
    }
    private class InnerAsset implements ShowAsset {
        private int amount;
        public void showAmount(){
            System.out.println(amount);
        }
        public InnerAsset(int amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "InnerAsset{" +
                    "amount=" + amount +
                    '}';
        }
    }

}

interface ShowAsset {
    public void showAmount();
}
