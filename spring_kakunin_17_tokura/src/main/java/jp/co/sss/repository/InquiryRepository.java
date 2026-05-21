package jp.co.sss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry,Integer> {

}
