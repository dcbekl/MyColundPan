package com.easypan.service;


import com.easypan.entity.po.EmailCode;
import com.easypan.entity.query.EmailCodeQuery;
import com.easypan.entity.vo.PaginationResultVO;

import javax.mail.internet.MimeMessage;
import java.util.List;


/**
 * 邮箱验证码 业务接口
 */
public interface EmailCodeService {

    /**
     * 根据条件查询列表
     */
    List<EmailCode> findListByParam(EmailCodeQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(EmailCodeQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<EmailCode> findListByPage(EmailCodeQuery param);

    /**
     * 新增
     */
    Integer add(EmailCode bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<EmailCode> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<EmailCode> listBean);

    /**
     * 根据EmailAndCode查询对象
     */
    EmailCode getEmailCodeByEmailAndCode(String email, String code);


    /**
     * 根据EmailAndCode修改
     */
    Integer updateEmailCodeByEmailAndCode(EmailCode bean, String email, String code);


    /**
     * 根据EmailAndCode删除
     */
    Integer deleteEmailCodeByEmailAndCode(String email, String code);

    void sendEmailCode(String email, Integer type);

    void sendMailCode(String toEmail, String code);

    /**
     * 检查邮箱对应的验证码是否正确，验证码是否有效
     *
     * 判断验证码是否过期的逻辑：
     *      用当前时间 - 从数据库中查出验证码的创建时间，获得验证码的发送时间。然后判断是否超过验证码的有效时间
     * */
    void checkCode(String email, String code);

}