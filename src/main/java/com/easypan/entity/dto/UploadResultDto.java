package com.easypan.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 文件上传结果对象
 * fileId ： 文件唯一标识符id
 * status ： 状态
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadResultDto implements Serializable {
    private String fileId;
    private String status;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
