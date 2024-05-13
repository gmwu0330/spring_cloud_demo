package demo.model.goods.service.impl;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.GoodsResp;
import demo.common.request.PageReq;
import demo.common.response.PageResp;
import demo.model.goods.converter.GoodsConverter;
import demo.model.goods.service.GoodsService;
import demo.repository.entity.Goods;
import demo.common.helper.PageHelper;
import demo.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsConverter goodsConverter;

    @Override
    public List<GoodsResp> queryAll(QueryGoodsReq req) {
        return goodsRepository.findByCondition(req).stream().map(goodsConverter::toResp).toList();
    }

    @Override
    public PageResp<GoodsResp> queryPage(PageReq<QueryGoodsReq> pageReq) {
        Page<Goods> pageResult = goodsRepository.findByConditionPage(pageReq.getQueries(),
                PageRequest.of(pageReq.getPage(), pageReq.getSize(), PageHelper.DEFALT_SORT));

        List<GoodsResp> respList = pageResult.getContent().stream().map(goodsConverter::toResp).toList();
        return new PageResp<>(pageReq.getPage(), pageReq.getSize(), pageResult.getTotalPages(), pageResult.getTotalElements(), pageResult.hasNext(), respList);
    }

}
