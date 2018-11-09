package com.goat.repository;

import com.goat.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by 64274 on 2018/8/22.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/22---15:37
 */
public interface BookRepository extends ElasticsearchRepository<Article,Integer> {


}
