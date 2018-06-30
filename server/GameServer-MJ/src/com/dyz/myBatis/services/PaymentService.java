package com.dyz.myBatis.services;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.dyz.myBatis.dao.PaymentMapper;
import com.dyz.myBatis.daoImp.PaymentDaoImp;
import com.dyz.myBatis.model.PaymentExample;
import com.dyz.myBatis.model.Payment;

public class PaymentService {
	private PaymentMapper accMap;

    private static PaymentService paymentService = new PaymentService();

    public static PaymentService getInstance(){
        return paymentService;
    }

    public void initSetSession(SqlSessionFactory sqlSessionFactory){
        accMap = new PaymentDaoImp(sqlSessionFactory);
    }
    
    /**
     * 创建新订单
     * @param account
     * @return 插入信息表中id
     * @throws SQLException
     */
    public int createOrder(Payment payment) throws SQLException{
        int index = accMap.insertSelective(payment);
        //System.out.println("-Payment insert index->>" + index);
        return index;
    }
    
    public Payment getPayment(String orderID) throws SQLException{
    	PaymentExample paymentExample = new PaymentExample();
    	paymentExample.createCriteria().andOrdernumEqualTo(orderID);
        try {
            List<Payment> payments = accMap.selectByExample(paymentExample);
            if(payments!=null && payments.size()>0){
                return payments.get(0);
            }else{
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int updatePayment(Payment payment){
 	   int index = 0;
     try{
         index = accMap.updateByPrimaryKeySelective(payment);
     }catch (Exception e){
         System.out.println(e.getMessage());
     }
		return index;
 }
}
