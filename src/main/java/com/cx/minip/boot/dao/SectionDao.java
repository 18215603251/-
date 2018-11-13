package com.cx.minip.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cx.minip.boot.domain.Section;

// 第一个参数, 泛型填写要查询的实体类型, 第二个参数实体对应表的主键
// JpaRepository封装了数据库查询的简单方法
// 如果要做没有的查询, 则写Query注解
public interface SectionDao extends JpaRepository<Section, Integer> {

	// findBy是默认规则, 其后面是条件, 比如这里按title查询, findBy后面必须是实体类的属性(但每个属性首字母变大写)
	public List<Section> findByTitle(String title);

	// findBy后面有多个条件, 用and连接, 如果是 或者 就用or连接
	public List<Section> findByTitleAndSid(String title, Integer sid);

	// 如果使用了注解, 则不按照默认规则(findBy)查询, 参数写在冒号开
	// @Query(":pid")
	// public List<Section> selectPidIsNull(Integer pid);
	
	// boolean exists(ID id);			//根据id判断实体是否存在
	// T save(T entity);             	//保存单个实体
	// Iterable<T> save(Iterable<? extends T> entities);	//保存集合
	// T findOne(ID id);             	//根据id查找实体
	// boolean exists(ID id);        	//根据id判断实体是否存在
	// long count();					//查询实体数量
	// void delete(ID id);				//根据Id删除实体
}
