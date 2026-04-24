package question11;

public class Book {
	 private String title; 
	 private int price; 
	 
	 // 以下にフィールドを初期化するコンストラクタを作成 
	 public Book (String title,int price){
		 this.title = title;
		 this.price = price;
		 System.out.println();
		 
	 }
	 
	 
	 
	 // 詳細を表示 
	 public void show() { 
	 System.out.println("本のタイトルは「" + title + "」です"); 
	 System.out.println("価格は" + price + "円です"); 
	 } 

}
