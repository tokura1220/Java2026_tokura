package jp.co.sss.shop.repository;

//7章 ソースコード7-4 作成

import java.util.List; //7章 ソースコード7-8 追加

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; //8章 ソースコード8-4 追加
import org.springframework.data.repository.query.Param; //8章 ソースコード8-4 追加

import jp.co.sss.shop.entity.Category; //7章 ソースコード7-8 追加
import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository
		extends JpaRepository<ItemWithCategory, Integer> {

	//7章 ソースコード7-8 追加
	List<ItemWithCategory> findByCategory(Category category);

	//8章 ソースコード8-4 追加
	@Query("SELECT i FROM ItemWithCategory i WHERE i.id = :id")
	List<ItemWithCategory> findByIdQuery(@Param("id") Integer id);

	//8章 ソースコード8-7 追加
	@Query("SELECT i FROM ItemWithCategory i WHERE i.price >= " +
			"(SELECT AVG(i2.price) FROM ItemWithCategory i2)")
	List<ItemWithCategory> findByPriceGreaterThanEqualAVGPriceQuery();

}
