package com.test03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary // 우선순위로 먼저 호출된다 -> 같은 타입의 빈이 여러개 선언되었을때 기본으로 호출
// 만약 호출하는 컨트롤러에서 Qualifier 가 존재하면 Qualifier 가 우선이다.
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Override
    public List<GoodsVo> getAll() {
        return mapper.listGoods();
    }

    @Override
    public GoodsVo get(String code) {
        return mapper.findGoods(code);
    }

    @Override
    @Transactional
    public void add(GoodsVo vo) {
        mapper.insertGoods(vo);
    }

    @Override
    @Transactional
    public void edit(GoodsVo vo) {
        mapper.updateGoods(vo);
    }

    @Override
    @Transactional
    public void delete(String name) {
        mapper.deleteGoods(name);
    }
}
