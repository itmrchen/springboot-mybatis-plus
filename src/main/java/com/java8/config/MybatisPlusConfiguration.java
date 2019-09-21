package com.java8.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.java8.dao.UserMapper;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;

/**
 * @author itmrchen
 * @date 2019/9/20 0:39
 */
@Configuration
public class MybatisPlusConfiguration {

    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 性能分析插件
     * 设置 dev test 环境开启
     * @return
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        PerformanceMonitorInterceptor performanceMonitorInterceptor = new PerformanceMonitorInterceptor();
        return performanceMonitorInterceptor;
    }

    /**
     * 实现多租户 分页插件必备  所有条件中会加入 AND user.manager_id = 1088248166370832385
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        ArrayList<ISqlParser> sqlParsersList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean where) {
                return new LongValue(1088248166370832385L);
            }

            @Override
            public String getTenantIdColumn() {
                return "manager_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                return false;
            }
        });
        sqlParsersList.add(tenantSqlParser);
        /**
         * 可以在Mapper方法上加入 @SqlParser(filter = true) 解决 效果一样 {@link UserMapper}
         */
        /*paginationInterceptor.setSqlParserList(sqlParsersList);
        //com.java8.dao.UserMapper.mySelectList 不增加 AND user.manager_id = 1088248166370832385
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                MappedStatement mappedStatement = SqlParserHelper.getMappedStatement(metaObject);
                if("com.java8.dao.UserMapper.mySelectList".equals(mappedStatement.getId())){
                    return true;
                }
                return false;
            }
        });*/
        return paginationInterceptor;
    }
}
