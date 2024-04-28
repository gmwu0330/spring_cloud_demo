package demo.goods.model.goods.service.impl;

import demo.goods.model.goods.response.QueryGoodsResp;
import demo.goods.model.goods.service.GoodsService;
import demo.goods.model.goods.converter.GoodsConverter;
import demo.goods.model.goods.request.QueryGoodsReq;
import demo.goods.common.entity.Goods;
import demo.goods.repository.GoodsRepository;
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
