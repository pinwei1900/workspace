package com.xuanwu.mos.rest.repo;

import com.xuanwu.mos.db.GsmsMybatisEntityRepository;
import com.xuanwu.mos.domain.entity.Carrier;
import com.xuanwu.mos.domain.entity.CarrierPrice;
import com.xuanwu.mos.domain.entity.CarrierTeleseg;
import com.xuanwu.mos.domain.entity.MsgTicket;
import com.xuanwu.mos.dto.QueryParameters;
import com.xuanwu.mos.utils.ListUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiang.Ziyuan on 2017/3/23.
 */
@Repository
public class CarrierRepo extends GsmsMybatisEntityRepository<Carrier> {
    private static final Logger logger = LoggerFactory.getLogger(CarrierRepo.class);
    @Override
    protected String namesapceForSqlId() {
        return "com.xuanwu.mos.mapper.CarrierMapper";
    }
}
