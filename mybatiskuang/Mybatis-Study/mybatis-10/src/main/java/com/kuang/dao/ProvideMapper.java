package com.kuang.dao;

import com.kuang.pojo.Provide;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ProvideMapper {

    //增加用户信息
    public int add(@Param("provider") Provide provider);

    //通过条件查询providerList
    public List<Provide> getProviderList(@Param("proName") String proName,
                                         @Param("proCode") String proCode,
                                         @Param("from") Integer currentPageNo,
                                         @Param("pageSize") Integer pageSize);

    //获取供应商列表
    public List<Provide> getProList();

    //通过条件查询供应商记录数
    public int getProviderCount(@Param("proName") String proName,
                                @Param("proCode") String proCode);

    //通过供应商Id删除供应商信息
    public int deleteProviderById(@Param("id") Integer delId);

    //根据供应商Id获取供应商信息
    public Provide getProviderById(@Param("id") Integer id);

    //修改供应商
    public int modify(Provide provider);

}
