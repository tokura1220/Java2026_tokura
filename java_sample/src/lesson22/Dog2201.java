package lesson22;

/**
 * 犬クラス
 */
public class Dog2201 implements BarkingAnimal2201, FourLeggedAnimal2201 {
	/**
     * 鳴き声を表示
     */
	@Override
    public void bark() {
        System.out.println("ワンワン");
    }

	/**
     * 歩く
     */
    @Override
    public void walk() {
        System.out.println("犬は歩きました");
    }
}
