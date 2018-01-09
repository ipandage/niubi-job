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


package com.zuoxiaolong.niubi.job.api;

import com.zuoxiaolong.niubi.job.api.data.StandbyJobData;

import java.util.List;

/**
 * 主备模式下Job节点操作API
 *
 * @author Xiaolong Zuo
 * @since 0.9.3
 */
public interface StandbyJobApi {
    /**
     * 获得所有job
     * @return
     */
    List<StandbyJobData> getAllJobs();

    /**
     * 保存job
     * @param group
     * @param name
     * @param data
     */
    void saveJob(String group, String name, StandbyJobData.Data data);

    /**
     * 更新job
     * @param group
     * @param name
     * @param data
     */
    void updateJob(String group, String name, StandbyJobData.Data data);

    /**
     * 获得job 通过group和name
     * @param group
     * @param name
     * @return
     */
    StandbyJobData getJob(String group, String name);

    /**
     * 获得job通过路径
     * @param path
     * @return
     */
    StandbyJobData getJob(String path);

}
