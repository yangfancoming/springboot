package com.goat.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/2/27.
 *
 * @ Description: doit  mybatis plus 通用 service 在项目中该如何实现？
 * @ author  山羊来了
 * @ date 2019/2/27---11:24
 */
public class BaseService implements IService {
    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean save(Object entity) {
        return false;
    }

    /**
     * <p>
     * 插入（批量），该方法不适合 Oracle
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveBatch(Collection entityList) {
        return false;
    }

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    @Override
    public boolean saveBatch(Collection entityList, int batchSize) {
        return false;
    }

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveOrUpdateBatch(Collection entityList) {
        return false;
    }

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    public boolean saveOrUpdateBatch(Collection entityList, int batchSize) {
        return false;
    }

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    /**
     * <p>
     * 根据 entity 条件，删除记录
     * </p>
     *
     * @param queryWrapper 实体包装类 {@link QueryWrapper}
     */
    @Override
    public boolean remove(Wrapper queryWrapper) {
        return false;
    }

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean updateById(Object entity) {
        return false;
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象
     * @param updateWrapper 实体对象封装操作类 {@link UpdateWrapper}
     */
    @Override
    public boolean update(Object entity, Wrapper updateWrapper) {
        return false;
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean updateBatchById(Collection entityList) {
        return false;
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    public boolean updateBatchById(Collection entityList, int batchSize) {
        return false;
    }

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean saveOrUpdate(Object entity) {
        return false;
    }

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    @Override
    public boolean removeByIds(Collection idList) {
        return false;
    }

    /**
     * <p>
     * 根据 columnMap 条件，删除记录
     * </p>
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public boolean removeByMap(Map columnMap) {
        return false;
    }

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public Object getById(Serializable id) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public Object getOne(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public Map<String, Object> getMap(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper，查询一条记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public Object getObj(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public int count(Wrapper queryWrapper) {
        return 0;
    }

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List list(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 翻页查询
     * </p>
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public IPage page(IPage page, Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List<Map<String, Object>> listMaps(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public List<Object> listObjs(Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 翻页查询
     * </p>
     *
     * @param page         翻页对象
     * @param queryWrapper 实体对象封装操作类 {@link QueryWrapper}
     */
    @Override
    public IPage<Map<String, Object>> pageMaps(IPage page, Wrapper queryWrapper) {
        return null;
    }

    /**
     * <p>
     * 查询（根据 columnMap 条件）
     * </p>
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public Collection listByMap(Map columnMap) {
        return null;
    }

    /**
     * <p>
     * 查询（根据ID 批量查询）
     * </p>
     *
     * @param idList 主键ID列表
     */
    @Override
    public Collection listByIds(Collection idList) {
        return null;
    }
}
