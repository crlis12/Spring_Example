package com.example.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.model.UsedGoods;

@Repository // 저장소
public interface UsedGoodsDAO {  //interface로 만들어준다 메소드의 구현이 없이 메소드의 정의만
	
	public List<UsedGoods> selectUsedGoodsList(); //DB랑 비슷하기 때문에 이름을 쿼리랑 비슷하게 지어준다.
		
}
