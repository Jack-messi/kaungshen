package com.kuang.dao;


import com.kuang.pojo.Bill;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testgetAllBill() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> allBill2 = mapper.getAllBill();
        for (Bill bill : allBill2) {
            System.out.println(bill);
        }
        sqlSession.close();
    }

    @Test
    public void testgetBillCountByProviderId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCount = mapper.getBillCountByProviderId(2);
        System.out.println(billCount);
        sqlSession.close();
    }

    @Test
    public void testadd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        Bill bill = new Bill();
        bill.setId(19);
        bill.setBillCode("BILL2016_018");
        bill.setProductName("肯打鸡");
        bill.setProductDesc("食品");
        bill.setProductUnit("块");
        bill.setProductCount(new BigDecimal(3232));
        bill.setTotalPrice(new BigDecimal(321));
        bill.setIsPayment(1);
        bill.setProviderId(3);
        bill.setCreatedBy(1);
        bill.setCreationDate(new Date());
//        bill.setModifyBy();


        int add = mapper.add(bill);

        System.out.println(add);

        sqlSession.close();
    }

    @Test
    public void testgetBillList() {
        SqlSession sqlSession  = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        List<Bill> billList = mapper.getBillList("米", "", "", 0,2);
        for (Bill bill : billList) {
            System.out.println(bill);
        }

    }

    @Test
    public void testgetBillCount()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCount = mapper.getBillCount("", 1, 1);
        System.out.println(billCount);
    }


}
