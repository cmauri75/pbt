package com.example.pbt.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.SearchAttribute;
import net.sf.ehcache.config.Searchable;
import net.sf.ehcache.search.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EHCacheManager {

    private Ehcache companyCache;

    @PostConstruct
    public void init() {

        Configuration cacheManagerConfig = new Configuration();
        CacheConfiguration cacheConfig = new CacheConfiguration("companyCache", 0)
                .eternal(true);
//                .persistence(new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP));

        Searchable searchable = new Searchable();
        cacheConfig.addSearchable(searchable);
        searchable.addSearchAttribute(new SearchAttribute().name("age"));

        CacheManager cacheManager = new CacheManager(cacheManagerConfig);

        cacheManager.addCache(new Cache(cacheConfig));

        companyCache = cacheManager.getEhcache("companyCache");
    }

    public void saveValue(Integer key, String text) {
        companyCache.put(new Element(key, text));
    }

    public String getText(int key) {
        return (String) companyCache.get(key).getObjectValue();
    }

    public List<Integer> queryText(String text) {
        Query iLikeQuery = companyCache.createQuery().maxResults(100);
        iLikeQuery.addCriteria(Query.VALUE.ilike(text)).includeKeys().end();
        var lr = iLikeQuery.execute().all();
        return lr.stream().map(v -> (Integer) v.getKey()).collect(Collectors.toList());
    }

}
