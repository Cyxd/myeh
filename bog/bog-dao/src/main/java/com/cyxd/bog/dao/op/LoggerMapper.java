package com.cyxd.bog.dao.op;

import java.util.List;

import com.cyxd.bog.base.dao.BaseDao;
import com.cyxd.bog.model.op.Logger;

public interface LoggerMapper extends BaseDao<Logger>{

    List<Logger> baseList();

}
