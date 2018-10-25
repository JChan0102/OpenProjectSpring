package com.openproject.visitorMessage.dao;


import com.openproject.jdbc.JdbcUtil;
import com.openproject.visitorMessage.model.VisitorMessageVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
@Repository
public class MybatisVisitorMessageDAO {

@Autowired
private SqlSessionTemplate sqlSessionTemplate;
private String mapperPath="mapper.VisitorMessageMapper";

    public int insert (VisitorMessageVO message)  {
      return sqlSessionTemplate.update(mapperPath+".insert",message);
    }
    public int selectListCount (){

       return sqlSessionTemplate.selectOne(mapperPath+".selectListCount");

    }
    public List<VisitorMessageVO> selectList(int firstRow, int endRow) throws SQLException {
        Map<String,Integer> param = new HashMap<>();
        param.put("firstRow",firstRow);
        param.put("endRow",endRow);

        return sqlSessionTemplate.selectList(mapperPath+".selectList",param);
    }


    public int delete(int messageId) {
            return sqlSessionTemplate.delete(mapperPath+".delete",messageId);
    }
    public VisitorMessageVO select(int messageId){

        return sqlSessionTemplate.selectOne(mapperPath+".select",messageId);

    }

}
