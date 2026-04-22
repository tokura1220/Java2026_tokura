package lesson25;

/**
 * 独自例外クラス
 */
public class MyException extends Exception{
    /**
     * エラーメッセージを受け取るコンストラクタ
     * @param msg メッセージ
     */
    public MyException(String msg){
        super(msg);
    }
}
