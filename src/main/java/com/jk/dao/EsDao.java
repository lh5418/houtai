package com.jk.dao;

import com.jk.pojo.ShopBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: houtai
 * @description:
 * @author: 刘海
 * @create: 2021-01-13 20:09
 */
public interface EsDao extends ElasticsearchRepository<ShopBean,Integer> {
}
