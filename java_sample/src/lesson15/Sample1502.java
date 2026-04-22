package lesson15;

public class Sample1502 {
    public static void main(String[] args) {
    	// 人間クラスのオブジェクトを生成
        Human1502 human = new Human1502();

        // setterを呼び出す
        human.setName("田中太郎");
        human.setGender("男性");

        // getterを呼び出す
        System.out.println(human.getName());
        System.out.println(human.getGender());
    }
}
