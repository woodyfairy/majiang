package com.dyz.myBatis.daoImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.myBatis.dao.AccountMapper;
import com.dyz.myBatis.dao.PaymentMapper;
import com.dyz.myBatis.model.Payment;
import com.dyz.myBatis.model.PaymentExample;

public class PaymentDaoImp implements PaymentMapper{
	private SqlSessionFactory sqlSessionFactory;
    public PaymentDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

	@Override
	public int countByExample(PaymentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(PaymentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String ordernum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Payment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Payment record) {
		int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PaymentMapper mapper = sqlSession.getMapper(PaymentMapper.class);
            flag = mapper.insert(record);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return flag;
	}

	@Override
	public List<Payment> selectByExample(PaymentExample example) {
		List<Payment> result = null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            PaymentMapper mapper = sqlSession.getMapper(PaymentMapper.class);
            result = mapper.selectByExample(example);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
	}

	@Override
	public Payment selectByPrimaryKey(String ordernum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(Payment record, PaymentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(Payment record, PaymentExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Payment record) {
		int flag = 0;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PaymentMapper mapper = null;
        try{
            mapper = sqlSession.getMapper(PaymentMapper.class);
            flag = mapper.updateByPrimaryKeySelective(record);
            sqlSession.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return flag;
	}

	@Override
	public int updateByPrimaryKey(Payment record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
