package demo.biz.repository;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.repository.entity.Goods;
import demo.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query(value = """
    SELECT * FROM t_goods
    WHERE 1=1
    AND IF(:goodsCode !='', goods_code = :goodsCode , 1=1)
    AND IF(:goodsName !='', goods_name = :goodsName , 1=1)
    AND IF(:goodsType !='', goods_type = :goodsType , 1=1)
    """, nativeQuery = true)
    Page<Goods> findByConditions(@Param("goodsCode") String goodsCode,
                                 @Param("goodsName") String goodsName,
                                 @Param("goodsType") String goodsType,
                                 Pageable pageable);

    default Page<Goods> findByConditions(QueryGoodsReq queries, Pageable pageable){
        return findByConditions(
                StringUtils.toString(queries.getGoodsCode()),
                StringUtils.toString(queries.getGoodsName()),
                StringUtils.toString(queries.getGoodsType()),
                pageable);
    }
}
