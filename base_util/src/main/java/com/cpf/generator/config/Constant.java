package com.cpf.generator.config;

import org.springframework.boot.configurationprocessor.json.JSONObject;

public class Constant {

    //演示系统账户
    public static String DEMO_ACCOUNT = "test";
    //自动去除表前缀
    public static String AUTO_REOMVE_PRE = "true";
    //停止计划任务
    public static String STATUS_RUNNING_STOP = "stop";
    //开启计划任务
    public static String STATUS_RUNNING_START = "start";
    //通知公告阅读状态-未读
    public static String OA_NOTIFY_READ_NO = "0";
    //通知公告阅读状态-已读
    public static int OA_NOTIFY_READ_YES = 1;
    //部门根节点id
    public static Long DEPT_ROOT_ID = 0l;
    //缓存方式
    public static String CACHE_TYPE_REDIS = "redis";

    public static String LOG_ERROR = "error";

    /**
     * Session
     */
    public static final String SESSION = "session";
    /**
     * SessionId
     */
    public static final String SESSIONID = "sessionid";
    /**
     * token
     */
    public static final String TOKEN = "token";

    /**
     * Session对象Key, 用户id
     */
    public static final String SKEY_ACCOUNT_ID = "accountId";

    /**
     * sock 频道map
     */
    public static final String DESTINATION_MAP = "destinationMap";
    /**
     * sock 频道参数map
     */
    public static final String DESTINATION_PARAMS_MAP = "destinationParamsMap";
    /**
     * sock 频道参数-名称
     */
    public static final String DESTINATION_PARAMS_NAME = "name";
    /**
     * sock 频道参数-线路
     */
    public static final String DESTINATION_PARAMS_LINE = "lineId";
    /**
     * sock 频道参数-车
     */
    public static final String DESTINATION_PARAMS_TRAIN = "train";
    /**
     * sock 频道参数-类型
     */
    public static final String DESTINATION_PARAMS_TYPE = "type";
    /**
     * sock task频道
     */
    public static final String TASK_DESTINATION = "task";
    /**
     * sock user频道
     */
    public static final String USER_DESTINATION = "/user";

    /**
     * sock subWayTree频道
     */
    public static final String SUBWAY_TREE_DESTINATION = "/subWayTree";
    /**
     * sock subWay频道
     */
    public static final String SUBWAY_DESTINATION = "/subWay";

    /**
     * sock 全局频道
     */
    public static final String GLOBEL_MONOTORING = "/globelMonitoring";

    /**
     * sock 全局频道
     */
    public static final String TRAIN_MONOTORING = "/trainMonitoring";

    /**
     * 地图图数据
     */
    public static JSONObject subWayData;


}
