/*
* Healthyorder.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.fendo.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title HEALTHYORDER表的实体类
 * @Description null
 * @version 1.0
 * @Author fendo
 * @Date 2017-12-02 19:47:34
 */
public class Healthyorder extends BaseModel implements Serializable {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields usrid 患者id
     */
    private String usrid;

    /**
     * @Fields docid 医生id
     */
    private String docid;

    /**
     * @Fields ordercode 系统订单编号
     */
    private String ordercode;

    /**
     * @Fields thirdordercode 第三方订单编号
     */
    private String thirdordercode;

    /**
     * @Fields paymentmethod 支付方式(微信、支付宝)1,2
     */
    private String paymentmethod;

    /**
     * @Fields consultationmethod  咨询方式（图文、语音、视频）2,3,4
     */
    private String consultationmethod;

    /**
     * @Fields orderamount 订单金额
     */
    private String orderamount;

    /**
     * @Fields orderstate 订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8)
     */
    private String orderstate;

    /**
     * @Fields consultingdescription 咨询问题描述
     */
    private String consultingdescription;

    /**
     * @Fields createdate 创建时间
     */
    private Date createdate;

    /**
     * @Fields createname 创建人
     */
    private String createname;

    /**
     * @Fields updatename 更新人
     */
    private String updatename;

    /**
     * @Fields updatedate 更新时间
     */
    private Date updatedate;

    /**
     * @Fields state 删除标记位
     */
    private String state;

    /**
     * @Fields reservationphotoid 预约图片id
     */
    private String reservationphotoid;

    /**
     * @Fields reservationdate 预约日期//2017-09-21 
     */
    private String reservationdate;

    /**
     * @Fields reservationperiod 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29
     */
    private String reservationperiod;

    /**
     * @Fields reservationtime 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29
     */
    private String reservationtime;

    /**
     * @Fields usrphone  患者联系方式
     */
    private String usrphone;

    /**
     * @Fields pathcode 订单图片FTP路径ID
     */
    private String pathcode;

    /**
     * @Fields invoicestate 订单表中的发票状态字段 0未开票 1已开票
     */
    private String invoicestate;

    /**
     * @Fields usrname 患者姓名---------------新增 by 2017-10-29
     */
    private String usrname;

    /**
     * @Fields usrsex 患者性别---------------新增 by 2017-10-29
     */
    private String usrsex;

    /**
     * @Fields usrbirth 患者出生年月---------------新增 by 2017-10-29
     */
    private String usrbirth;

    /**
     * @Fields reserstarttime 预约开始时间---------------新增 by 2017-10-29
     */
    private String reserstarttime;

    /**
     * @Fields reserendtime 预约结束时间  ---------------新增 by 2017-10-29
     */
    private String reserendtime;

    /**
     * @Fields sendflag 支付成功短信提示标志(0 未发送 1 已发送)
     */
    private String sendflag;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键 字段:HEALTHYORDER.ID
     *
     * @return HEALTHYORDER.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTHYORDER.ID
     *
     * @param id the value for HEALTHYORDER.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 患者id 字段:HEALTHYORDER.USRID
     *
     * @return HEALTHYORDER.USRID, 患者id
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 患者id 字段:HEALTHYORDER.USRID
     *
     * @param usrid the value for HEALTHYORDER.USRID, 患者id
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 医生id 字段:HEALTHYORDER.DOCID
     *
     * @return HEALTHYORDER.DOCID, 医生id
     */
    public String getDocid() {
        return docid;
    }

    /**
     * 设置 医生id 字段:HEALTHYORDER.DOCID
     *
     * @param docid the value for HEALTHYORDER.DOCID, 医生id
     */
    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    /**
     * 获取 系统订单编号 字段:HEALTHYORDER.ORDERCODE
     *
     * @return HEALTHYORDER.ORDERCODE, 系统订单编号
     */
    public String getOrdercode() {
        return ordercode;
    }

