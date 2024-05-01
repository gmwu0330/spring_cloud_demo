package demo.biz.model.goods.service.impl;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.model.goods.service.GoodsService;
import demo.biz.model.goods.converter.GoodsConverter;
import demo.biz.repository.entity.Goods;
import demo.biz.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository orderRepository;
    private final GoodsConverter orderConverter;

    @Override
    public QueryGoodsResp query(QueryGoodsReq request) {
        final Long id = request.getId();
        Optional<Goods> orderOptional = orderRepository.findById(id);
        return orderOptional.map(orderConverter::toResp).orElse(null);
    }

}
