package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
public class UsedGoodsBO {
	
	
	@Autowired	// Spring bean 되어있는것을 new를 한것 처럼 가져온다.  DI(Dependency Injection) 의존성 주입
	private UsedGoodsDAO usedGoodsDao; 
	
	public List<UsedGoods> getUsedGoodsList(){
		
		return	usedGoodsDao.selectUsedGoodsList();
	}
}
