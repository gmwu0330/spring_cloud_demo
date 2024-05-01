package demo.biz.model.goods.service.impl;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.goods.response.QueryGoodsResp;
import demo.biz.model.goods.service.GoodsService;
import demo.biz.model.goods.converter.GoodsConverter;
import demo.biz.repository.GoodsRepository;
import demo.biz.repository.entity.Goods;
import demo.common.request.PageReq;
import demo.common.response.PageResp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsConverter goodsConverter;

    @Override
    public List<QueryGoodsResp> queryAll() {
        return goodsRepository.findAll().stream().map(goodsConverter::toResp).toList();
    }

    @Override
    public PageResp<QueryGoodsResp> queryPage(PageReq<QueryGoodsReq> pageReq) {
        QueryGoodsReq queries = pageReq.getQueries();
        int page = pageReq.getPage();
        int size = pageReq.getSize();
        goodsRepository.findAll();
        Page<Goods> pageResult = goodsRepository.findByConditions(queries, PageRequest.of(page, size, Sort.by("id")));

        List<QueryGoodsResp> respList = pageResult.getContent().stream().map(goodsConverter::toResp).toList();
        return new PageResp<>(page + 1, size, pageResult.getTotalPages(), pageResult.getTotalElements(), pageResult.hasNext(), respList);
    }

}
