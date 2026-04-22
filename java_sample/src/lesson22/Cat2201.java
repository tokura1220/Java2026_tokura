package lesson22;

/**
 * 猫クラス
 */
public class Cat2201 implements BarkingAnimal2201, FourLeggedAnimal2201{
	/**
     * 鳴き声を表示
     */
	@Override
    public  void bark() {
        System.out.println("ニャーニャー");
    }

	/**
     * 歩く
     */
    @Override
    public void walk() {
        System.out.println("猫は歩きました");
    }
}
