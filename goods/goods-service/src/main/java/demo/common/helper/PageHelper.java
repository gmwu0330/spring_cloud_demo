package demo.common.helper;

import org.springframework.data.domain.Sort;

public class PageHelper {

    public static Sort DEFALT_SORT = Sort.by(Sort.Direction.DESC, "createTime");

}
