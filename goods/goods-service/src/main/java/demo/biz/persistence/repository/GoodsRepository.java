package demo.biz.persistence.repository;

import demo.biz.goods.request.QueryGoodsReq;
import demo.biz.persistence.entity.Goods;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {

    default Specification<Goods> getCondition(QueryGoodsReq queries) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(queries.getGoodsCode())) {
                predicates.add(criteriaBuilder.equal(
                        root.get("goodsCode"),
                        queries.getGoodsCode()));
            }

            if (StringUtils.hasLength(queries.getGoodsName())) {
                predicates.add(criteriaBuilder.equal(
                        root.get("goodsCode"),
                        queries.getGoodsCode()));
            }

            if (!CollectionUtils.isEmpty(queries.getGoodsTypes())) {
                predicates.add(root.get("goodsType").in(queries.getGoodsTypes()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        };
    }

    default List<Goods> findByCondition(QueryGoodsReq queries) {
        return this.findAll(this.getCondition(queries));
    }

    default Page<Goods> findByConditionPage(QueryGoodsReq queries, Pageable pageable) {
        return this.findAll(this.getCondition(queries), pageable);
    }

}
