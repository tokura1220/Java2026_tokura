package lesson19;

public class Sample1901 {
    public static void main(String[] args) {
        // 検索される文字列
        String mailAddress = "hanako@example.com";

        // 部分文字列（ユーザ名）を得る
        String userName = mailAddress.substring(0, mailAddress.indexOf("@"));
        
        System.out.println("メールアドレス:" + mailAddress);
        System.out.println("ユーザ名:" + userName);
    }
}
