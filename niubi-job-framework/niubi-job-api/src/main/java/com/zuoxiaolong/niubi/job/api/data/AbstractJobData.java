/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.zuoxiaolong.niubi.job.api.data;

import com.zuoxiaolong.niubi.job.core.helper.StringHelper;

/**
 * ZK Job数据节点抽象类
 *
 * @author Xiaolong Zuo
 * @since 0.9.3
 */
public abstract class AbstractJobData<T extends AbstractJobData> implements Comparable<T> {
    // 组名称
    private String groupName;

    // job名称
    private String jobName;

    // jar文件名称
    private String jarFileName;

    // 扫描的包
    private String packagesToScan;

    // job的cron表达式
    private String jobCron;

    // 容器类型
    private String containerType = "Common";

    // job状态
    private String jobState = "Shutdown";

    // 失效策略
    private String misfirePolicy = "None";

    // job操作日志Id
    private String jobOperationLogId;

    // 操作结果
    private String operationResult;

    // 原始jar文件名称
    private String originalJarFileName;

    // job操作
    private String jobOperation;

    // 版本
    private Long version;

    // 错误信息
    private String errorMessage;

    // 自增版本号
    public void incrementVersion() {
        if (version == null || version == Long.MAX_VALUE) {
            this.version = 1L;
        } else {
            this.version++;
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJarFileName() {
        return jarFileName;
    }

    public void setJarFileName(String jarFileName) {
        this.jarFileName = jarFileName;
    }

    public String getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }

    public String getJobOperationLogId() {
        return jobOperationLogId;
    }

    public void setJobOperationLogId(String jobOperationLogId) {
        this.jobOperationLogId = jobOperationLogId;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getOriginalJarFileName() {
        return originalJarFileName;
    }

    public void setOriginalJarFileName(String originalJarFileName) {
        this.originalJarFileName = originalJarFileName;
    }

    public String getJobOperation() {
        return jobOperation;
    }

    public void setJobOperation(String jobOperation) {
        this.jobOperation = jobOperation;
    }

    @Override
    public int compareTo(AbstractJobData data) {
        return (groupName + "." + jobName).compareTo(data.getGroupName() + "." + data.getJobName());
    }

    /**
     * 准备操作
     */
    public void prepareOperation() {
        this.operationResult = "Waiting";
        this.errorMessage = null;
    }

    /**
     * 清除操作日志
     */
    public void clearOperationLog() {
        this.jobOperationLogId = null;
        this.operationResult = null;
        this.errorMessage = null;
    }

    /**
     * 是否操作了
     * @return
     */
    public boolean isOperated() {
        return StringHelper.isEmpty(this.jobOperation) && StringHelper.isEmpty(this.originalJarFileName)
                && this.operationResult != null && !this.operationResult.equals("Waiting");
    }

    /**
     * 初始化
     */
    public void init() {
        setJobState("Shutdown");
        setJobOperation(null);
        setOriginalJarFileName(null);
        setOperationResult("Success");
    }

    /**
     * 操作成功
     */
    public void operateSuccess() {
        this.operationResult = "Success";
        this.jobOperation = null;
        this.originalJarFileName = null;
    }

    /**
     * 操作失败
     * @param errorMessage
     */
    public void operateFailed(String errorMessage) {
        this.operationResult = "Failed";
        this.errorMessage = errorMessage;
        this.jobOperation = null;
        this.originalJarFileName = null;
    }

    /**
     * 是否是spring容器
     * @return
     */
    public boolean isSpring() {
        return containerType != null && containerType.equals("Spring");
    }

    /**
     * 是否开始
     * @return
     */
    public boolean isStart() {
        return jobOperation != null && jobOperation.equals("Start");
    }

    /**
     * 是否启动
     * @return
     */
    public boolean isStartup() {
        return jobState != null && jobState.equals("Startup");
    }

    /**
     * 是否重启
     * @return
     */
    public boolean isRestart() {
        return jobOperation != null && jobOperation.equals("Restart");
    }

    /**
     * 是否停止
     * @return
     */
    public boolean isPause() {
        return jobOperation != null && jobOperation.equals("Pause");
    }

    /**
     * 是否是未知操作
     * @return
     */
    public boolean isUnknownOperation() {
        return !isStart() && !isRestart() && !isPause();
    }

    @Override
    public String toString() {
        return "JobData {" +
                "groupName='" + groupName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jarFileName='" + jarFileName + '\'' +
                ", packagesToScan='" + packagesToScan + '\'' +
                ", jobCron='" + jobCron + '\'' +
                ", containerType='" + containerType + '\'' +
                ", jobState='" + jobState + '\'' +
                ", misfirePolicy='" + misfirePolicy + '\'' +
                ", jobOperationLogId='" + jobOperationLogId + '\'' +
                ", operationResult='" + operationResult + '\'' +
                ", originalJarFileName='" + originalJarFileName + '\'' +
                ", jobOperation='" + jobOperation + '\'' +
                ", version=" + version +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
