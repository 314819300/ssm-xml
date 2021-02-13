//package com.db.sys.dao.impl;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.db.sys.dao.SysLogDao;
//import com.db.sys.entity.SysLog;
///**
// * 
// * @author acer
// * @Repository 一般用于修饰数据层对象，并且告诉spring此对象交给spring管理
// *
// */
//@Repository
//public class SysLogDaoImpl implements SysLogDao {
//
//	@Autowired
//	private SqlSessionFactory sqlSessionFactory;
//	@Override
//	public List<SysLog> findObjects() {
//		//借助mybatis
//		//1.获取SqlSession对象
//		SqlSession session = sqlSessionFactory.openSession();
//		//2.基于Sqlsession对象执行查询操作
////		List<SysLog> list = session.selectList("com.db.sys.dao.SysLogDao.findObjects");
//		SysLogDao dao = session.getMapper(SysLogDao.class);
//		List<SysLog> list = dao.findObjects();
//		System.out.println(dao.getClass());
//		session.close();
//		//3.释放SqlSession对象
//		//4.返回查询结果
//		return list;
//	}
//	@Override
//	public int getRowCount(String username) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