    /**
     * 设置 系统订单编号 字段:HEALTHYORDER.ORDERCODE
     *
     * @param ordercode the value for HEALTHYORDER.ORDERCODE, 系统订单编号
     */
    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    /**
     * 获取 第三方订单编号 字段:HEALTHYORDER.THIRDORDERCODE
     *
     * @return HEALTHYORDER.THIRDORDERCODE, 第三方订单编号
     */
    public String getThirdordercode() {
        return thirdordercode;
    }

    /**
     * 设置 第三方订单编号 字段:HEALTHYORDER.THIRDORDERCODE
     *
     * @param thirdordercode the value for HEALTHYORDER.THIRDORDERCODE, 第三方订单编号
     */
    public void setThirdordercode(String thirdordercode) {
        this.thirdordercode = thirdordercode == null ? null : thirdordercode.trim();
    }

    /**
     * 获取 支付方式(微信、支付宝)1,2 字段:HEALTHYORDER.PAYMENTMETHOD
     *
     * @return HEALTHYORDER.PAYMENTMETHOD, 支付方式(微信、支付宝)1,2
     */
    public String getPaymentmethod() {
        return paymentmethod;
    }

    /**
     * 设置 支付方式(微信、支付宝)1,2 字段:HEALTHYORDER.PAYMENTMETHOD
     *
     * @param paymentmethod the value for HEALTHYORDER.PAYMENTMETHOD, 支付方式(微信、支付宝)1,2
     */
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod == null ? null : paymentmethod.trim();
    }

    /**
     * 获取  咨询方式（图文、语音、视频）2,3,4 字段:HEALTHYORDER.CONSULTATIONMETHOD
     *
     * @return HEALTHYORDER.CONSULTATIONMETHOD,  咨询方式（图文、语音、视频）2,3,4
     */
    public String getConsultationmethod() {
        return consultationmethod;
    }

    /**
     * 设置  咨询方式（图文、语音、视频）2,3,4 字段:HEALTHYORDER.CONSULTATIONMETHOD
     *
     * @param consultationmethod the value for HEALTHYORDER.CONSULTATIONMETHOD,  咨询方式（图文、语音、视频）2,3,4
     */
    public void setConsultationmethod(String consultationmethod) {
        this.consultationmethod = consultationmethod == null ? null : consultationmethod.trim();
    }

    /**
     * 获取 订单金额 字段:HEALTHYORDER.ORDERAMOUNT
     *
     * @return HEALTHYORDER.ORDERAMOUNT, 订单金额
     */
    public String getOrderamount() {
        return orderamount;
    }

    /**
     * 设置 订单金额 字段:HEALTHYORDER.ORDERAMOUNT
     *
     * @param orderamount the value for HEALTHYORDER.ORDERAMOUNT, 订单金额
     */
    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount == null ? null : orderamount.trim();
    }

    /**
     * 获取 订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8) 字段:HEALTHYORDER.ORDERSTATE
     *
     * @return HEALTHYORDER.ORDERSTATE, 订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8)
     */
    public String getOrderstate() {
        return orderstate;
    }

    /**
     * 设置 订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8) 字段:HEALTHYORDER.ORDERSTATE
     *
     * @param orderstate the value for HEALTHYORDER.ORDERSTATE, 订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8)
     */
    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate == null ? null : orderstate.trim();
    }

    /**
     * 获取 咨询问题描述 字段:HEALTHYORDER.CONSULTINGDESCRIPTION
     *
     * @return HEALTHYORDER.CONSULTINGDESCRIPTION, 咨询问题描述
     */
    public String getConsultingdescription() {
        return consultingdescription;
    }

    /**
     * 设置 咨询问题描述 字段:HEALTHYORDER.CONSULTINGDESCRIPTION
     *
     * @param consultingdescription the value for HEALTHYORDER.CONSULTINGDESCRIPTION, 咨询问题描述
     */
    public void setConsultingdescription(String consultingdescription) {
        this.consultingdescription = consultingdescription == null ? null : consultingdescription.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTHYORDER.CREATEDATE
     *
     * @return HEALTHYORDER.CREATEDATE, 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:HEALTHYORDER.CREATEDATE
     *
     * @param createdate the value for HEALTHYORDER.CREATEDATE, 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:HEALTHYORDER.CREATENAME
     *
     * @return HEALTHYORDER.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:HEALTHYORDER.CREATENAME
     *
     * @param createname the value for HEALTHYORDER.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新人 字段:HEALTHYORDER.UPDATENAME
     *
     * @return HEALTHYORDER.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:HEALTHYORDER.UPDATENAME
     *
     * @param updatename the value for HEALTHYORDER.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTHYORDER.UPDATEDATE
     *
     * @return HEALTHYORDER.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:HEALTHYORDER.UPDATEDATE
     *
     * @param updatedate the value for HEALTHYORDER.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 删除标记位 字段:HEALTHYORDER.STATE
     *
     * @return HEALTHYORDER.STATE, 删除标记位
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 字段:HEALTHYORDER.STATE
     *
     * @param state the value for HEALTHYORDER.STATE, 删除标记位
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 预约图片id 字段:HEALTHYORDER.RESERVATIONPHOTOID
     *
     * @return HEALTHYORDER.RESERVATIONPHOTOID, 预约图片id
     */
    public String getReservationphotoid() {
        return reservationphotoid;
    }

    /**
     * 设置 预约图片id 字段:HEALTHYORDER.RESERVATIONPHOTOID
     *
     * @param reservationphotoid the value for HEALTHYORDER.RESERVATIONPHOTOID, 预约图片id
     */
    public void setReservationphotoid(String reservationphotoid) {
        this.reservationphotoid = reservationphotoid == null ? null : reservationphotoid.trim();
    }

    /**
     * 获取 预约日期//2017-09-21  字段:HEALTHYORDER.RESERVATIONDATE
     *
     * @return HEALTHYORDER.RESERVATIONDATE, 预约日期//2017-09-21 
     */
    public String getReservationdate() {
        return reservationdate;
    }

    /**
     * 设置 预约日期//2017-09-21  字段:HEALTHYORDER.RESERVATIONDATE
     *
     * @param reservationdate the value for HEALTHYORDER.RESERVATIONDATE, 预约日期//2017-09-21 
     */
    public void setReservationdate(String reservationdate) {
        this.reservationdate = reservationdate == null ? null : reservationdate.trim();
    }

    /**
     * 获取 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29 字段:HEALTHYORDER.RESERVATIONPERIOD
     *
     * @return HEALTHYORDER.RESERVATIONPERIOD, 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29
     */
    public String getReservationperiod() {
        return reservationperiod;
    }

    /**
     * 设置 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29 字段:HEALTHYORDER.RESERVATIONPERIOD
     *
     * @param reservationperiod the value for HEALTHYORDER.RESERVATIONPERIOD, 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29
     */
    public void setReservationperiod(String reservationperiod) {
        this.reservationperiod = reservationperiod == null ? null : reservationperiod.trim();
    }

    /**
     * 获取 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29 字段:HEALTHYORDER.RESERVATIONTIME
     *
     * @return HEALTHYORDER.RESERVATIONTIME, 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29
     */
    public String getReservationtime() {
        return reservationtime;
    }

    /**
     * 设置 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29 字段:HEALTHYORDER.RESERVATIONTIME
     *
     * @param reservationtime the value for HEALTHYORDER.RESERVATIONTIME, 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29
     */
    public void setReservationtime(String reservationtime) {
        this.reservationtime = reservationtime == null ? null : reservationtime.trim();
    }

    /**
     * 获取  患者联系方式 字段:HEALTHYORDER.USRPHONE
     *
     * @return HEALTHYORDER.USRPHONE,  患者联系方式
     */
    public String getUsrphone() {
        return usrphone;
    }

    /**
     * 设置  患者联系方式 字段:HEALTHYORDER.USRPHONE
     *
     * @param usrphone the value for HEALTHYORDER.USRPHONE,  患者联系方式
     */
    public void setUsrphone(String usrphone) {
        this.usrphone = usrphone == null ? null : usrphone.trim();
    }

    /**
     * 获取 订单图片FTP路径ID 字段:HEALTHYORDER.PATHCODE
     *
     * @return HEALTHYORDER.PATHCODE, 订单图片FTP路径ID
     */
    public String getPathcode() {
        return pathcode;
    }

    /**
     * 设置 订单图片FTP路径ID 字段:HEALTHYORDER.PATHCODE
     *
     * @param pathcode the value for HEALTHYORDER.PATHCODE, 订单图片FTP路径ID
     */
    public void setPathcode(String pathcode) {
        this.pathcode = pathcode == null ? null : pathcode.trim();
    }

    /**
     * 获取 订单表中的发票状态字段 0未开票 1已开票 字段:HEALTHYORDER.INVOICESTATE
     *
     * @return HEALTHYORDER.INVOICESTATE, 订单表中的发票状态字段 0未开票 1已开票
     */
    public String getInvoicestate() {
        return invoicestate;
    }

    /**
     * 设置 订单表中的发票状态字段 0未开票 1已开票 字段:HEALTHYORDER.INVOICESTATE
     *
     * @param invoicestate the value for HEALTHYORDER.INVOICESTATE, 订单表中的发票状态字段 0未开票 1已开票
     */
    public void setInvoicestate(String invoicestate) {
        this.invoicestate = invoicestate == null ? null : invoicestate.trim();
    }

    /**
     * 获取 患者姓名---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRNAME
     *
     * @return HEALTHYORDER.USRNAME, 患者姓名---------------新增 by 2017-10-29
     */
    public String getUsrname() {
        return usrname;
    }

    /**
     * 设置 患者姓名---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRNAME
     *
     * @param usrname the value for HEALTHYORDER.USRNAME, 患者姓名---------------新增 by 2017-10-29
     */
    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    /**
     * 获取 患者性别---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRSEX
     *
     * @return HEALTHYORDER.USRSEX, 患者性别---------------新增 by 2017-10-29
     */
    public String getUsrsex() {
        return usrsex;
    }

    /**
     * 设置 患者性别---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRSEX
     *
     * @param usrsex the value for HEALTHYORDER.USRSEX, 患者性别---------------新增 by 2017-10-29
     */
    public void setUsrsex(String usrsex) {
        this.usrsex = usrsex == null ? null : usrsex.trim();
    }

    /**
     * 获取 患者出生年月---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRBIRTH
     *
     * @return HEALTHYORDER.USRBIRTH, 患者出生年月---------------新增 by 2017-10-29
     */
    public String getUsrbirth() {
        return usrbirth;
    }

    /**
     * 设置 患者出生年月---------------新增 by 2017-10-29 字段:HEALTHYORDER.USRBIRTH
     *
     * @param usrbirth the value for HEALTHYORDER.USRBIRTH, 患者出生年月---------------新增 by 2017-10-29
     */
    public void setUsrbirth(String usrbirth) {
        this.usrbirth = usrbirth == null ? null : usrbirth.trim();
    }

    /**
     * 获取 预约开始时间---------------新增 by 2017-10-29 字段:HEALTHYORDER.RESERSTARTTIME
     *
     * @return HEALTHYORDER.RESERSTARTTIME, 预约开始时间---------------新增 by 2017-10-29
     */
    public String getReserstarttime() {
        return reserstarttime;
    }

    /**
     * 设置 预约开始时间---------------新增 by 2017-10-29 字段:HEALTHYORDER.RESERSTARTTIME
     *
     * @param reserstarttime the value for HEALTHYORDER.RESERSTARTTIME, 预约开始时间---------------新增 by 2017-10-29
     */
    public void setReserstarttime(String reserstarttime) {
        this.reserstarttime = reserstarttime == null ? null : reserstarttime.trim();
    }

    /**
     * 获取 预约结束时间  ---------------新增 by 2017-10-29 字段:HEALTHYORDER.RESERENDTIME
     *
     * @return HEALTHYORDER.RESERENDTIME, 预约结束时间  ---------------新增 by 2017-10-29
     */
    public String getReserendtime() {
        return reserendtime;
    }

    /**
     * 设置 预约结束时间  ---------------新增 by 2017-10-29 字段:HEALTHYORDER.RESERENDTIME
     *
     * @param reserendtime the value for HEALTHYORDER.RESERENDTIME, 预约结束时间  ---------------新增 by 2017-10-29
     */
    public void setReserendtime(String reserendtime) {
        this.reserendtime = reserendtime == null ? null : reserendtime.trim();
    }

    /**
     * 获取 支付成功短信提示标志(0 未发送 1 已发送) 字段:HEALTHYORDER.SENDFLAG
     *
     * @return HEALTHYORDER.SENDFLAG, 支付成功短信提示标志(0 未发送 1 已发送)
     */
    public String getSendflag() {
        return sendflag;
    }

    /**
     * 设置 支付成功短信提示标志(0 未发送 1 已发送) 字段:HEALTHYORDER.SENDFLAG
     *
     * @param sendflag the value for HEALTHYORDER.SENDFLAG, 支付成功短信提示标志(0 未发送 1 已发送)
     */
    public void setSendflag(String sendflag) {
        this.sendflag = sendflag == null ? null : sendflag.trim();
    }

    /**
     * :HEALTHYORDER
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", usrid=").append(usrid);
        sb.append(", docid=").append(docid);
        sb.append(", ordercode=").append(ordercode);
        sb.append(", thirdordercode=").append(thirdordercode);
        sb.append(", paymentmethod=").append(paymentmethod);
        sb.append(", consultationmethod=").append(consultationmethod);
        sb.append(", orderamount=").append(orderamount);
        sb.append(", orderstate=").append(orderstate);
        sb.append(", consultingdescription=").append(consultingdescription);
        sb.append(", createdate=").append(createdate);
        sb.append(", createname=").append(createname);
        sb.append(", updatename=").append(updatename);
        sb.append(", updatedate=").append(updatedate);
        sb.append(", state=").append(state);
        sb.append(", reservationphotoid=").append(reservationphotoid);
        sb.append(", reservationdate=").append(reservationdate);
        sb.append(", reservationperiod=").append(reservationperiod);
        sb.append(", reservationtime=").append(reservationtime);
        sb.append(", usrphone=").append(usrphone);
        sb.append(", pathcode=").append(pathcode);
        sb.append(", invoicestate=").append(invoicestate);
        sb.append(", usrname=").append(usrname);
        sb.append(", usrsex=").append(usrsex);
        sb.append(", usrbirth=").append(usrbirth);
        sb.append(", reserstarttime=").append(reserstarttime);
        sb.append(", reserendtime=").append(reserendtime);
        sb.append(", sendflag=").append(sendflag);
        sb.append("]");
        return sb.toString();
    }

    /**
     * :HEALTHYORDER
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Healthyorder other = (Healthyorder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsrid() == null ? other.getUsrid() == null : this.getUsrid().equals(other.getUsrid()))
            && (this.getDocid() == null ? other.getDocid() == null : this.getDocid().equals(other.getDocid()))
            && (this.getOrdercode() == null ? other.getOrdercode() == null : this.getOrdercode().equals(other.getOrdercode()))
            && (this.getThirdordercode() == null ? other.getThirdordercode() == null : this.getThirdordercode().equals(other.getThirdordercode()))
            && (this.getPaymentmethod() == null ? other.getPaymentmethod() == null : this.getPaymentmethod().equals(other.getPaymentmethod()))
            && (this.getConsultationmethod() == null ? other.getConsultationmethod() == null : this.getConsultationmethod().equals(other.getConsultationmethod()))
            && (this.getOrderamount() == null ? other.getOrderamount() == null : this.getOrderamount().equals(other.getOrderamount()))
            && (this.getOrderstate() == null ? other.getOrderstate() == null : this.getOrderstate().equals(other.getOrderstate()))
            && (this.getConsultingdescription() == null ? other.getConsultingdescription() == null : this.getConsultingdescription().equals(other.getConsultingdescription()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getCreatename() == null ? other.getCreatename() == null : this.getCreatename().equals(other.getCreatename()))
            && (this.getUpdatename() == null ? other.getUpdatename() == null : this.getUpdatename().equals(other.getUpdatename()))
            && (this.getUpdatedate() == null ? other.getUpdatedate() == null : this.getUpdatedate().equals(other.getUpdatedate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getReservationphotoid() == null ? other.getReservationphotoid() == null : this.getReservationphotoid().equals(other.getReservationphotoid()))
            && (this.getReservationdate() == null ? other.getReservationdate() == null : this.getReservationdate().equals(other.getReservationdate()))
            && (this.getReservationperiod() == null ? other.getReservationperiod() == null : this.getReservationperiod().equals(other.getReservationperiod()))
            && (this.getReservationtime() == null ? other.getReservationtime() == null : this.getReservationtime().equals(other.getReservationtime()))
            && (this.getUsrphone() == null ? other.getUsrphone() == null : this.getUsrphone().equals(other.getUsrphone()))
            && (this.getPathcode() == null ? other.getPathcode() == null : this.getPathcode().equals(other.getPathcode()))
            && (this.getInvoicestate() == null ? other.getInvoicestate() == null : this.getInvoicestate().equals(other.getInvoicestate()))
            && (this.getUsrname() == null ? other.getUsrname() == null : this.getUsrname().equals(other.getUsrname()))
            && (this.getUsrsex() == null ? other.getUsrsex() == null : this.getUsrsex().equals(other.getUsrsex()))
            && (this.getUsrbirth() == null ? other.getUsrbirth() == null : this.getUsrbirth().equals(other.getUsrbirth()))
            && (this.getReserstarttime() == null ? other.getReserstarttime() == null : this.getReserstarttime().equals(other.getReserstarttime()))
            && (this.getReserendtime() == null ? other.getReserendtime() == null : this.getReserendtime().equals(other.getReserendtime()))
            && (this.getSendflag() == null ? other.getSendflag() == null : this.getSendflag().equals(other.getSendflag()));
    }

    /**
     * :HEALTHYORDER
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsrid() == null) ? 0 : getUsrid().hashCode());
        result = prime * result + ((getDocid() == null) ? 0 : getDocid().hashCode());
        result = prime * result + ((getOrdercode() == null) ? 0 : getOrdercode().hashCode());
        result = prime * result + ((getThirdordercode() == null) ? 0 : getThirdordercode().hashCode());
        result = prime * result + ((getPaymentmethod() == null) ? 0 : getPaymentmethod().hashCode());
        result = prime * result + ((getConsultationmethod() == null) ? 0 : getConsultationmethod().hashCode());
        result = prime * result + ((getOrderamount() == null) ? 0 : getOrderamount().hashCode());
        result = prime * result + ((getOrderstate() == null) ? 0 : getOrderstate().hashCode());
        result = prime * result + ((getConsultingdescription() == null) ? 0 : getConsultingdescription().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getCreatename() == null) ? 0 : getCreatename().hashCode());
        result = prime * result + ((getUpdatename() == null) ? 0 : getUpdatename().hashCode());
        result = prime * result + ((getUpdatedate() == null) ? 0 : getUpdatedate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getReservationphotoid() == null) ? 0 : getReservationphotoid().hashCode());
        result = prime * result + ((getReservationdate() == null) ? 0 : getReservationdate().hashCode());
        result = prime * result + ((getReservationperiod() == null) ? 0 : getReservationperiod().hashCode());
        result = prime * result + ((getReservationtime() == null) ? 0 : getReservationtime().hashCode());
        result = prime * result + ((getUsrphone() == null) ? 0 : getUsrphone().hashCode());
        result = prime * result + ((getPathcode() == null) ? 0 : getPathcode().hashCode());
        result = prime * result + ((getInvoicestate() == null) ? 0 : getInvoicestate().hashCode());
        result = prime * result + ((getUsrname() == null) ? 0 : getUsrname().hashCode());
        result = prime * result + ((getUsrsex() == null) ? 0 : getUsrsex().hashCode());
        result = prime * result + ((getUsrbirth() == null) ? 0 : getUsrbirth().hashCode());
        result = prime * result + ((getReserstarttime() == null) ? 0 : getReserstarttime().hashCode());
        result = prime * result + ((getReserendtime() == null) ? 0 : getReserendtime().hashCode());
        result = prime * result + ((getSendflag() == null) ? 0 : getSendflag().hashCode());
        return result;
    }
}