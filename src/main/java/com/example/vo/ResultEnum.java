package com.example.vo;

public enum ResultEnum implements BaseErrorInfo{
    SUCCESS("200","成功"),
    ERROR("500","系统错误"),
    MISSINGSERVLETREQUESTPARAMETER("1001","Servlet缺少必要参数"),
    MISSINGPARAMTERBODY("1002","缺少请求体"),
    BINDENTITYERROR("1003","实体对象传参绑定方法参数错误"),
    METHODARGUMENTERROR("1004","实体对象请求体传参异常:方法参数无效"),
    UPDATEERROR("2001","更新业务错误"),
    SAVEERROR("2002","数据新增业务错误"),
    DELETEERROR("2003","数据删除业务错误"),
    SEARCHERROR("2004","数据搜索业务错误"),
    SEARCHNOTFOUND("2005","没有搜索到结果"),
    MISSINGPARAMS("2006","缺少必要参数"),
    PARAMSDOMAINERROR("2007","参数不符合条件"),
    HAVENOTRETURNED("2008","有书籍未归还"),
    BORROWFAILED("2009","借阅失败"),
    DECREASEFAILED("2010","减少书籍失败"),
    INCREASEFAILED("2011","增加书籍失败"),
    ALTERFAILED("2012","修改书籍数量失败"),
    RETURNFAILED("2013","归还书籍失败"),
    ADDSTORAGEFAILED("2014","新增库存记录失败"),
    NEWBOOKFAILED("2015","新建书籍失败"),
    BOOKHASEXISTED("2016","该书籍已存在"),
    ALTERCANNOTZERO("2017","数量调整不能没变化"),
    STOCKNOTENOUGH("2018","当前库存不足"),
    USERNAMEHASEXISTED("2019","用户名已存在"),
    WECHATIDBIND("2020","微信账号已绑定"),
    CREATEUSERFAILED("2021","新建用户失败"),
    USERNOTEXISTORPWDERROR("2022","用户不存在或者密码错误"),
    SENTINELLIMIT("2100","sentinel流控规则限流"),
    SENTINEDEGRAGE("2101","sentinel降级"),
    SUFFIXERROR("2200","文件类型不正确")
    ;

    private String code;
    private String msg;
    ResultEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取错误码
     * @return String
     */
    @Override
    public String getResultCode() {
        return code;
    }

    /**
     * 获取错误信息
     * @return String
     */
    @Override
    public String getResultMsg() {
        return msg;
    }
}
